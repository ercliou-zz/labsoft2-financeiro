package br.com.drerp.financeiro.web.transferencia;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.transferencia.TransferenciaBR;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

@ManagedBean(name="RequisicaoTransferenciaBean")
@RequestScoped
public class RequisicaoTransferenciaBean {
	
	private RequisicaoTransferencia requisicaoTransferencia;
	
//	public String create(){
//		requisicaoTransferencia = new RequisicaoTransferencia();
//		return "requisicaoTransferenciaNovo";
//	}
//	
	public String alter(){
		requisicaoTransferencia = new RequisicaoTransferencia();
		return "requisicaoTransferenciaNovo";
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
