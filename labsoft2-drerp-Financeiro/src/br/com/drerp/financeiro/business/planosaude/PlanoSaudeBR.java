package br.com.drerp.financeiro.business.planosaude;

import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.planosaude.PlanoSaudeDAOImpl;
import br.com.drerp.financeiro.dao.planosaude.PlanoSaudeLogDAO;
import br.com.drerp.financeiro.dao.planosaude.PlanoSaudeLogDAOImpl;
import br.com.drerp.financeiro.dao.tabela.ColunaDAO;
import br.com.drerp.financeiro.dao.tabela.ColunaDAOImpl;
import br.com.drerp.financeiro.dao.tabela.ItemTabelaDAO;
import br.com.drerp.financeiro.dao.tabela.ItemTabelaDAOImpl;
import br.com.drerp.financeiro.dao.tabela.ValorDAO;
import br.com.drerp.financeiro.dao.tabela.ValorDAOImpl;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.planosaude.PlanoSaudeLog;
import br.com.drerp.financeiro.model.tabela.Coluna;
import br.com.drerp.financeiro.model.tabela.ItemTabela;
import br.com.drerp.financeiro.model.tabela.Valor;
import br.com.drerp.financeiro.util.GenericDAOFactory;

public class PlanoSaudeBR extends GenericBR<PlanoSaudeDAOImpl, PlanoSaude>{
	private PlanoSaudeLogDAO logDAO;
	private ColunaDAO colDAO;
	private ValorDAO valorDAO;
	private ItemTabelaDAO itemTabelaDAO;

	public PlanoSaudeBR() {
		super();
		GenericDAOFactory<PlanoSaudeLogDAO> factory = new GenericDAOFactory<PlanoSaudeLogDAO>();
		logDAO = factory.createDAO(PlanoSaudeLogDAOImpl.class);
		GenericDAOFactory<ColunaDAO> factoryColuna = new GenericDAOFactory<ColunaDAO>();
		colDAO = factoryColuna.createDAO(ColunaDAOImpl.class);
		GenericDAOFactory<ValorDAO> factoryValor = new GenericDAOFactory<ValorDAO>();
		valorDAO = factoryValor.createDAO(ValorDAOImpl.class);
		GenericDAOFactory<ItemTabelaDAO> factoryItemTabela = new GenericDAOFactory<ItemTabelaDAO>();
		itemTabelaDAO = factoryItemTabela.createDAO(ItemTabelaDAOImpl.class);
	}
	
	@Override
	public void save(PlanoSaude planoSaude){
		Long id = planoSaude.getId();
		PlanoSaudeLog log = new PlanoSaudeLog();
		if (id == null || id.equals(0L)) {
			log.setTipo(LogType.CRIACAO);
			log.setNomeNovo(planoSaude.getNome());
			dao.save(planoSaude);
			
			Coluna col = new Coluna();
			col.setPlanoSaude(planoSaude);
			colDAO.save(col);

			this.criarValores(col);
			
		} else {
			log.setTipo(LogType.ALTERACAO);
			PlanoSaude antigo = dao.getById(id);
			if(!planoSaude.getNome().equals(antigo.getNome())){
				log.setNomeAntigo(antigo.getNome());
				log.setNomeNovo(planoSaude.getNome());
				antigo.setNome(planoSaude.getNome());
			}
			dao.merge(planoSaude);
		}
		log.setPlanoSaudeId(planoSaude.getId());
		logDAO.save(log);
	}
	
	private void criarValores(Coluna coluna){
		List<ItemTabela> lista = this.itemTabelaDAO.list();
		for (ItemTabela itemTabela : lista) {
			Valor val = new Valor();
			val.setColuna(coluna);
			val.setItemTabela(itemTabela);
			this.valorDAO.save(val);
			itemTabela.getValores().add(val);
			this.itemTabelaDAO.merge(itemTabela);
		}
	}
	
	@Override
	public void delete(PlanoSaude planoSaude){
		PlanoSaudeLog log = new PlanoSaudeLog();
		log.setTipo(LogType.DELECAO);
		log.setPlanoSaudeId(planoSaude.getId());
		log.setNomeAntigo(planoSaude.getNome());
		logDAO.save(log);
		
		Coluna col = colDAO.getByPlano(planoSaude);
		List<Valor> valores = valorDAO.listByColuna(col);
		for (Valor valor : valores) {
			valorDAO.delete(valor);
		}
		colDAO.delete(col);
	}
	
	public PlanoSaude getByNome(String nome){
		return dao.getByNome(nome);
	}
	
}
