package br.com.drerp.financeiro.web.transferencia;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.transferencia.TransferenciaBR;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

@ManagedBean(name="TransferenciaBean")
@RequestScoped
public class TransferenciaBean {
	
	private Transferencia transferencia = new Transferencia();
	
	public String novo(){
		transferencia = new Transferencia();
		return "transferenciaList";
	}

	public String salvar(){
		//FacesContext context = FacesContext.getCurrentInstance();
		TransferenciaBR transferenciaBR = new TransferenciaBR();
		transferenciaBR.save(transferencia);
		return "usuarioList";
	}

	public Transferencia getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;
	}
}
