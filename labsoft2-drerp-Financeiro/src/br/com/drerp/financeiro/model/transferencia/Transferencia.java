package br.com.drerp.financeiro.model.transferencia;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import br.com.drerp.financeiro.model.GenericModel;


@MappedSuperclass
public class Transferencia extends GenericModel {

	@OneToOne
	@JoinColumn(name="beneficiario_fk")
	private Beneficiario beneficiario;
	
	@OneToOne
	@JoinColumn(name="pagador_fk")
	private Pagador pagador;
	
	private BigDecimal valor;
	
	private StatusTransferencia status;
	
	private Long dataRequisicaoMilis;
	
	private Long dataLimiteMilis;
	
	private Long dataRealizacaoMilis;
	
	private Departamento departamento;
	
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
		if(dataRequisicaoMilis!=null)
		return new Date(this.dataRequisicaoMilis);
		else return null;
	}

	public Long getDataLimiteMilis() {
		return dataLimiteMilis;
	}

	public void setDataLimiteMilis(Long dataLimiteMilis) {
		this.dataLimiteMilis = dataLimiteMilis;
	}

	public Date getDataLimite() {
		if(dataLimiteMilis!=null)
		return new Date(this.dataLimiteMilis);
		else return null;
	}
	
	public Long getDataRealizacaoMilis() {
		return dataRealizacaoMilis;
	}

	public void setDataRealizacaoMilis(Long dataRealizacaoMilis) {
		this.dataRealizacaoMilis = dataRealizacaoMilis;
	}
	
	public Date getDataRealizacao() {
		if(dataRealizacaoMilis!=null)
			return new Date(this.dataRealizacaoMilis);
		else
			return null;
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	

}
