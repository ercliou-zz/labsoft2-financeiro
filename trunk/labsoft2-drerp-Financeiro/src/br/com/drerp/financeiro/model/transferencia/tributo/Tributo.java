package br.com.drerp.financeiro.model.transferencia.tributo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.dao.GenericModel;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

@Entity
@Table(name = "FIN_TRIBUTO")
public class Tributo extends GenericModel {

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = TributoMensal.class)
	private TributoMensal tributoMensal;

	@OneToOne(mappedBy = "requisicao", cascade = CascadeType.ALL)
	private Transferencia transferencia;

	@OneToMany(mappedBy = "tributo")
	private List<Imposto> impostos;

	@OneToMany(mappedBy = "tributo")
	private List<Taxa> taxas;

	@OneToMany(mappedBy = "tributo")
	private List<ContribuicaoEspecial> contribuicoesEpeciais;

	@OneToMany(mappedBy = "tributo")
	private List<EmprestimoCompulsorio> emprestimoCompulsorios;

	public TributoMensal getTributoMensal() {
		return tributoMensal;
	}

	public void setTributoMensal(TributoMensal tributoMensal) {
		this.tributoMensal = tributoMensal;
	}

	public Transferencia getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;
	}

	public List<Imposto> getImpostos() {
		return impostos;
	}

	public void setImpostos(List<Imposto> impostos) {
		this.impostos = impostos;
	}

	public List<Taxa> getTaxas() {
		return taxas;
	}

	public void setTaxas(List<Taxa> taxas) {
		this.taxas = taxas;
	}

	public List<ContribuicaoEspecial> getContribuicoesEpeciais() {
		return contribuicoesEpeciais;
	}

	public void setContribuicoesEpeciais(
			List<ContribuicaoEspecial> contribuicoesEpeciais) {
		this.contribuicoesEpeciais = contribuicoesEpeciais;
	}

	public List<EmprestimoCompulsorio> getEmprestimoCompulsorios() {
		return emprestimoCompulsorios;
	}

	public void setEmprestimoCompulsorios(
			List<EmprestimoCompulsorio> emprestimoCompulsorios) {
		this.emprestimoCompulsorios = emprestimoCompulsorios;
	}

}
