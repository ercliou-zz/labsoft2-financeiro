package br.com.drerp.financeiro.model.tabela;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.drerp.financeiro.dao.GenericModel;

@Entity
@Table(name="FIN_ITEMTABELA")
public class ItemTabela extends GenericModel{
	
	private String nome;
	private List<Valor> valores;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Valor> getValores() {
		return valores;
	}
	public void setValores(List<Valor> valores) {
		this.valores = valores;
	}
}
