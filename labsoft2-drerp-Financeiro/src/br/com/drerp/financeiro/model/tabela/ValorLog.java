package br.com.drerp.financeiro.model.tabela;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericLog;

@Entity
@Table(name="FIN_LOG_VALOR")
public class ValorLog extends GenericLog{
	
	private BigDecimal valorAntigo;
	private BigDecimal valorNovo;
	private Long planoSaudeId;
	private Long procedimentoId;
	
	public ValorLog() {
		super();
	}
	
	public BigDecimal getValorAntigo() {
		return valorAntigo;
	}

	public void setValorAntigo(BigDecimal valorAntigo) {
		this.valorAntigo = valorAntigo;
	}

	public BigDecimal getValorNovo() {
		return valorNovo;
	}

	public void setValorNovo(BigDecimal valorNovo) {
		this.valorNovo = valorNovo;
	}

	public Long getPlanoSaudeId() {
		return planoSaudeId;
	}
	public void setPlanoSaudeId(Long planoSaudeId) {
		this.planoSaudeId = planoSaudeId;
	}

	public Long getProcedimentoId() {
		return procedimentoId;
	}
	public void setProcedimentoId(Long procedimentoId) {
		this.procedimentoId = procedimentoId;
	}
	
}
