package br.com.drerp.financeiro.web.transferencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.transferencia.ContaPagarBR;
import br.com.drerp.financeiro.business.transferencia.SalarioBR;
import br.com.drerp.financeiro.model.transferencia.ContaPagar;
import br.com.drerp.financeiro.model.transferencia.Transferencia;
import br.com.drerp.financeiro.model.transferencia.Salario;

@ManagedBean(name="transferenciaOutBean")
@RequestScoped
public class TransferenciaOutBean implements Serializable{
	
	private static final long serialVersionUID = -3229300148690484732L;

	private Transferencia contaPagar;
	
	private List<Transferencia> contaPagarList;
	
	private ContaPagarBR contaPagarBR;
	
	private SalarioBR salarioBR;
	
	public TransferenciaOutBean() {
		contaPagarBR = new ContaPagarBR();
		salarioBR = new SalarioBR();
		contaPagar = new ContaPagar();
	}
	
	public String realizarTransferencia(){
		// falta umas condicoes aquiiii !! verificar o status antes!!
		if(contaPagar.getClass().equals(ContaPagar.class)){
			contaPagarBR.realizarTransferencia((ContaPagar)contaPagar);
		} else if(contaPagar.getClass().equals(Salario.class)){
			salarioBR.realizarTransferencia((Salario)contaPagar);
		}
		
		// para atualizar a lista
		this.contaPagarList = null;
		return null;
	}
	
	public String delete() {
		if(contaPagar.getClass().equals(ContaPagar.class)){
			contaPagarBR.delete((ContaPagar)this.contaPagar);
		} else if(contaPagar.getClass().equals(Salario.class)){
			salarioBR.delete((Salario)this.contaPagar);
		}
		// para atualizar a lista
		this.contaPagarList = null;
		return null;
	}
	
	public String registrarErro() {
		if(contaPagar.getClass().equals(ContaPagar.class)){
			contaPagarBR.registrarErro((ContaPagar)this.contaPagar);
		} else if(contaPagar.getClass().equals(Salario.class)){
			salarioBR.registrarErro((Salario)this.contaPagar);
		}
		// para atualizar a lista
		this.contaPagarList = null;
		return null;
	}
	
	public List<Transferencia> getContaPagarList() {
		contaPagarList = new ArrayList<Transferencia>();
		contaPagarList.addAll(contaPagarBR.listarAbertas());
		contaPagarList.addAll(salarioBR.listarPendentes());
		contaPagarList.addAll(contaPagarBR.listarEfetuadas());
		contaPagarList.addAll(salarioBR.listarEfetuadas());
		return contaPagarList;
	}

	public void setContaPagarList(List<Transferencia> listaAprovada) {
		this.contaPagarList = listaAprovada;
	}

	public Transferencia getContaPagar() {
		return contaPagar;
	}

	public void setContaPagar(Transferencia contaPagar) {
		this.contaPagar = contaPagar;
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
