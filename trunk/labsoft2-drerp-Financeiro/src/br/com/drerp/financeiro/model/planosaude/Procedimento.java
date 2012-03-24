package br.com.drerp.financeiro.model.planosaude;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;

@Entity
@Table(name="FIN_PROCEDIMENTO")
public class Procedimento extends GenericModel {

	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}