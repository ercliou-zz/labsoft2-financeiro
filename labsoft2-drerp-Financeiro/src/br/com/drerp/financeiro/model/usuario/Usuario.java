package br.com.drerp.financeiro.model.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

import br.com.drerp.financeiro.dao.GenericModel;

@Entity
@Table(name="FIN_USUARIO", uniqueConstraints = {@UniqueConstraint(columnNames={"login"})})
public class Usuario extends GenericModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(unique=true)
	private String login;
	
	private String senha;
	private TiposUsuario tipo;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public TiposUsuario getTipo() {
		return tipo;
	}
	public void setTipo(TiposUsuario tipo) {
		this.tipo = tipo;
	}
	

}
