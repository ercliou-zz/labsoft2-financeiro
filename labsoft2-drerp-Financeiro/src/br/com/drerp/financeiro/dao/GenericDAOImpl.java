package br.com.drerp.financeiro.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

public abstract class GenericDAOImpl <T> implements GenericDAO<T> {
	
	protected Session session;
	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

	
	public void setSession(Session s){
		session = s;
	}
	
	public void save(T entidade) {
		session.save(entidade);
		session.flush();
	}

	public void delete(T entidade) {
		session.delete(entidade);
	}

	public void edit(T entidade) {
		session.update(entidade);
	}

	@SuppressWarnings("unchecked")
	public T getById(Long id) {
		return (T) session.get(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> list() {
		List<T> list = session.createCriteria(persistentClass).list();
		return list;
	}

}
