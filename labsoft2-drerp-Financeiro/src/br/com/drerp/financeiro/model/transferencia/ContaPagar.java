package br.com.drerp.financeiro.model.transferencia;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity
@Table(name="FIN_CONTAPAGAR")
@MappedSuperclass
public class ContaPagar extends Transferencia{
	
	private Departamento departamento;

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
