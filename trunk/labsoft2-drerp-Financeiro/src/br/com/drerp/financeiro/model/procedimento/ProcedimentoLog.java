package br.com.drerp.financeiro.model.procedimento;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericLog;

@Entity
@Table(name="FIN_LOG_PROCEDIMENTO")
public class ProcedimentoLog extends GenericLog{
	
	private String nomeAntigo;
	private String nomeNovo;
	
	private TipoProcedimento tipoAntigo;
	private TipoProcedimento tipoNovo;
	
	private Long procedimentoId;
	
	public ProcedimentoLog() {
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
	public TipoProcedimento getTipoAntigo() {
		return tipoAntigo;
	}
	public void setTipoAntigo(TipoProcedimento tipoAntigo) {
		this.tipoAntigo = tipoAntigo;
	}
	public TipoProcedimento getTipoNovo() {
		return tipoNovo;
	}
	public void setTipoNovo(TipoProcedimento tipoNovo) {
		this.tipoNovo = tipoNovo;
	}
	public Long getProcedimentoId() {
		return procedimentoId;
	}
	public void setProcedimentoId(Long procedimentoId) {
		this.procedimentoId = procedimentoId;
	}
	
}
