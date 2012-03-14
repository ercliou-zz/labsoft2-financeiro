package br.com.drerp.financeiro.dao.login;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.StatusRequisicaoTransferencia;
import br.com.drerp.financeiro.model.usuario.TiposUsuario;
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

	public Usuario getByLogin(String login) {
		List<Usuario> list = session.createCriteria(Usuario.class).add(Restrictions.eq("login", login)).list();
		if (list == null || list.size() == 0) {
			Usuario usuario = new Usuario();
			usuario.setTipo(TiposUsuario.INVALIDO);
			return usuario;
		}
		else {
			return (Usuario)list.get(0);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> list() {
		List<Usuario> list = session.createCriteria(Usuario.class).list();
		return list;
	}

}
