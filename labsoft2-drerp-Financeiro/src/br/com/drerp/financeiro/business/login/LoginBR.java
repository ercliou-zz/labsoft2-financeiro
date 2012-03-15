package br.com.drerp.financeiro.business.login;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.login.LoginDAOImpl;
import br.com.drerp.financeiro.model.usuario.TiposUsuario;
import br.com.drerp.financeiro.model.usuario.Usuario;

public class LoginBR extends GenericBR<LoginDAOImpl, Usuario> {

	@Override
	public void save(Usuario usuario) {
		Long id = usuario.getId();
		if (id == null || id.equals(0)) {
			usuario.setTipo(TiposUsuario.GERENTE);
			super.dao.save(usuario);
		} else {
			super.dao.edit(usuario);
		}
	}

	public TiposUsuario validarLogin(Usuario usuario) {
		Usuario usuarioRetorno = super.dao.getByLogin(usuario.getLogin());
		if (usuarioRetorno.getSenha() == null
				|| !usuarioRetorno.getSenha().equals(usuario.getSenha())) {
			return TiposUsuario.INVALIDO;
		} else {
			return usuarioRetorno.getTipo();
		}

	}
}
