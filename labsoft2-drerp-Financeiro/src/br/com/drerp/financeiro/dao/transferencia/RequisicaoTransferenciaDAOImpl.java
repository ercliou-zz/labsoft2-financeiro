package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import org.hibernate.Session;

import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class RequisicaoTransferenciaDAOImpl implements RequisicaoTransferenciaDAO{

private Session session;
	
	public void setSession(Session s){
		session = s;
	}
	
	public void save(RequisicaoTransferencia entidade) {
		session.save(entidade);
		
	}

	public void delete(RequisicaoTransferencia entidade) {
		session.delete(entidade);
	}

	public void alter(RequisicaoTransferencia entidade) {
		session.update(entidade);
	}

	public RequisicaoTransferencia getById(Long id) {
		return (RequisicaoTransferencia) session.get(RequisicaoTransferencia.class,id);
	}

	@SuppressWarnings("unchecked")
	public List<RequisicaoTransferencia> list() {
		List<RequisicaoTransferencia> list = session.createCriteria(RequisicaoTransferencia.class).list();
		return list;
	}

	
	
}
