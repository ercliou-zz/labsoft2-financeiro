package br.com.drerp.financeiro.dao.orcamento;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.orcamento.PedidoOrcamento;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.StatusRequisicaoTransferencia;

public class PedidoOrcamentoDAOImpl extends GenericDAOImpl<PedidoOrcamento> implements PedidoOrcamentoDAO {
	
	@SuppressWarnings("unchecked")
	public List<RequisicaoTransferencia> listByDataPedido(Long inicio, Long fim) {
		return session.createCriteria(RequisicaoTransferencia.class).add(Restrictions.between("dataPedidoMilis", inicio, fim)).list();
	}
	

}
