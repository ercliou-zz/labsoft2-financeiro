package br.com.drerp.financeiro.model.planosaude;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;
import br.com.drerp.financeiro.model.transferencia.Fatura;

@Entity
@Table(name="FIN_GLOSA")
public class Glosa extends GenericModel{
	
	@OneToOne
	private Guia guia;
	
	@ManyToMany
	private List<Fatura> faturasGlosadas;

	public Guia getGuia() {
		return guia;
	}

	public void setGuia(Guia guia) {
		this.guia = guia;
	}

	public List<Fatura> getFaturasGlosadas() {
		return faturasGlosadas;
	}

	public void setFaturasGlosadas(List<Fatura> faturasGlosadas) {
		this.faturasGlosadas = faturasGlosadas;
	}
	
}
