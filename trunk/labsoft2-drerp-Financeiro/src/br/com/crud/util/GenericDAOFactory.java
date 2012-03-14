package br.com.crud.util;

import org.hibernate.Session;

import br.com.drerp.financeiro.dao.GenericDAO;

public class GenericDAOFactory<T extends GenericDAO<?>> {

	public T createDAO(Class type) {
		try {
			T entidade = (T) type.newInstance();
			entidade.setSession(getSession());
			return entidade;
		} catch (ClassCastException ex) {
			System.err.println(ex + " Incorrect class cast.");
		} catch (InstantiationException ex) {
			System.err.println(ex + " Interpreter class must be concrete.");
		} catch (IllegalAccessException ex) {
			System.err.println(ex
					+ " Interpreter class must have a no-arg constructor.");
		}
		return null;
	}

	private static Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

}
