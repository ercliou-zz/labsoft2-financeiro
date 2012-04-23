package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;

public interface BeneficiarioDAO extends GenericDAO<Beneficiario> {
	public List<Beneficiario> listarEmpresas();
	public Beneficiario getClinica();
	public Beneficiario salvar(Beneficiario beneficiario);
}
