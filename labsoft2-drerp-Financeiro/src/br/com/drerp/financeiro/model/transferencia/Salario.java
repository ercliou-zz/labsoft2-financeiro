package br.com.drerp.financeiro.model.transferencia;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="FIN_SALARIO")
public class Salario extends ContaPagar{
	
	private Integer horasTrabalhadas;
	private String cargo;
	
	@OneToOne
	@JoinColumn(name="hollertih_fk")
	private Hollerith hollerith;
	
	public Integer getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(Integer horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Hollerith getHollerith() {
		return hollerith;
	}
	public void setHollerith(Hollerith hollerith) {
		this.hollerith = hollerith;
	}

}
