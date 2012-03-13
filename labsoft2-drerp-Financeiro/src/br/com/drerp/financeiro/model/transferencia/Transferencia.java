package br.com.drerp.financeiro.model.transferencia;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Transferencia {
	
	@Id
	@GeneratedValue
	private long id;
	private BigDecimal valor;
	private RequisicaoTransferencia requisicao;
	private Long dataRealizacaoMilis;
	
	private CategoriaTransferencia categoria;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Long getDataRealizacaoMilis() {
		return dataRealizacaoMilis;
	}
	public void setDataRealizacaoMilis(Long dataRealizacaoMilis) {
		this.dataRealizacaoMilis = dataRealizacaoMilis;
	}
	
	@Transient
	public Date getDataRealizacao() {
		return new Date(this.dataRealizacaoMilis);
	}
	
	public RequisicaoTransferencia getRequisicao() {
		return requisicao;
	}
	public void setRequisicao(RequisicaoTransferencia requisicao) {
		this.requisicao = requisicao;
	}
	public CategoriaTransferencia getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaTransferencia categoria) {
		this.categoria = categoria;
	}
	
	
}
