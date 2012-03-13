package br.com.crud.util;

import org.hibernate.Session;

import br.com.crud.dao.EntidadeDAO;
import br.com.crud.dao.EntidadeDAOImpl;
import br.com.drerp.financeiro.dao.transferencia.TransferenciaDAO;
import br.com.drerp.financeiro.dao.transferencia.TransferenciaDAOImpl;

public class DAOFactory {
	
	public static EntidadeDAO createEntidadeDAO(){
		EntidadeDAO entidadeDAO = new EntidadeDAOImpl();
		entidadeDAO.setSession(getSession());
		return entidadeDAO;
	}
	
	public static TransferenciaDAO createTransferenciaDAO(){
		TransferenciaDAO transferenciaDAO = new TransferenciaDAOImpl();
		transferenciaDAO.setSession(getSession());
		return transferenciaDAO;
	}
	
	private static Session getSession(){
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
}
