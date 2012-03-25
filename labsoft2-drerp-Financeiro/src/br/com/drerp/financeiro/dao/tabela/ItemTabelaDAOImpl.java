package br.com.drerp.financeiro.dao.tabela;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.tabela.ItemTabela;

public class ItemTabelaDAOImpl extends GenericDAOImpl<ItemTabela> implements ItemTabelaDAO {

	@Override
	@SuppressWarnings("unchecked")
	public ItemTabela getByProcedimento(Procedimento procedimento) {
		List<ItemTabela> retrieved = session.createCriteria(ItemTabela.class).add(Restrictions.eq("procedimento",procedimento)).list();
		if(retrieved.size()>1){
			throw new HibernateException("ItemTabelaDAO.getByProcedimento retornou mais de um itemTabela");
		}
		else if(retrieved.size()==0){
			return null;
		}
		return retrieved.get(0);
	}
	
}
