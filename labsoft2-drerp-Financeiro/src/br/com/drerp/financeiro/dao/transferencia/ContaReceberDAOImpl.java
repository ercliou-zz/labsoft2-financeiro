package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.transferencia.ContaReceber;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;

public class ContaReceberDAOImpl extends GenericDAOImpl<ContaReceber> implements ContaReceberDAO {
	
//	@SuppressWarnings("unchecked")
//	public List<ContaPagar> listarAbertas() {
//		return super.session.createCriteria(ContaPagar.class).add(Restrictions.eq("status", StatusTransferencia.PENDENTE)).list();
//	}
//	
	
	@SuppressWarnings("unchecked")
	public List<ContaReceber> listEfetuadasByPeriodo(Long inicioMillis, Long fimMillis) {
		return session.createCriteria(ContaReceber.class)
				.add(Restrictions.eq("status", StatusTransferencia.EFETUADA))
				.add(Restrictions.ge("dataRealizacaoMilis", inicioMillis))
				.add(Restrictions.lt("dataRealizacaoMilis", fimMillis))
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ContaReceber> listReceitaByPlano(PlanoSaude plano, Long inicioMillis, Long fimMillis) {
		return session.createCriteria(ContaReceber.class)
				.add(Restrictions.eq("status", StatusTransferencia.EFETUADA))
				.add(Restrictions.ge("dataRealizacaoMilis", inicioMillis))
				.add(Restrictions.lt("dataRealizacaoMilis", fimMillis))
				.createCriteria("faturas")
				.add(Restrictions.eq("planoSaude", plano))
				.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ContaReceber> listReceitaByPlanos(List<PlanoSaude> planos, Long inicioMillis, Long fimMillis) {
		Disjunction disjunction = Restrictions.disjunction();
		Criteria criteria = session.createCriteria(ContaReceber.class);
		criteria.add(Restrictions.eq("status", StatusTransferencia.EFETUADA))
		.add(Restrictions.ge("dataRealizacaoMilis", inicioMillis))
		.add(Restrictions.lt("dataRealizacaoMilis", fimMillis));
		
		for (PlanoSaude planoSaude : planos) {
			disjunction.add(Restrictions.eq("planoSaude", planoSaude));
		}
		
		criteria.createCriteria("faturas").add(disjunction);
		
		return criteria.list();
	}

}
