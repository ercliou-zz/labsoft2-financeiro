package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.transferencia.Fatura;

public class FaturaDAOImpl extends GenericDAOImpl<Fatura> implements FaturaDAO{

	@SuppressWarnings("unchecked")
	public List<Fatura> listarFaturas(PlanoSaude plano, Long dataInicial,
			Long dataFinal) {
		if (plano == null) {
			List<Fatura> list = super.session.createCriteria(Fatura.class).list();
			return list;
		}
		List<Fatura> list = super.session.createCriteria(Fatura.class).add(Restrictions.eq("planoSaude", plano)).list();
		return list;
	}
	

}
