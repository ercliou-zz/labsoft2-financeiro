package br.com.drerp.financeiro.dao.login;

import java.util.List;

import org.hibernate.Session;

import br.com.drerp.financeiro.model.usuario.Usuario;

public class LoginDAOImpl implements LoginDAO{
	
private Session session;
	
	public void setSession(Session s){
		session = s;
	}

	public void save(Usuario entidade) {
		session.save(entidade);
	}

	public void delete(Usuario entidade) {
		session.delete(entidade);
	}

	public void alter(Usuario entidade) {
		session.update(entidade);
	}

	public Usuario getById(Long id) {
		return (Usuario) session.get(Usuario.class,id);
	}

	public Usuario getTypeByLoginSenha(String login, String senha) {
		return (Usuario) session.get(Usuario.class, login);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> list() {
		List<Usuario> list = session.createCriteria(Usuario.class).list();
		return list;
	}

}
