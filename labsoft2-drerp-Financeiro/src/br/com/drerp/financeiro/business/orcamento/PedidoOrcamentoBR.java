package br.com.drerp.financeiro.business.orcamento;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.business.tabela.TabelaBR;
import br.com.drerp.financeiro.dao.orcamento.PedidoOrcamentoDAOImpl;
import br.com.drerp.financeiro.model.orcamento.Orcamento;
import br.com.drerp.financeiro.model.orcamento.PedidoOrcamento;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.planosaude.Procedimento;
import br.com.drerp.financeiro.model.transferencia.Pagador;

public class PedidoOrcamentoBR extends GenericBR<PedidoOrcamentoDAOImpl, PedidoOrcamento> {

	public BigDecimal pedirOrcamento (Pagador pagador, List<Procedimento> procedimentos, PlanoSaude planoSaude){
		TabelaBR tabelaBR = new TabelaBR();
		BigDecimal valorTotal = new BigDecimal(0);
		Orcamento orcamento = new Orcamento();
		
		
		for (Procedimento proc : procedimentos) {
			valorTotal = valorTotal.add(tabelaBR.recuperarValor(planoSaude, proc));
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
	
	public int getQtdOrcamentoByPeriodo(PlanoSaude planoSaude, Calendar dataInicio, Calendar dataFim) {
		
		return this.dao.listByDataPedido(planoSaude, dataInicio.getTimeInMillis(), dataFim.getTimeInMillis()).size();
	}
	
	public BigDecimal getValorOrcamentoByPeriodo(PlanoSaude planoSaude, Calendar dataInicio, Calendar dataFim) {
		
		List<PedidoOrcamento> pedidos = this.dao.listByDataPedido(planoSaude, dataInicio.getTimeInMillis(), dataFim.getTimeInMillis());
		BigDecimal soma = new BigDecimal(0);
		
		for (PedidoOrcamento p : pedidos) {
			soma = soma.add(p.getOrcamento().getValorFinal());
		}
		
		return soma;
	}
	
	
	
}
