package br.com.drerp.financeiro.model.planosaude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.drerp.financeiro.dao.GenericModel;

@Entity
@Table(name="FIN_PLANOSAUDE")
public class PlanoSaude extends GenericModel {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private TabelaPrecos tabela;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TabelaPrecos getTabela() {
		return tabela;
	}
	public void setTabela(TabelaPrecos tabela) {
		this.tabela = tabela;
	}
	
}
