package br.com.drerp.financeiro.model.tabela;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;

@Entity
@Table(name="FIN_TABELA")
public class Tabela extends GenericModel{
	
	@OneToMany(mappedBy="tabela")
	private List<Coluna> colunas;
	
	@OneToMany(mappedBy="tabela")
	private List<ItemTabela> itens;
	
	public List<Coluna> getColunas() {
		return colunas;
	}
	public void setColunas(List<Coluna> colunas) {
		this.colunas = colunas;
	}
	public List<ItemTabela> getItens() {
		return itens;
	}
	public void setItens(List<ItemTabela> itens) {
		this.itens = itens;
	}
}
