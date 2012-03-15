package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.StatusRequisicaoTransferencia;

public class RequisicaoTransferenciaDAOImpl extends GenericDAOImpl<RequisicaoTransferencia> implements RequisicaoTransferenciaDAO{

	@SuppressWarnings("unchecked")
	public List<RequisicaoTransferencia> listarAbertas() {
		List<RequisicaoTransferencia> list = super.session.createCriteria(RequisicaoTransferencia.class).add(Restrictions.eq("status", StatusRequisicaoTransferencia.ABERTA)).list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<RequisicaoTransferencia> listarAceitas() {
		return session.createCriteria(RequisicaoTransferencia.class).add(Restrictions.eq("status", StatusRequisicaoTransferencia.ACEITA)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RequisicaoTransferencia> listarEfetuadas() {
		return session.createCriteria(RequisicaoTransferencia.class).add(Restrictions.eq("status", StatusRequisicaoTransferencia.EFETUADA)).list();
	}

}
