package br.com.drerp.financeiro.dao.planosaude;

import java.util.List;

import org.hibernate.criterion.Order;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.transferencia.Guia;

public class GuiaDAOImpl extends GenericDAOImpl<Guia> implements GuiaDAO{
	
	@SuppressWarnings("unchecked")
	public List<Guia> listGuia() {
		return session.createCriteria(Guia.class).addOrder(Order.desc("dataInicialMS")).list();
	}

}
