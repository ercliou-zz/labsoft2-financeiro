package br.com.drerp.financeiro.business.tabela;

import java.math.BigDecimal;
import java.util.List;

import br.com.crud.util.GenericDAOFactory;
import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.tabela.ItemTabelaDAO;
import br.com.drerp.financeiro.dao.tabela.TabelaDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.planosaude.Procedimento;
import br.com.drerp.financeiro.model.tabela.ItemTabela;
import br.com.drerp.financeiro.model.tabela.Tabela;
import br.com.drerp.financeiro.model.tabela.Valor;

public class TabelaBR extends GenericBR<TabelaDAOImpl, Tabela>{
	
	private ItemTabelaDAO itemTabelaDAO;
	
	public TabelaBR() {
		super();
		this.itemTabelaDAO = (new GenericDAOFactory<ItemTabelaDAO>()).createDAO(ItemTabela.class);
	}
	
	/**
	 * Caso retorne null, significa que nao possui nenhuma instancia da entidade Valor associada ao itemTabela.
	 * @param plano
	 * @param procedimento
	 * @return
	 */
	public BigDecimal recuperarValor(PlanoSaude plano, Procedimento procedimento){
		List<Valor> valores = this.itemTabelaDAO.getByProcedimento(procedimento).getValores();
		for (Valor valor : valores) {
			if(valor.getColuna().getPlanoSaude().equals(plano)){
				return valor.getValor();
			}
		}
		return null;
	}
	
}