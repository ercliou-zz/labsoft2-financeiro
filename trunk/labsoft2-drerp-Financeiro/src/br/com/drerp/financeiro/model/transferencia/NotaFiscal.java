package br.com.drerp.financeiro.model.transferencia;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;

@Entity
@Table(name = "FIN_NOTAFISCAL")
public class NotaFiscal extends GenericModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2949266713763971487L;

	@OneToOne
	@JoinColumn(name = "contaReceber_fk")
	private ContaReceber contaReceber;

	private Integer aliquotaIcms;
	private Integer aliquotaIss;
	private Integer aliquotaIpi;

	private BigDecimal icms;
	private BigDecimal iss;
	private BigDecimal ipi;

	private BigDecimal valorFinal;

	private Date dataEmissao;

	public ContaReceber getContaReceber() {
		return contaReceber;
	}

	public void setContaReceber(ContaReceber contaReceber) {
		this.contaReceber = contaReceber;
	}

	public Integer getAliquotaIcms() {
		return aliquotaIcms;
	}

	public void setAliquotaIcms(Integer aliquotaIcms) {
		this.aliquotaIcms = aliquotaIcms;
	}

	public Integer getAliquotaIss() {
		return aliquotaIss;
	}

	public void setAliquotaIss(Integer aliquotaIss) {
		this.aliquotaIss = aliquotaIss;
	}

	public Integer getAliquotaIpi() {
		return aliquotaIpi;
	}

	public void setAliquotaIpi(Integer aliquotaIpi) {
		this.aliquotaIpi = aliquotaIpi;
	}

	public BigDecimal getIcms() {
		return icms;
	}

	public void setIcms(BigDecimal icms) {
		this.icms = icms;
	}

	public BigDecimal getIss() {
		return iss;
	}

	public void setIss(BigDecimal iss) {
		this.iss = iss;
	}

	public BigDecimal getIpi() {
		return ipi;
	}

	public void setIpi(BigDecimal ipi) {
		this.ipi = ipi;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

}
