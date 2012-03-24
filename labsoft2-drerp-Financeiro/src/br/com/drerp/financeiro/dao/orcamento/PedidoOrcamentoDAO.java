package br.com.drerp.financeiro.dao.orcamento;

import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.orcamento.PedidoOrcamento;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

public interface PedidoOrcamentoDAO extends GenericDAO<PedidoOrcamento> {
	
	public List<PedidoOrcamento> listByDataPedido(PlanoSaude plano, Long inicio, Long fim);

}
