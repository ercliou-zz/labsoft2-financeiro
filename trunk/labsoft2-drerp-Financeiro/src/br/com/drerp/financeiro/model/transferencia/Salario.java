package br.com.drerp.financeiro.model.transferencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="FIN_SALARIO")
public class Salario extends Transferencia implements Serializable{

	private static final long serialVersionUID = -4609449064720654970L;
	
	private Integer horasTrabalhadas;
	private String cargo;
	
	@OneToOne
	@JoinColumn(name="hollertih_fk")
	private Hollerith hollerith;
	
	public Salario () {
		super();
	}
		
	public Salario (Transferencia transferencia) {
		this.setBeneficiario(transferencia.getBeneficiario());
		this.setDataLimiteMilis(transferencia.getDataLimiteMilis());
		this.setDataRealizacaoMilis(transferencia.getDataRealizacaoMilis());
		this.setDataRequisicaoMilis(transferencia.getDataRequisicaoMilis());
		this.setPagador(transferencia.getPagador());
		this.setStatus(transferencia.getStatus());
		this.setValor(transferencia.getValor());
	}

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
