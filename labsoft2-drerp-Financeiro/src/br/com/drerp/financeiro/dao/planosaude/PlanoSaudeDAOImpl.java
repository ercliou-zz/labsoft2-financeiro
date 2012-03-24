package br.com.drerp.financeiro.dao.planosaude;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

public class PlanoSaudeDAOImpl extends GenericDAOImpl<PlanoSaude> implements PlanoSaudeDAO{
	
	public PlanoSaude merge(PlanoSaude plano){
		return (PlanoSaude) session.merge(plano);
	}
}
