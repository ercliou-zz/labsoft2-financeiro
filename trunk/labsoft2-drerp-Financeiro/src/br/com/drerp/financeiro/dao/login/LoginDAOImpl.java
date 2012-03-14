package br.com.drerp.financeiro.dao.login;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.StatusRequisicaoTransferencia;
import br.com.drerp.financeiro.model.usuario.TiposUsuario;
import br.com.drerp.financeiro.model.usuario.Usuario;

public class LoginDAOImpl extends GenericDAOImpl<Usuario> implements LoginDAO{
	
	public Usuario getByLogin(String login) {
		List<Usuario> list = super.session.createCriteria(Usuario.class).add(Restrictions.eq("login", login)).list();
		if (list == null || list.size() == 0) {
			Usuario usuario = new Usuario();
			usuario.setTipo(TiposUsuario.INVALIDO);
			return usuario;
		}
		else {
			return (Usuario)list.get(0);
		}
	}


}
