package br.com.drerp.financeiro.model.planosaude;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;

@Entity
@Table(name="FIN_PLANOSAUDE")
public class PlanoSaude extends GenericModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
