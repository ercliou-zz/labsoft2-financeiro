package br.com.drerp.financeiro.business.transferencia;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.transferencia.RequisicaoTransferenciaDAOImpl;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.StatusRequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class RequisicaoTransferenciaBR extends GenericBR<RequisicaoTransferenciaDAOImpl, RequisicaoTransferencia> {
	
	public List<RequisicaoTransferencia> listarAbertas(){
		return super.dao.listarAbertas();
	}
	
	public List<RequisicaoTransferencia> listarAceitas(){
		return super.dao.listarAceitas();
	}
	
	public List<RequisicaoTransferencia> listarEfetuadas(){
		return super.dao.listarEfetuadas();
	}
	
	public Transferencia realizarTransferencia (RequisicaoTransferencia requisicaoTransferencia, BigDecimal valorTransferido){
		Transferencia transferencia = new Transferencia();
		transferencia.setDataRealizacaoMilis((new Date()).getTime());
		transferencia.setRequisicao(requisicaoTransferencia);
		transferencia.setValor(valorTransferido);
		// mais coisassssssss
		
		requisicaoTransferencia.setStatus(StatusRequisicaoTransferencia.EFETUADA);
		requisicaoTransferencia.setTransferencia(transferencia);
		
		save(requisicaoTransferencia);
		return transferencia;
	}
}
