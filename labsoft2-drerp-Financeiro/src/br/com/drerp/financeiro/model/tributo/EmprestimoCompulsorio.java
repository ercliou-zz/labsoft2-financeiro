package br.com.drerp.financeiro.model.tributo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.dao.GenericModel;

@Entity
@Table(name = "FIN_EMPRESTIMO_COMPULSORIO")
public class EmprestimoCompulsorio extends GenericModel {

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Tributo.class)
	private Tributo tributo;

	public Tributo getTributo() {
		return tributo;
	}

	public void setTributo(Tributo tributo) {
		this.tributo = tributo;
	}

}