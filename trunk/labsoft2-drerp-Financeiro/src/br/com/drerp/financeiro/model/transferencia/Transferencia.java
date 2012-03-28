package br.com.drerp.financeiro.model.transferencia;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import br.com.drerp.financeiro.model.GenericModel;


@MappedSuperclass
public class Transferencia extends GenericModel {

	@OneToOne
	private Beneficiario beneficiario;
	
	@OneToOne
	private Pagador pagador;
	
	private BigDecimal valor;
	
	private StatusTransferencia status;
	
	private Long dataRequisicaoMilis;
	
	private Long dataLimiteMilis;
	
	private Long dataRealizacaoMilis;
	
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Pagador getPagador() {
		return pagador;
	}

	public void setPagador(Pagador pagador) {
		this.pagador = pagador;
	}

	public Long getDataRequisicaoMilis() {
		return dataRequisicaoMilis;
	}

	public void setDataRequisicaoMilis(Long dataRequisicaoMilis) {
		this.dataRequisicaoMilis = dataRequisicaoMilis;
	}

	@Transient
	public Date getDataRequisicao() {
		return new Date(this.dataRequisicaoMilis);
	}

	public Long getDataLimiteMilis() {
		return dataLimiteMilis;
	}

	public void setDataLimiteMilis(Long dataLimiteMilis) {
		this.dataLimiteMilis = dataLimiteMilis;
	}

	public Date getDataLimite() {
		return new Date(this.dataLimiteMilis);
	}
	
	public Long getDataRealizacaoMilis() {
		return dataRealizacaoMilis;
	}

	public void setDataRealizacaoMilis(Long dataRealizacaoMilis) {
		this.dataRealizacaoMilis = dataRealizacaoMilis;
	}
	
	public Date getDataRealizacao() {
		return new Date(this.dataRealizacaoMilis);
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public StatusTransferencia getStatus() {
		return status;
	}

	public void setStatus(StatusTransferencia status) {
		this.status = status;
	}

}
