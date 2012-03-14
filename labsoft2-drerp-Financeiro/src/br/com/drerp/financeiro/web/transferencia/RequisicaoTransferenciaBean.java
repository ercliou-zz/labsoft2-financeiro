package br.com.drerp.financeiro.web.transferencia;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.transferencia.RequisicaoTransferenciaBR;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.StatusRequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

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
	
	public String save(){
		requisicaoTransferenciaBR.save(requisicaoTransferencia);
		return "RequisicaoTransferenciaLista";
	}
	
	public String alter(){
		requisicaoTransferencia = new RequisicaoTransferencia();
		return "requisicaoTransferenciaNovo";
	}
	
	public String listarAprovadas(){
		return "requisicaoAprovadaList";
	}
	
	public String realizarTransferencia(){
		
		// falta umas condicoes aquiiii !! verificar o status antes!!
		
		requisicaoTransferenciaBR.realizarTransferencia(requisicaoTransferencia);
		
		// para atualizar a lista?? see doencaBean
		this.listaAprovada = null;
		
		return null;
	}

	
	
	
	
	public RequisicaoTransferencia getRequisicaoTransferencia() {
		return requisicaoTransferencia;
	}

	public void setRequisicaoTransferencia(
			RequisicaoTransferencia requisicaoTransferencia) {
		this.requisicaoTransferencia = requisicaoTransferencia;
	}

	public List<RequisicaoTransferencia> getListaAprovada() {
		listaAprovada = requisicaoTransferenciaBR.list();
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
