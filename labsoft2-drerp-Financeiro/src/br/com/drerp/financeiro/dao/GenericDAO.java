package br.com.drerp.financeiro.dao;

import java.util.List;

import org.hibernate.Session;

public abstract interface GenericDAO<T> {
	
	public void setSession(Session s);
	
	public void save(T entidade);
	public void delete(T entidade);
	public void edit(T entidade);
	public T getById(Long id);
	public List<T> list();
	public void merge(T entidade);
}
