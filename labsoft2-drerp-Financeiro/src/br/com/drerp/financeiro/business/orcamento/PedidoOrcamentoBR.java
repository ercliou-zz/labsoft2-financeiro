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
	
	public int qtdOrcamento(PlanoSaude planoSaude, Calendar dataInicio) {
		
		
		int mesFim = dataInicio.get(Calendar.MONTH);
		int anoFim = dataInicio.get(Calendar.YEAR);
		
		mesFim--;
		if(mesFim<0){
			mesFim=11;
			anoFim--;
		}
		
		Calendar dataFim = new GregorianCalendar(anoFim, mesFim, 1);
		
		return this.dao.listByDataPedido(dataInicio.getTimeInMillis(), dataFim.getTimeInMillis()).size();
	}
	
	
	
}
