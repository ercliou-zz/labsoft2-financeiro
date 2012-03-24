package br.com.drerp.financeiro.dao.orcamento;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.orcamento.PedidoOrcamento;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

public class PedidoOrcamentoDAOImpl extends GenericDAOImpl<PedidoOrcamento> implements PedidoOrcamentoDAO {
	
	@SuppressWarnings("unchecked")
	public List<PedidoOrcamento> listByDataPedido(PlanoSaude plano, Long inicio, Long fim) { // DATAREQUISICAOMILIS
		return session.createCriteria(PedidoOrcamento.class).
				add(Restrictions.between("dataPedidoMilis", inicio, fim)).
				add(Restrictions.eq("plano", plano)).list();
	}
	

}
