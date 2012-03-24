package br.com.drerp.financeiro.dao.tabela;

import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.tabela.Coluna;

public class ColunaDAOImpl extends GenericDAOImpl<Coluna> implements ColunaDAO {

	public Coluna getByPlano(PlanoSaude plano) {
		return (Coluna) session.createCriteria(Coluna.class).add(Restrictions.eq("planoSaude", plano)).list().get(0);
	}
	
}
