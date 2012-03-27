package br.com.drerp.financeiro.model.transferencia;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;

@Entity
@Table(name="FIN_HOLLERITH")
public class Hollerith extends GenericModel{
	
	@OneToOne
	private Salario salario;

	public Salario getSalario() {
		return salario;
	}

	public void setSalario(Salario salario) {
		this.salario = salario;
	}
	
}
