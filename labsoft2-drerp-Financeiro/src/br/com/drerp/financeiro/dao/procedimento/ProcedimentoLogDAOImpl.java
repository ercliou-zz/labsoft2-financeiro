package br.com.drerp.financeiro.dao.procedimento;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.procedimento.ProcedimentoLog;

public class ProcedimentoLogDAOImpl extends GenericDAOImpl<ProcedimentoLog> implements ProcedimentoLogDAO{
	
	@SuppressWarnings("unchecked")
	public List<ProcedimentoLog> listByLogType(LogType tipo) {
		return session.createCriteria(ProcedimentoLog.class).add(Restrictions.eq("tipo", tipo)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcedimentoLog> listByProcedimentoId(Long id) {
		return session.createCriteria(ProcedimentoLog.class).add(Restrictions.eq("procedimentoId", id)).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ProcedimentoLog> listByFiltros(LogType tipo, Long id, Calendar dataInicial, Calendar dataFinal) {
		Criteria criteria = session.createCriteria(ProcedimentoLog.class);
		if (tipo != null) {
			criteria.add(Restrictions.eq("tipo",tipo));
		}
		if (id != 0) {
			criteria.add(Restrictions.eq("procedimentoId",id));
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
