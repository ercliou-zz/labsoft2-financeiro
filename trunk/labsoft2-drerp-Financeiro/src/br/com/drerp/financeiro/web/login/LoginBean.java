package br.com.drerp.financeiro.web.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.crud.util.DAOFactory;
import br.com.drerp.financeiro.dao.login.LoginDAO;
import br.com.drerp.financeiro.model.usuario.TiposUsuario;
import br.com.drerp.financeiro.model.usuario.Usuario;

@ManagedBean(name="LoginBean")
@RequestScoped
public class LoginBean {

	private Usuario usuario = new Usuario();
	private LoginDAO loginDAO;
	
	public LoginBean(){
		loginDAO = DAOFactory.createLoginDAO();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String validarLogin() {
		Usuario usuarioRetorno = loginDAO.getByLogin(usuario.getLogin());
		if (usuarioRetorno.getSenha() == null || !usuarioRetorno.getSenha().equals(usuario.getSenha())){
			return "login";
		}
		
		
		if (usuarioRetorno.getTipo().equals(TiposUsuario.GERENTE)){
			return "relatorioTransferencias";
		}
		else if (usuarioRetorno.getTipo().equals(TiposUsuario.OPERADOR)) {
			
			return "crudPlanosSaude";
		}
		else {
			return "login";
		}

	}
	
	public void criar(){
		this.usuario.setTipo(TiposUsuario.GERENTE);
		loginDAO.save(usuario);
	}
	
}

