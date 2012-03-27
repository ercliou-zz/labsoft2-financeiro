package br.com.drerp.financeiro.model.tabela;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;

@Entity
@Table(name="FIN_VALOR")
public class Valor extends GenericModel{
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="itemTabela_fk")
	private ItemTabela itemTabela;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="coluna_fk")
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
	public String getValorMoeda(){
		if(valor != null){
		DecimalFormat formatter = new DecimalFormat();
		formatter.setMaximumFractionDigits(2);
		return formatter.format(valor);
		}
		return "-";
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
