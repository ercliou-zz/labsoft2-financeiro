package br.com.drerp.financeiro.model.planosaude;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericLog;

@Entity
@Table(name="FIN_LOG_PLANOSAUDE")
public class PlanoSaudeLog extends GenericLog{
	
	private String nomeAntigo;
	private String nomeNovo;
	private Long planoSaudeId;
	
	public PlanoSaudeLog() {
		super();
	}
	public String getNomeAntigo() {
		return nomeAntigo;
	}
	public void setNomeAntigo(String nomeAntigo) {
		this.nomeAntigo = nomeAntigo;
	}
	public String getNomeNovo() {
		return nomeNovo;
	}
	public void setNomeNovo(String nomeNovo) {
		this.nomeNovo = nomeNovo;
	}
	public Long getPlanoSaudeId() {
		return planoSaudeId;
	}
	public void setPlanoSaudeId(Long planoSaudeId) {
		this.planoSaudeId = planoSaudeId;
	}
	
}
