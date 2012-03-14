package br.com.drerp.financeiro.model.transferencia;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="FIN_TRANSFERENCIA")
public class Transferencia extends GenericModel {
	
	private BigDecimal valor;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="requisicao_fk")
	private RequisicaoTransferencia requisicao;
	private Long dataRealizacaoMilis;
	
	private CategoriaTransferencia categoria;

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
