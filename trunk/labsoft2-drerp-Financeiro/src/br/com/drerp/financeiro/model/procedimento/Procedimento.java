package br.com.drerp.financeiro.model.procedimento;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;

@Entity
@Table(name="FIN_PROCEDIMENTO")
public class Procedimento extends GenericModel implements Serializable{

	private static final long serialVersionUID = 5563295864678578999L;
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}