package br.com.drerp.financeiro.web.transferencia;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.transferencia.BeneficiarioBR;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;

@ManagedBean(name = "BeneficiarioBean")
@RequestScoped
public class BeneficiarioBean {
	private Beneficiario beneficiario;
	private BeneficiarioBR beneficiarioBR;
	private List<Beneficiario> beneficiarios;

	public BeneficiarioBean() {
		this.beneficiario = new Beneficiario();
		this.beneficiarioBR = new BeneficiarioBR();
	}

	public String edit() {
		return "edit";
	}

	public String view() {
		return "view";
	}

	public String create() {
		this.beneficiario = new Beneficiario();
		return edit();
	}

	public String save() {
		this.beneficiarioBR.save(this.beneficiario);
		return list();
	}

	public String delete() {
		this.beneficiarioBR.delete(this.beneficiario);
		return list();
	}

	public String list() {
		return "list";
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public List<Beneficiario> getBeneficiarios() {
		this.beneficiarios = beneficiarioBR.list();
		return this.beneficiarios;
	}

	public void setBeneficiarios(List<Beneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

}
