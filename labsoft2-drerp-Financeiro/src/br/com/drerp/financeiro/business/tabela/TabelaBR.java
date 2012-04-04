package br.com.drerp.financeiro.business.tabela;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.drerp.financeiro.util.GenericDAOFactory;
import br.com.drerp.financeiro.dao.tabela.ColunaDAO;
import br.com.drerp.financeiro.dao.tabela.ColunaDAOImpl;
import br.com.drerp.financeiro.dao.tabela.ItemTabelaDAO;
import br.com.drerp.financeiro.dao.tabela.ItemTabelaDAOImpl;
import br.com.drerp.financeiro.dao.tabela.ValorDAO;
import br.com.drerp.financeiro.dao.tabela.ValorDAOImpl;
import br.com.drerp.financeiro.dao.tabela.ValorLogDAO;
import br.com.drerp.financeiro.dao.tabela.ValorLogDAOImpl;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.tabela.Coluna;
import br.com.drerp.financeiro.model.tabela.ItemTabela;
import br.com.drerp.financeiro.model.tabela.Valor;
import br.com.drerp.financeiro.model.tabela.ValorLog;

public class TabelaBR {
	
	private ItemTabelaDAO itemTabelaDAO;
	private ColunaDAO colunaDAO;
	private ValorDAO valorDAO;
	private ValorLogDAO valorLogDAO;
	
	public TabelaBR() {
		super();
		GenericDAOFactory<ItemTabelaDAO> factory = new GenericDAOFactory<ItemTabelaDAO>();
		itemTabelaDAO = factory.createDAO(ItemTabelaDAOImpl.class);
		GenericDAOFactory<ColunaDAO> factoryColuna = new GenericDAOFactory<ColunaDAO>();
		colunaDAO = factoryColuna.createDAO(ColunaDAOImpl.class);
		GenericDAOFactory<ValorDAO> factoryValor = new GenericDAOFactory<ValorDAO>();
		valorDAO = factoryValor.createDAO(ValorDAOImpl.class);
		GenericDAOFactory<ValorLogDAO> factoryValorLog = new GenericDAOFactory<ValorLogDAO>();
		valorLogDAO = factoryValorLog.createDAO(ValorLogDAOImpl.class);
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
	
	public void updateValor (Valor valor, Long colunaId, Long itemTabelaId){
		ValorLog log = new ValorLog();
		log.setDataMS((new Date()).getTime());
		log.setProcedimentoId(this.itemTabelaDAO.getById(itemTabelaId).getProcedimento().getId());
		log.setPlanoSaudeId(this.colunaDAO.getById(colunaId).getPlanoSaude().getId());
		log.setTipo(LogType.ALTERACAO);
		log.setValorAntigo(this.valorDAO.getById(valor.getId()).getValor());
		log.setValorNovo(valor.getValor());
		this.valorLogDAO.save(log);
		valor.setColuna(colunaDAO.getById(colunaId));
		valor.setItemTabela(itemTabelaDAO.getById(itemTabelaId));
		this.valorDAO.merge(valor);
	}
	
}
