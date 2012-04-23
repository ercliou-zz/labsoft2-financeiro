package br.com.drerp.financeiro.business.transferencia;

import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.transferencia.BeneficiarioDAOImpl;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;

public class BeneficiarioBR extends GenericBR<BeneficiarioDAOImpl, Beneficiario> {
	
	public List<Beneficiario> listarEmpresas() {
		return this.dao.listarEmpresas();
	}

	public Beneficiario getClinica() {
		return this.dao.getClinica();
	}
	
	
	public Beneficiario salvar(Beneficiario beneficiario) {
		return this.dao.salvar(beneficiario);		
	}
}
