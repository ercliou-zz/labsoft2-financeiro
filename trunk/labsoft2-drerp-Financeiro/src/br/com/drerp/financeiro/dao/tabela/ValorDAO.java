package br.com.drerp.financeiro.dao.tabela;

import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.tabela.Coluna;
import br.com.drerp.financeiro.model.tabela.Valor;

public interface ValorDAO extends GenericDAO<Valor>{
	public List<Valor> listByColuna(Coluna col);
}
