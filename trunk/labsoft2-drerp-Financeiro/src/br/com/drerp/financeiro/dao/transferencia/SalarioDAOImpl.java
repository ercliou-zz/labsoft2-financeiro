package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.transferencia.Salario;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;

public class SalarioDAOImpl extends GenericDAOImpl<Salario> implements SalarioDAO {

	@SuppressWarnings("unchecked")
	public List<Salario> listarPendentes(){
		return super.session.createCriteria(Salario.class).add(Restrictions.eq("status", StatusTransferencia.PENDENTE)).list();
	}
	@SuppressWarnings("unchecked")
	public List<Salario> listarEfetuadas(){
		return session.createCriteria(Salario.class).add(Restrictions.eq("status", StatusTransferencia.EFETUADA)).list();
	}
	
}