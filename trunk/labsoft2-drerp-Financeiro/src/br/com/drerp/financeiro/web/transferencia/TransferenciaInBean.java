package br.com.drerp.financeiro.web.transferencia;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.transferencia.ContaReceberBR;
import br.com.drerp.financeiro.model.transferencia.ContaReceber;

@ManagedBean(name="transferenciaInBean")
@RequestScoped
public class TransferenciaInBean implements Serializable{
	
	private static final long serialVersionUID = -3229300148690484732L;

	private ContaReceber contaReceber;
	
	private List<ContaReceber> contaReceberList;
	
	private ContaReceberBR contaReceberBR;
	
	public TransferenciaInBean() {
		contaReceberBR = new ContaReceberBR();
		contaReceber = new ContaReceber();
	}
	
	public String delete() {
		contaReceberBR.delete(contaReceber);
		return list();
	}
	
	public String list(){
		return "contaReceberList";
	}
	
	public String registrarErro() {
		contaReceberBR.registrarErro(contaReceber);
		return list();
	}

	public String lancarPagamento(){
		contaReceberBR.lancarPagamento(contaReceber);
		return list();
	}
	
	public ContaReceber getContaReceber() {
		return contaReceber;
	}

	public void setContaReceber(ContaReceber contaReceber) {
		this.contaReceber = contaReceber;
	}

	public List<ContaReceber> getContaReceberList() {
		contaReceberList = contaReceberBR.list();
		return contaReceberList;
	}

	public void setContaReceberList(List<ContaReceber> contaReceberList) {
		this.contaReceberList = contaReceberList;
	}
	
}
