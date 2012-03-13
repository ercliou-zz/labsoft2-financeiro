package br.com.crud.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.crud.model.Entidade;

public class EntidadeDAOImpl implements EntidadeDAO{

	private Session session;
	
	public void setSession(Session s){
		session = s;
	}
	
	public void save(Entidade entidade) {
		session.save(entidade);
		
	}

	public void delete(Entidade entidade) {
		session.delete(entidade);
	}

	public void alter(Entidade entidade) {
		session.update(entidade);
	}

	public Entidade getById(Long id) {
		return (Entidade) session.get(Entidade.class,id);
	}

	@SuppressWarnings("unchecked")
	public List<Entidade> list() {
		List<Entidade> list = session.createCriteria(Entidade.class).list();
		return list;
	}
	
}
