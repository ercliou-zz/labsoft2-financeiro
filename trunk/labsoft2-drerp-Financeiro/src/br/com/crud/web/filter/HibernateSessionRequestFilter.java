package br.com.crud.web.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.SessionFactory;

import br.com.crud.util.HibernateUtil;

public class HibernateSessionRequestFilter implements Filter{

	private SessionFactory sessionFactory;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		try{
			sessionFactory.getCurrentSession().beginTransaction();
			filterChain.doFilter(servletRequest, servletResponse);
			sessionFactory.getCurrentSession().getTransaction().commit();
			sessionFactory.getCurrentSession().close();
		}catch(Throwable e){
			try{
				if(sessionFactory.getCurrentSession().getTransaction().isActive()){
					sessionFactory.getCurrentSession().getTransaction().rollback();
				}
			}catch(Throwable ex){
				ex.printStackTrace();
			}
			throw new ServletException(e);
		}
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	
}
