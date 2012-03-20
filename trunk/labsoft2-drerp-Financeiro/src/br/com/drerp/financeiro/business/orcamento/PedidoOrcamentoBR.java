package br.com.drerp.financeiro.business.orcamento;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.orcamento.PedidoOrcamentoDAOImpl;
import br.com.drerp.financeiro.model.orcamento.Orcamento;
import br.com.drerp.financeiro.model.orcamento.PedidoOrcamento;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.tabela.ItemTabela;
import br.com.drerp.financeiro.model.transferencia.Pagador;

public class PedidoOrcamentoBR extends GenericBR<PedidoOrcamentoDAOImpl, PedidoOrcamento> {

	public BigDecimal pedirOrcamento (Pagador pagador, List<ItemTabela> procedimentos, PlanoSaude planoSaude){
		
		BigDecimal valorTotal = new BigDecimal(0);
		Orcamento orcamento = new Orcamento();
		
		for (ItemTabela proc : procedimentos) {
//			valorTotal += algumBR.getValor();
		}
		orcamento.setValorFinal(valorTotal);
		
		PedidoOrcamento pedido = new PedidoOrcamento();
		pedido.setPagador(pagador);
		pedido.setProcedimentos(procedimentos);
		pedido.setPlano(planoSaude);
		pedido.setOrcamento(orcamento);
		pedido.setDataPedidoMilis((new Date().getTime()));
		super.dao.save(pedido);
		
		return valorTotal; //oooooooou? id do Orcamento para fazer outra requisicao com acrescentarAcrescimoNoOrcamento(idOrcamento, acrescimo)
	}
	
}
