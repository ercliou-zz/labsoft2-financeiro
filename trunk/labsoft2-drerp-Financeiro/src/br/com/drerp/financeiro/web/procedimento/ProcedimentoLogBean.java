package br.com.drerp.financeiro.web.procedimento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.procedimento.ProcedimentoBR;
import br.com.drerp.financeiro.business.procedimento.ProcedimentoLogBR;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.procedimento.ProcedimentoLog;

@ManagedBean(name="procedimentoLogBean")
@RequestScoped
public class ProcedimentoLogBean {
	
	private LogType tipoLog;
	
	private Long procedimentoSelecionado;
	
	private Date dataInicial;
	private Date dataFinal;
	
	private ProcedimentoLogBR procedimentoLogBR;
	private ProcedimentoBR procedimentoBR;
	private List<Procedimento> procedimentosList;
	
	private List<ProcedimentoLog> procedimentoLogList;
	
	public ProcedimentoLogBean(){
		this.procedimentoBR = new ProcedimentoBR();
		this.procedimentoLogBR = new ProcedimentoLogBR();
		this.procedimentosList = new ArrayList<Procedimento>();
	}

	
	public String filtrar(){
		procedimentoLogList = procedimentoLogBR.filtrar(tipoLog, procedimentoSelecionado, dataInicial, dataFinal);
		return null;
	}
	
	
	public Long getPlanoSelecionado() {
		return procedimentoSelecionado;
	}

	public void setPlanoSelecionado(Long procedimento) {
		this.procedimentoSelecionado = procedimento;
	}
	
	public List<Procedimento> getPlanosList() {
		this.procedimentosList = procedimentoBR.list();
		return this.procedimentosList;
	}

	public void setPlanosList(List<Procedimento> procedimentos) {
		this.procedimentosList = procedimentos;
	}

	public LogType getTipoLog() {
		return tipoLog;
	}

	public void setTipoLog(LogType tipoLog) {
		this.tipoLog = tipoLog;
	}

	public List<ProcedimentoLog> getProcedimentoLogList() {
		return procedimentoLogList;
	}

	public void setProcedimentoLogList(List<ProcedimentoLog> procedimentoLogList) {
		this.procedimentoLogList = procedimentoLogList;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	
}
