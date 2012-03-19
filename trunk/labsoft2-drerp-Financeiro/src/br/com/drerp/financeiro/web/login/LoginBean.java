package br.com.drerp.financeiro.web.login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.login.LoginBR;
import br.com.drerp.financeiro.model.usuario.TiposUsuario;
import br.com.drerp.financeiro.model.usuario.Usuario;

@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {

	private Usuario usuario;
	private LoginBR loginBR;

	public LoginBean() {
		this.usuario = new Usuario();
		this.loginBR = new LoginBR();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String validarLogin() {
		TiposUsuario tipo = this.loginBR.validarLogin(this.usuario);

		switch (tipo) {
		case GERENTE:
			return "relatorioTransferencias";
		case OPERADOR:
			return "relatorioTransferencias";
		case INVALIDO:
			return "login";
		default:
			return "login";

		}
	}

	public String save() {
		this.loginBR.save(this.usuario);
		return "login";
	}

}
