package br.com.drerp.financeiro.dao.tabela;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.tabela.ValorLog;

public class ValorLogDAOImpl extends GenericDAOImpl<ValorLog> implements
		ValorLogDAO {

	@SuppressWarnings("unchecked")
	public List<ValorLog> listByLogType(LogType tipo) {
		return session.createCriteria(ValorLog.class)
				.add(Restrictions.eq("tipo", tipo)).list();
	}

	@SuppressWarnings("unchecked")
	public List<ValorLog> listByPlanoSaudeId(Long id) {
		return session.createCriteria(ValorLog.class)
				.add(Restrictions.eq("planoSaudeId", id)).list();
	}

	@SuppressWarnings("unchecked")
	public List<ValorLog> listByProcedimentoId(Long id) {
		return session.createCriteria(ValorLog.class)
				.add(Restrictions.eq("procedimentoId", id)).list();
	}

	@SuppressWarnings("unchecked")
	public List<ValorLog> listByFiltros(LogType tipo, Long planoSaudeId,
			Long procedimentoId, Calendar dataInicial, Calendar dataFinal) {
		Criteria criteria = session.createCriteria(ValorLog.class);
		if (tipo != null) {
			criteria.add(Restrictions.eq("tipo", tipo));
		}
		if (planoSaudeId != 0L) {
			criteria.add(Restrictions.eq("planoSaudeId", planoSaudeId));
		}
		if (procedimentoId != 0L) {
			criteria.add(Restrictions.eq("procedimentoId", procedimentoId));
		}
		if (dataInicial != null) {
			criteria.add(Restrictions.ge("dataMS",
					dataInicial.getTimeInMillis()));
		}
		if (dataFinal != null) {
			criteria.add(Restrictions.le("dataMS", dataFinal.getTimeInMillis()));
		}
		criteria.addOrder(Order.desc("dataMS"));
		return criteria.list();

	}
}
