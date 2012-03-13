package br.com.drerp.financeiro.model.transferencia;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FIN_REQUISICAO")
public class RequisicaoTransferencia {
	
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private Beneficiario beneficiario;
	@OneToOne
	private Pagador pagador;
	private StatusRequisicaoTransferencia status;
	private Long dataRequisicaoMilis;
	private Long dataLimiteMilis;
	@OneToOne(mappedBy = "requisicao")
	private Transferencia transferencia;
	
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
	public Long getDataLimiteMilis() {
		return dataLimiteMilis;
	}
	public void setDataLimiteMilis(Long dataLimiteMilis) {
		this.dataLimiteMilis = dataLimiteMilis;
	}
	public Date getDataLimite(){
		return new Date(this.dataLimiteMilis);
	}
	public Transferencia getTransferencia() {
		return transferencia;
	}
	public void setTransferencia(Transferencia transferencia) {
		this.transferencia = transferencia;
	}
	
}
