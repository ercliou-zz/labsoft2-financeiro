package br.com.drerp.financeiro.dao.transferencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;
import br.com.drerp.financeiro.model.transferencia.TipoBeneficiario;

public class BeneficiarioDAOImpl extends GenericDAOImpl<Beneficiario> implements
		BeneficiarioDAO {

	public List<Beneficiario> listarEmpresas() {
		List<Beneficiario> beneficiarioList = this.list();
		List<Beneficiario> empresas = new ArrayList<Beneficiario>();
		for (Beneficiario b : beneficiarioList) {
			if (b.getTipoBeneficiario().equals(TipoBeneficiario.EMPRESA)) {
				empresas.add(b);
			}
		}
		return empresas;
	}

	public Beneficiario getClinica() {
		return (Beneficiario) this.session.createCriteria(Beneficiario.class)
				.add(Restrictions.eq("nome", "Clinica")).uniqueResult();

	}

	public Beneficiario salvar(Beneficiario beneficiario) {
		Beneficiario b = null;
		if (beneficiario.getDocumento() != null) {
			b = (Beneficiario) this.session
					.createCriteria(Beneficiario.class)
					.add(Restrictions.eq("documento",
							beneficiario.getDocumento())).uniqueResult();
		}
		if (b == null) {
			this.session.save(beneficiario);
			this.session.flush();
			b = beneficiario;
		}
		return b;
	}
}
