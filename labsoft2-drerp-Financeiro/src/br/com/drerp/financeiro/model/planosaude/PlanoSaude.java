package br.com.drerp.financeiro.model.planosaude;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.drerp.financeiro.dao.GenericModel;

@Entity
@Table(name="FIN_PLANOSAUDE")
public class PlanoSaude extends GenericModel {

	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
