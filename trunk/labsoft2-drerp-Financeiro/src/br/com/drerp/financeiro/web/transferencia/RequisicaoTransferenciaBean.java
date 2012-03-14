package br.com.drerp.financeiro.web.transferencia;

import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.transferencia.RequisicaoTransferenciaBR;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;

@ManagedBean(name="RequisicaoTransferenciaBean")
@RequestScoped
public class RequisicaoTransferenciaBean {
	
	private RequisicaoTransferencia requisicaoTransferencia;
	
	private BigDecimal valorDepositado;
	
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
		requisicaoTransferenciaBR.realizarTransferencia(requisicaoTransferencia, valorDepositado);
		
		// para atualizar a lista
		this.listaAprovada = null;
		return null;
	}
	
	public String delete() {
		requisicaoTransferenciaBR.delete(this.requisicaoTransferencia);
		// para atualizar a lista
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
		listaAprovada = requisicaoTransferenciaBR.listarAceitas();
		listaAprovada.addAll(requisicaoTransferenciaBR.listarEfetuadas());
		return listaAprovada;
	}

	public void setListaAprovada(List<RequisicaoTransferencia> listaAprovada) {
		this.listaAprovada = listaAprovada;
	}

	public BigDecimal getValorDepositado() {
		return valorDepositado;
	}

	public void setValorDepositado(BigDecimal valorDepositado) {
		this.valorDepositado = valorDepositado;
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
