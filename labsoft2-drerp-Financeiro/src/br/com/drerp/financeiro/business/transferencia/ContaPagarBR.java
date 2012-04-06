package br.com.drerp.financeiro.business.transferencia;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.transferencia.ContaPagarDAOImpl;
import br.com.drerp.financeiro.model.transferencia.ContaPagar;
import br.com.drerp.financeiro.model.transferencia.Departamento;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class ContaPagarBR extends GenericBR<ContaPagarDAOImpl, ContaPagar> {
	
	public List<ContaPagar> listarAbertas(){
		return super.dao.listarAbertas();
	}
	
	public List<ContaPagar> listarEfetuadas(){
		return super.dao.listarEfetuadas();
	}
	
	public Transferencia realizarTransferencia (ContaPagar conta){
		conta.setDataRealizacaoMilis((new Date()).getTime());
		// mais coisassssssss
		conta.setStatus(StatusTransferencia.EFETUADA);
		save(conta);
		return conta;
	}
	
	public Transferencia registrarErro (ContaPagar conta){
		conta.setDataRealizacaoMilis((new Date()).getTime());
		conta.setStatus(StatusTransferencia.ERRO);
		save(conta);
		return conta;
	}
	
	public BigDecimal getGastoByDpto(Departamento dpto, GregorianCalendar inicio, GregorianCalendar fim){
		BigDecimal total = new BigDecimal(0);
		for (ContaPagar conta: this.dao.getByDpto(dpto, inicio.getTimeInMillis(), fim.getTimeInMillis())) {
			total = total.add(conta.getValor());
		}
		return total;
	}
	
}
