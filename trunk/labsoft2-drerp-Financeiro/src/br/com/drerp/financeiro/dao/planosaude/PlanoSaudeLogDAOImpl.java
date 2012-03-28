package br.com.drerp.financeiro.dao.planosaude;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.planosaude.PlanoSaudeLog;

public class PlanoSaudeLogDAOImpl extends GenericDAOImpl<PlanoSaudeLog> implements PlanoSaudeLogDAO{
	
	@SuppressWarnings("unchecked")
	public List<PlanoSaudeLog> listByLogType(LogType tipo) {
		return session.createCriteria(PlanoSaudeLog.class).add(Restrictions.eq("tipo", tipo)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<PlanoSaudeLog> listByPlanoSaudeId(Long id) {
		return session.createCriteria(PlanoSaudeLog.class).add(Restrictions.eq("planoSaudeId", id)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<PlanoSaudeLog> listByFiltros(LogType tipo, Long id, Calendar dataInicial, Calendar dataFinal) {
		Criteria criteria = session.createCriteria(PlanoSaudeLog.class);
		if (tipo != null) {
			criteria.add(Restrictions.eq("tipo",tipo));
		}
		if (id != 0L) {
			criteria.add(Restrictions.eq("planoSaudeId",id));
		}
		if (dataInicial != null) {
			criteria.add(Restrictions.ge("dataMS", dataInicial.getTimeInMillis()));
		}
		if (dataFinal != null) {
			criteria.add(Restrictions.le("dataMS",dataFinal.getTimeInMillis()));
		}
		criteria.addOrder(Order.desc("dataMS"));
		return criteria.list();
	}
	
	
}
