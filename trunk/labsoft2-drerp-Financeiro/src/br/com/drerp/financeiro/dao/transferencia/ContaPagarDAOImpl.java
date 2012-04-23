package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.transferencia.ContaPagar;
import br.com.drerp.financeiro.model.transferencia.ContaReceber;
import br.com.drerp.financeiro.model.transferencia.Departamento;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class ContaPagarDAOImpl extends GenericDAOImpl<ContaPagar> implements ContaPagarDAO{

	@SuppressWarnings("unchecked")
	public List<ContaPagar> listarAbertas() {
		return super.session.createCriteria(ContaPagar.class).add(Restrictions.eq("status", StatusTransferencia.PENDENTE)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ContaPagar> listarEfetuadas() {
		return session.createCriteria(ContaPagar.class).add(Restrictions.eq("status", StatusTransferencia.EFETUADA)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ContaPagar> listarEfetuadasByPeriodo(Long inicioMillis, Long fimMillis) {
		return session.createCriteria(ContaPagar.class)
				.add(Restrictions.ge("dataRealizacaoMilis", inicioMillis))
				.add(Restrictions.lt("dataRealizacaoMilis", fimMillis))
				.add(Restrictions.eq("status", StatusTransferencia.EFETUADA)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ContaPagar> listByDpto(Departamento dpto, Long inicioMillis, Long fimMillis) {
		return session.createCriteria(ContaPagar.class)
				.add(Restrictions.eq("status", StatusTransferencia.EFETUADA))
				.add(Restrictions.ge("dataRealizacaoMilis", inicioMillis))
				.add(Restrictions.lt("dataRealizacaoMilis", fimMillis))
				.add(Restrictions.eq("departamento", dpto)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ContaPagar> listByPeriodo(Long inicioMillis, Long fimMillis) {
		return session.createCriteria(ContaPagar.class)
				.add(Restrictions.eq("status", StatusTransferencia.EFETUADA))
				.add(Restrictions.ge("dataRealizacaoMilis", inicioMillis))
				.add(Restrictions.lt("dataRealizacaoMilis", fimMillis)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Transferencia> listTransferenciaByDptos(List<Departamento> dptos, Long inicioMillis, Long fimMillis) {
		
		Disjunction disjunction = Restrictions.disjunction();
		Criteria criteria = session.createCriteria(Transferencia.class);
		criteria.add(Restrictions.eq("status", StatusTransferencia.EFETUADA))
		.add(Restrictions.ge("dataRealizacaoMilis", inicioMillis))
		.add(Restrictions.lt("dataRealizacaoMilis", fimMillis));
		
		if(dptos!=null){
			for (Departamento dpto : dptos) {
				disjunction.add(Restrictions.eq("departamento", dpto));
			}
			
			criteria.add(disjunction);
		}
		criteria.addOrder(Order.desc("dataRealizacaoMilis"));
		
		return criteria.list();
	}

}
