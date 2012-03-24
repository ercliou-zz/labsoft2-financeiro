package br.com.drerp.financeiro.business.planosaude;

import br.com.crud.util.GenericDAOFactory;
import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.planosaude.PlanoSaudeDAOImpl;
import br.com.drerp.financeiro.dao.planosaude.PlanoSaudeLogDAO;
import br.com.drerp.financeiro.dao.planosaude.PlanoSaudeLogDAOImpl;
import br.com.drerp.financeiro.dao.tabela.ColunaDAO;
import br.com.drerp.financeiro.dao.tabela.ColunaDAOImpl;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.planosaude.PlanoSaudeLog;
import br.com.drerp.financeiro.model.tabela.Coluna;

public class PlanoSaudeBR extends GenericBR<PlanoSaudeDAOImpl, PlanoSaude>{
	private PlanoSaudeLogDAO logDAO;
	private ColunaDAO colDAO;

	public PlanoSaudeBR() {
		super();
		GenericDAOFactory<PlanoSaudeLogDAO> factory = new GenericDAOFactory<PlanoSaudeLogDAO>();
		logDAO = factory.createDAO(PlanoSaudeLogDAOImpl.class);
		GenericDAOFactory<ColunaDAO> factoryColuna = new GenericDAOFactory<ColunaDAO>();
		colDAO = factoryColuna.createDAO(ColunaDAOImpl.class);
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
			
		} else {
			log.setTipo(LogType.ALTERACAO);
			PlanoSaude antigo = dao.getById(id);
			if(!planoSaude.getNome().equals(antigo.getNome())){
				log.setNomeAntigo("a");
				log.setNomeNovo(planoSaude.getNome());
				antigo.setNome(planoSaude.getNome());
			}
			dao.merge(planoSaude);
		}
		log.setPlanoSaudeId(planoSaude.getId());
		logDAO.save(log);
	}
	
	@Override
	public void delete(PlanoSaude planoSaude){
		PlanoSaudeLog log = new PlanoSaudeLog();
		log.setTipo(LogType.DELECAO);
		log.setPlanoSaudeId(planoSaude.getId());
		log.setNomeAntigo(planoSaude.getNome());
		logDAO.save(log);
		Coluna col = colDAO.getByPlano(planoSaude);
		colDAO.delete(col);
		dao.delete(planoSaude);
	}
	
}
