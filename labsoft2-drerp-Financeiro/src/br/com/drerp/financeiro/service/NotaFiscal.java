package br.com.drerp.financeiro.service;

import java.io.Serializable;
import java.math.BigDecimal;

public class NotaFiscal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1483745360666283968L;
	private BigDecimal valor;
	private BigDecimal descontos;
	
	public NotaFiscal() {
		
	}
	
	public NotaFiscal(BigDecimal valor) {
		this.valor = valor;
		BigDecimal d = new BigDecimal(0.08);
		this.descontos = valor.multiply(d);
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getDescontos() {
		return descontos;
	}

	public void setDescontos(BigDecimal descontos) {
		this.descontos = descontos;
	}

}
