package br.com.drerp.financeiro.web.transferencia;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.transferencia.RequisicaoTransferenciaBR;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;

@ManagedBean(name="RequisicaoTransferenciaBean")
@RequestScoped
public class RequisicaoTransferenciaBean {
	
	private RequisicaoTransferencia requisicaoTransferencia;
	
	private List<RequisicaoTransferencia> listaAprovada;
	
	private RequisicaoTransferenciaBR requisicaoTransferenciaBR;
	
	public RequisicaoTransferenciaBean() {
		requisicaoTransferenciaBR = new RequisicaoTransferenciaBR();
	}

//	public String create(){
//		requisicaoTransferencia = new RequisicaoTransferencia();
//		return "requisicaoTransferenciaNovo";
//	}
//	
	public String alter(){
		requisicaoTransferencia = new RequisicaoTransferencia();
		return "requisicaoTransferenciaNovo";
	}
	
	public String listarAprovadas(){
		
		
		return "RequisicaoTransferenciaLista";
	}
	
	public String realizarTransferencia(){
		return "";
	}

	
	
	
	
	public List<RequisicaoTransferencia> getListaAprovada() {
		return listaAprovada;
	}

	public void setListaAprovada(List<RequisicaoTransferencia> listaAprovada) {
		this.listaAprovada = listaAprovada;
	}
	
	
	
	
	
//
//	public String salvar(){
//		//FacesContext context = FacesContext.getCurrentInstance();
//		TransferenciaBR transferenciaBR = new TransferenciaBR();
//		transferenciaBR.save(transferencia);
//		return "usuarioList";
//	}
//
//	public Transferencia getTransferencia() {
//		return transferencia;
//	}
//
//	public void setTransferencia(Transferencia transferencia) {
//		this.transferencia = transferencia;
//	}
}
