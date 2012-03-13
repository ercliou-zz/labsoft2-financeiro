package br.com.crud.entidade;

import java.util.List;

import br.com.crud.dao.EntidadeDAO;
import br.com.crud.model.Entidade;
import br.com.crud.util.DAOFactory;

public class EntidadeBR {
	private EntidadeDAO entidadeDAO;

	public EntidadeBR() {
		super();
		entidadeDAO = DAOFactory.createEntidadeDAO();
	}
	
	public Entidade getById(Long id){
		return entidadeDAO.getById(id);
	}
	
	public void save(Entidade entidade){
		Long id = entidade.getId();
		if(id == null || id == 0){
			entidadeDAO.save(entidade);
		}
		else{
			entidadeDAO.alter(entidade);
		}
	}
	
	public void delete(Entidade entidade){
		entidadeDAO.delete(entidade);
	}
	
	public List<Entidade> list(){
		return entidadeDAO.list();
	}
	
}
