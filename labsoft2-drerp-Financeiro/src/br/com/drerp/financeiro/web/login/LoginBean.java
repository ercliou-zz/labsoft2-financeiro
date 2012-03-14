package br.com.drerp.financeiro.web.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.dao.login.LoginDAOImpl;
import br.com.drerp.financeiro.model.usuario.TiposUsuario;
import br.com.drerp.financeiro.model.usuario.Usuario;

@ManagedBean(name="LoginBean")
@RequestScoped
public class LoginBean {

	private Usuario usuario = new Usuario();
	private LoginDAOImpl loginDAO;
	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public TiposUsuario validarLogin (String login, String senha) {
		usuario = loginDAO.getTypeByLoginSenha(login, senha);
		return usuario.getTipo();
	}
	
	public void criar(){
		loginDAO.save(usuario);
	}
	
}

