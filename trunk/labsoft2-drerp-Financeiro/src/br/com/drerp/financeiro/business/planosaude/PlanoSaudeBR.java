package br.com.drerp.financeiro.business.planosaude;

import br.com.crud.util.GenericDAOFactory;
import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.planosaude.PlanoSaudeDAOImpl;
import br.com.drerp.financeiro.dao.planosaude.PlanoSaudeLogDAO;
import br.com.drerp.financeiro.dao.planosaude.PlanoSaudeLogDAOImpl;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.planosaude.PlanoSaudeLog;

public class PlanoSaudeBR extends GenericBR<PlanoSaudeDAOImpl, PlanoSaude>{
	private PlanoSaudeLogDAO logDAO;

	public PlanoSaudeBR() {
		super();
		GenericDAOFactory<PlanoSaudeLogDAO> factory = new GenericDAOFactory<PlanoSaudeLogDAO>();
		logDAO = factory.createDAO(PlanoSaudeLogDAOImpl.class);
	}
	
	@Override
	public void save(PlanoSaude planoSaude){
		Long id = planoSaude.getId();
		PlanoSaudeLog log = new PlanoSaudeLog();
		if (id == null || id.equals(0L)) {
			log.setTipo(LogType.CRIACAO);
			log.setNomeNovo(planoSaude.getNome());
			dao.save(planoSaude);
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
		dao.delete(planoSaude);
	}
	
}
