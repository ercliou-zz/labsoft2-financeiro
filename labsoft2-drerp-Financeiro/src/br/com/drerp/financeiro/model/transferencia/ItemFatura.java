package br.com.drerp.financeiro.model.transferencia;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;
import br.com.drerp.financeiro.model.procedimento.Procedimento;

@Entity
@Table(name="FIN_ITEMFATURA")
public class ItemFatura extends GenericModel{
	
	@OneToOne
	@JoinColumn(name="fatura_fk")
	private Fatura fatura;
	
	@OneToOne
	@JoinColumn(name="procedimento_fk")
	private Procedimento procedimento;
	
	private BigDecimal valor;
	
	public Fatura getFatura() {
		return fatura;
	}
	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	public Procedimento getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getValorFormatado(){
		if (valor != null) {
			DecimalFormat formatter = new DecimalFormat();
			formatter.setMaximumFractionDigits(2);
			return "R$ " + formatter.format(valor);
		}
		return "Indefinido";
	}
	
}
