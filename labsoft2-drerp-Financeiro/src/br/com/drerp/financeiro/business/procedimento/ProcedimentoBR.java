package br.com.drerp.financeiro.business.procedimento;

import java.util.List;

import br.com.crud.util.GenericDAOFactory;
import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.procedimento.ProcedimentoDAOImpl;
import br.com.drerp.financeiro.dao.tabela.ItemTabelaDAO;
import br.com.drerp.financeiro.dao.tabela.ItemTabelaDAOImpl;
import br.com.drerp.financeiro.dao.tabela.ValorDAO;
import br.com.drerp.financeiro.dao.tabela.ValorDAOImpl;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.tabela.ItemTabela;
import br.com.drerp.financeiro.model.tabela.Valor;

public class ProcedimentoBR extends GenericBR<ProcedimentoDAOImpl, Procedimento>{
	private ItemTabelaDAO itemTabelaDAO;
	private ValorDAO valorDAO;

	public ProcedimentoBR() {
		super();
		GenericDAOFactory<ItemTabelaDAO> factoryItem = new GenericDAOFactory<ItemTabelaDAO>();
		itemTabelaDAO = factoryItem.createDAO(ItemTabelaDAOImpl.class);
		GenericDAOFactory<ValorDAO> factoryValor = new GenericDAOFactory<ValorDAO>();
		valorDAO = factoryValor.createDAO(ValorDAOImpl.class);
	}
	
	@Override
	public void save(Procedimento procedimento){
		Long id = procedimento.getId();
		if (id == null || id.equals(0L)) {
			ItemTabela item = new ItemTabela();
			dao.save(procedimento);
			item.setProcedimento(procedimento);
			itemTabelaDAO.save(item);
			
		} else {
			dao.edit(procedimento);
		}
	}
	
	@Override
	public void delete(Procedimento procedimento){
		
		ItemTabela item = itemTabelaDAO.getByProcedimento(procedimento);
		List<Valor> valores = null;
		if(item != null){
			valores = item.getValores();
		}
		for (Valor valor : valores) {
			valorDAO.delete(valor);
		}
		itemTabelaDAO.delete(item);
		dao.delete(procedimento);
	}
	
}
