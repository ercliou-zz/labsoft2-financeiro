package br.com.drerp.financeiro.model.tabela;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.drerp.financeiro.dao.GenericModel;

@Entity
@Table(name="FIN_ITEMTABELA")
public class ItemTabela extends GenericModel{
	
	private String nome;
	
	@OneToMany(mappedBy="itemTabela")
	private List<Valor> valores;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=Tabela.class )
	private Tabela tabela;
	
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
	public Tabela getTabela() {
		return tabela;
	}
	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}
	
}
