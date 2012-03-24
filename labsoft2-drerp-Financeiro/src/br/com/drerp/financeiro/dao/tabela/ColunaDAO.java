package br.com.drerp.financeiro.dao.tabela;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.tabela.Coluna;

public interface ColunaDAO extends GenericDAO<Coluna>{
	public Coluna getByPlano(PlanoSaude plano);
}
