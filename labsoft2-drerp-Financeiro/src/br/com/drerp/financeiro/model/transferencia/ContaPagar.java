package br.com.drerp.financeiro.model.transferencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FIN_CONTAPAGAR")
public class ContaPagar extends Transferencia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2207536572978139692L;
	private Departamento departamento;

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
