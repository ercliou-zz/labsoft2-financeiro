package br.com.drerp.financeiro.model.tributo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;

@Entity
@Table(name = "FIN_CONTRIBUICAO_ESPECIAL")
public class ContribuicaoEspecial extends GenericModel {

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Tributo.class)
	private Tributo tributo;

	public Tributo getTributo() {
		return tributo;
	}

	public void setTributo(Tributo tributo) {
		this.tributo = tributo;
	}

}