package br.com.drerp.financeiro.model.transferencia;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RequisicaoTransferencia {
	
	@Id
	@GeneratedValue
	private Long id;
	private Beneficiario beneficiario;
	private Pagador pagador;
	private StatusRequisicaoTransferencia status;
	private Long dataRequisicaoMilis;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Date getDataRequisicao(){
		return new Date(this.dataRequisicaoMilis);
	}
	
}
