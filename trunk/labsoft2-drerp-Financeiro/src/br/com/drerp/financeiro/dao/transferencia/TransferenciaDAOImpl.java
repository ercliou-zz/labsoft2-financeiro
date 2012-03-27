package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class TransferenciaDAOImpl extends GenericDAOImpl<Transferencia> implements TransferenciaDAO{

	@SuppressWarnings("unchecked")
	public List<Transferencia> listarAbertas() {
		List<Transferencia> list = super.session.createCriteria(Transferencia.class).add(Restrictions.eq("status", StatusTransferencia.PENDENTE)).list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Transferencia> listarEfetuadas() {
		return session.createCriteria(Transferencia.class).add(Restrictions.eq("status", StatusTransferencia.EFETUADA)).list();
	}

}
