package br.com.drerp.financeiro.dao.login;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.usuario.Usuario;

public interface LoginDAO extends GenericDAO<Usuario>{

	public Usuario getTypeByLoginSenha(String login, String senha);
}
