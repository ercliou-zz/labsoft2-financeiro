package br.com.drerp.financeiro.business.transferencia;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.crud.util.DAOFactory;
import br.com.drerp.financeiro.dao.transferencia.RequisicaoTransferenciaDAO;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.StatusRequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class RequisicaoTransferenciaBR {
	
	private RequisicaoTransferenciaDAO requisicaoTransferenciaDAO;
	
	public RequisicaoTransferenciaBR() {
		super();
		requisicaoTransferenciaDAO = DAOFactory.createRequisicaoTransferenciaDAO();
	}
	
	
	public RequisicaoTransferencia getById(Long id){
		return requisicaoTransferenciaDAO.getById(id);
	}
	
	public void save(RequisicaoTransferencia requisicaoTransferencia){
		Long id = requisicaoTransferencia.getId();
		if(id== 0 || id == null){
			requisicaoTransferenciaDAO.save(requisicaoTransferencia);
		}
		else{
			requisicaoTransferenciaDAO.alter(requisicaoTransferencia);
		}
	}
	
	public void delete(RequisicaoTransferencia transferencia){
		requisicaoTransferenciaDAO.delete(transferencia);
	}
	
	public List<RequisicaoTransferencia> list(){
		return requisicaoTransferenciaDAO.list();
	}
	
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
