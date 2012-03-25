package br.com.drerp.financeiro.dao.tabela;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.tabela.Coluna;
import br.com.drerp.financeiro.model.tabela.Valor;

public class ValorDAOImpl extends GenericDAOImpl<Valor> implements ValorDAO {

	
	@SuppressWarnings("unchecked")
	public List<Valor> listByColuna(Coluna col) {
		return (List<Valor>) session.createCriteria(Valor.class).add(Restrictions.eq("coluna",col)).list();
	}
	
}
