package br.com.drerp.financeiro.web.transferencia;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.transferencia.BeneficiarioBR;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;

@ManagedBean(name="BeneficiarioBean")
@RequestScoped
public class BeneficiarioBean {
	private Beneficiario beneficiario;
	private BeneficiarioBR beneficiarioBR;
	private List<Beneficiario> listaAprovada;
	
	public BeneficiarioBean() {
		this.beneficiario = new Beneficiario();
		this.beneficiarioBR = new BeneficiarioBR();
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	
	public List<Beneficiario> getListaAprovada() {
		this.listaAprovada = beneficiarioBR.list();
		return listaAprovada;
	}
	
	public String save(){
		beneficiarioBR.save(beneficiario);
		return "beneficiarioList";
	}

}
