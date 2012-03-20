package br.com.drerp.financeiro.business.tabela;

import java.math.BigDecimal;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.tabela.TabelaDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.tabela.ItemTabela;
import br.com.drerp.financeiro.model.tabela.Tabela;

public class TabelaBR extends GenericBR<TabelaDAOImpl, Tabela>{
	
	public BigDecimal recuperarValor(PlanoSaude plano, ItemTabela item){
		
		return null;
	}
}
