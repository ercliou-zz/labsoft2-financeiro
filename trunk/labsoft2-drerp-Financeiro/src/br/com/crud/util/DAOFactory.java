package br.com.crud.util;

import br.com.crud.dao.EntidadeDAO;
import br.com.crud.dao.EntidadeDAOImpl;

public class DAOFactory {
	public static EntidadeDAO createEntidadeDAO(){
		EntidadeDAOImpl entidadeDAO = new EntidadeDAOImpl();
		entidadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return entidadeDAO;
	}
}
