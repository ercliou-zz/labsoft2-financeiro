package br.com.drerp.financeiro.model.transferencia;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.drerp.financeiro.dao.GenericModel;


@Entity
@Table(name = "FIN_REQUISICAO")
public class RequisicaoTransferencia extends GenericModel {

	@OneToOne
	private Beneficiario beneficiario;
	
	private BigDecimal valor;
	
	@OneToOne
	private Pagador pagador;
	
	private StatusRequisicaoTransferencia status;
	
	private Long dataRequisicaoMilis;
	
	private Long dataLimiteMilis;
	
	@OneToOne(mappedBy = "requisicao", cascade = CascadeType.ALL)
	private Transferencia transferencia;

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

	public StatusRequisicaoTransferencia getStatus() {
		return status;
	}

	public void setStatus(StatusRequisicaoTransferencia status) {
		this.status = status;
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

	public Transferencia getTransferencia() {
		return transferencia;
	}

	public void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
