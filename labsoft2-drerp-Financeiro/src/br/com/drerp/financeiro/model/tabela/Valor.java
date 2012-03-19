package br.com.drerp.financeiro.model.tabela;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.drerp.financeiro.dao.GenericModel;

@Entity
@Table(name="FIN_VALOR")
public class Valor extends GenericModel{
	
	private ItemTabela itemTabela;
	private Coluna coluna;
	private BigDecimal valor;
	
	public ItemTabela getItemTabela() {
		return itemTabela;
	}
	public void setItemTabela(ItemTabela itemTabela) {
		this.itemTabela = itemTabela;
	}
	public Coluna getColuna() {
		return coluna;
	}
	public void setColuna(Coluna coluna) {
		this.coluna = coluna;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
