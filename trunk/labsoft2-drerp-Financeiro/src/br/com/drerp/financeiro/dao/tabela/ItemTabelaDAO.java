package br.com.drerp.financeiro.dao.tabela;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.planosaude.Procedimento;
import br.com.drerp.financeiro.model.tabela.ItemTabela;

public interface ItemTabelaDAO extends GenericDAO<ItemTabela>{
	public ItemTabela getByProcedimento(Procedimento procedimento);
}
