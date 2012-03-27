package br.com.drerp.financeiro.business.transferencia;

import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.transferencia.TransferenciaDAOImpl;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class TransferenciaBR extends GenericBR<TransferenciaDAOImpl, Transferencia> {
	
	public List<Transferencia> listarAbertas(){
		return super.dao.listarAbertas();
	}
	
	public List<Transferencia> listarEfetuadas(){
		return super.dao.listarEfetuadas();
	}
	
//	public Transferencia realizarTransferencia (Transferencia requisicaoTransferencia, BigDecimal valorTransferido){
//		Transferencia transferencia = new Transferencia();
//		transferencia.setDataRealizacaoMilis((new Date()).getTime());
//		transferencia.setRequisicao(requisicaoTransferencia);
//		transferencia.setValor(valorTransferido);
//		// mais coisassssssss
//		
//		requisicaoTransferencia.setStatus(StatusRequisicaoTransferencia.EFETUADA);
//		requisicaoTransferencia.setTransferencia(transferencia);
//		
//		save(requisicaoTransferencia);
//		return transferencia;
//	}
}
