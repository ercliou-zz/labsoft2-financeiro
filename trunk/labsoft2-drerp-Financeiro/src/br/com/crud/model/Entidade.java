package br.com.crud.model;

import javax.persistence.Entity;

import br.com.drerp.financeiro.model.GenericModel;

@Entity
public class Entidade extends GenericModel {

	private String propriedade;

	public String getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(String propriedade) {
		this.propriedade = propriedade;
	}

}
