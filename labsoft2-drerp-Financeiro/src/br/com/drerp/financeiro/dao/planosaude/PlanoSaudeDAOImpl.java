package br.com.drerp.financeiro.dao.planosaude;

import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

public class PlanoSaudeDAOImpl extends GenericDAOImpl<PlanoSaude> implements PlanoSaudeDAO{
	
	public PlanoSaude getByNome(String nome) {
		return (PlanoSaude) super.session.createCriteria(PlanoSaude.class)
				.add(Restrictions.eq("nome", nome)).uniqueResult();
	}
	
}
