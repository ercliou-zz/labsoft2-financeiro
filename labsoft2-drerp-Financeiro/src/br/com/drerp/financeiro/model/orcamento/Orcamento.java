package br.com.drerp.financeiro.model.orcamento;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.dao.GenericModel;


@Entity
@Table (name = "FIN_ORCAMENTO")
public class Orcamento extends GenericModel {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pedido_fk")
	private PedidoOrcamento pedido;
	
	private BigDecimal acrescimo;
	
	private BigDecimal valorFinal;

	public PedidoOrcamento getPedido() {
		return pedido;
	}

	public void setPedido(PedidoOrcamento pedido) {
		this.pedido = pedido;
	}

	public BigDecimal getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(BigDecimal acrescimo) {
		this.acrescimo = acrescimo;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	
	
}
