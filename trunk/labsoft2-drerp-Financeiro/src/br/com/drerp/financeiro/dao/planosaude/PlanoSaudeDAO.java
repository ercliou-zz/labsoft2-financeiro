package br.com.drerp.financeiro.dao.planosaude;

import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

public interface PlanoSaudeDAO extends GenericDAO<PlanoSaude>{
	public List<PlanoSaude> listarPlanosSaude();
}
