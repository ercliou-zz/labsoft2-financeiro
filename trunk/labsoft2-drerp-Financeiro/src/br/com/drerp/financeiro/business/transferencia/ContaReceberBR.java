package br.com.drerp.financeiro.business.transferencia;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.transferencia.ContaReceberDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.transferencia.ContaReceber;
import br.com.drerp.financeiro.model.transferencia.Fatura;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;

public class ContaReceberBR extends GenericBR<ContaReceberDAOImpl, ContaReceber> {
	
private FaturaBR faturaBR;
	
	public ContaReceberBR() {
		super();
		faturaBR = new FaturaBR();
	}
	
	public ContaReceber registrarErro(ContaReceber conta) {
		conta.setDataRealizacaoMilis((new Date()).getTime());
		conta.setStatus(StatusTransferencia.ERRO);
		save(conta);
		return conta;
	}
	
	public ContaReceber lancarPagamento(ContaReceber conta) {
		conta.setDataRealizacaoMilis((new Date()).getTime());
		conta.setStatus(StatusTransferencia.EFETUADA);
		save(conta);

		if (conta.getFaturas() != null) {
			for (Fatura fatura : conta.getFaturas()) {
				fatura.setPaga(true);
				this.faturaBR.save(fatura);
			}
		}
		return conta;
	}
	
	public BigDecimal getReceitaByPeriodo(GregorianCalendar inicio, GregorianCalendar fim){
		BigDecimal total = new BigDecimal(0);
		// workaround.. hibernate asshole retornando duplicados (sem sentido!)
		for (ContaReceber conta: new HashSet<ContaReceber>(this.dao.listEfetuadasByPeriodo(inicio.getTimeInMillis(), fim.getTimeInMillis()))) {
				total = total.add(conta.getValor());
		}
		return total;
	}
	
	
	public BigDecimal getReceitaByPlano(PlanoSaude plano, GregorianCalendar inicio, GregorianCalendar fim){
		BigDecimal total = new BigDecimal(0);
		for (ContaReceber conta: new HashSet<ContaReceber>(this.dao.listReceitaByPlano(plano, inicio.getTimeInMillis(), fim.getTimeInMillis()))) {
				total = total.add(conta.getValor());
		}
		return total;
	}
	
	public HashSet<ContaReceber> listReceitaByPlanos(List<PlanoSaude> planos, GregorianCalendar inicio, GregorianCalendar fim){
		return new HashSet<ContaReceber>(this.dao.listReceitaByPlanos(planos, inicio.getTimeInMillis(), fim.getTimeInMillis()));
	}
	
}
