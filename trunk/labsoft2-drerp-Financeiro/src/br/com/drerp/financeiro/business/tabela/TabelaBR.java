package br.com.drerp.financeiro.business.tabela;

import java.math.BigDecimal;
import java.util.List;

import br.com.crud.util.GenericDAOFactory;
import br.com.drerp.financeiro.dao.tabela.ColunaDAO;
import br.com.drerp.financeiro.dao.tabela.ColunaDAOImpl;
import br.com.drerp.financeiro.dao.tabela.ItemTabelaDAO;
import br.com.drerp.financeiro.dao.tabela.ItemTabelaDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.planosaude.Procedimento;
import br.com.drerp.financeiro.model.tabela.Coluna;
import br.com.drerp.financeiro.model.tabela.ItemTabela;
import br.com.drerp.financeiro.model.tabela.Valor;

public class TabelaBR {
	
	private ItemTabelaDAO itemTabelaDAO;
	private ColunaDAO colunaDAO;
	
	public TabelaBR() {
		super();
		GenericDAOFactory<ItemTabelaDAO> factory = new GenericDAOFactory<ItemTabelaDAO>();
		itemTabelaDAO = factory.createDAO(ItemTabelaDAOImpl.class);
		GenericDAOFactory<ColunaDAO> factoryColuna = new GenericDAOFactory<ColunaDAO>();
		colunaDAO = factoryColuna.createDAO(ColunaDAOImpl.class);
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
	
	public BigDecimal recuperarValor(ItemTabela itemTabela, Coluna coluna){
		List<Valor> valores = itemTabela.getValores();
		for (Valor valor : valores) {
			if(valor.getColuna().equals(coluna)){
				return valor.getValor();
			}
		}
		return null;
	}
	
	public List<ItemTabela> listarItens(){
		return this.itemTabelaDAO.list();
	}
	
	public List<Coluna> listarColunas(){
		return this.colunaDAO.list();
	}
	
}
