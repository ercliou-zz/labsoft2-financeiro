package br.com.drerp.financeiro.business.transferencia;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.drerp.financeiro.dao.transferencia.RequisicaoTransferenciaDAO;
import br.com.drerp.financeiro.dao.transferencia.RequisicaoTransferenciaDAOImpl;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.StatusRequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class RequisicaoTransferenciaBR extends GenericBR<RequisicaoTransferenciaDAOImpl, RequisicaoTransferencia> {
	
	private RequisicaoTransferenciaDAO requisicaoTransferenciaDAO;
	
	public List<RequisicaoTransferencia> listarAbertas(){
		return requisicaoTransferenciaDAO.listarAbertas();
	}
	
	public List<RequisicaoTransferencia> listarAceitas(){
		return requisicaoTransferenciaDAO.listarAceitas();
	}
	
	public List<RequisicaoTransferencia> listarEfetuadas(){
		return requisicaoTransferenciaDAO.listarEfetuadas();
	}
	
	public Transferencia realizarTransferencia (RequisicaoTransferencia requisicaoTransferencia, BigDecimal valorTransferido){
		Transferencia transferencia = new Transferencia();
		transferencia.setDataRealizacaoMilis((new Date()).getTime());
		transferencia.setRequisicao(requisicaoTransferencia);
		transferencia.setValor(requisicaoTransferencia.getValor());
		// mais coisassssssss
		
		requisicaoTransferencia.setStatus(StatusRequisicaoTransferencia.EFETUADA);
		requisicaoTransferencia.setTransferencia(transferencia);
		save(requisicaoTransferencia);
		
		return transferencia;
	}
}
