package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.transferencia.ContaPagar;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;

public class ContaPagarDAOImpl extends GenericDAOImpl<ContaPagar> implements ContaPagarDAO{

	@SuppressWarnings("unchecked")
	public List<ContaPagar> listarAbertas() {
		return super.session.createCriteria(ContaPagar.class).add(Restrictions.eq("status", StatusTransferencia.PENDENTE)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ContaPagar> listarEfetuadas() {
		return session.createCriteria(ContaPagar.class).add(Restrictions.eq("status", StatusTransferencia.EFETUADA)).list();
	}

}
