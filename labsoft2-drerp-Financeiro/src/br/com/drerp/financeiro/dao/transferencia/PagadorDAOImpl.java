package br.com.drerp.financeiro.dao.transferencia;

import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.transferencia.Pagador;
import br.com.drerp.financeiro.util.FinanceiroConstants;

public class PagadorDAOImpl extends GenericDAOImpl<Pagador> implements
		PagadorDAO {

	public Pagador getClinica() {

		return (Pagador) this.session.createCriteria(Pagador.class)
				.add(Restrictions.eq("nome", FinanceiroConstants.NOME_CLINICA)).uniqueResult();
	}

	public Pagador salvar(Pagador pagador) {
		Pagador p = null;
		if (pagador.getDocumento() != null) {
			p = (Pagador) this.session.createCriteria(Pagador.class)
					.add(Restrictions.eq("documento", pagador.getDocumento()))
					.uniqueResult();
		}
		if (p == null) {
			this.session.save(pagador);
			this.session.flush();
		}
		return p;
	}

}
