package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import org.hibernate.Session;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class TransferenciaDAOImpl extends GenericDAOImpl<Transferencia> implements TransferenciaDAO{

	@SuppressWarnings("unchecked")
	public List<Transferencia> list() {
		List<Transferencia> list = super.session.createCriteria(Transferencia.class).list();
		return list;
	}
	
}
