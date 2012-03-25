package br.com.drerp.financeiro.web.planosaude;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.planosaude.PlanoSaudeBR;
import br.com.drerp.financeiro.business.planosaude.PlanoSaudeLogBR;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.planosaude.PlanoSaudeLog;

@ManagedBean(name="planoSaudeLogBean")
@RequestScoped
public class PlanoSaudeLogBean {
	
	private LogType tipoLog;
	
	private Long planoSelecionado;
	
	private Date dataInicial;
	private Date dataFinal;
	
	private PlanoSaudeLogBR planoLogBR;
	private PlanoSaudeBR planoBR;
	private List<PlanoSaude> planosList;
	
	private List<PlanoSaudeLog> planoSaudeLogList;
	
	public PlanoSaudeLogBean(){
		this.planoBR = new PlanoSaudeBR();
		this.planoLogBR = new PlanoSaudeLogBR();
		this.planosList = new ArrayList<PlanoSaude>();
	}

	
	public String filtrar(){
		planoSaudeLogList = planoLogBR.filtrar(tipoLog, planoSelecionado, dataInicial, dataFinal);
		return null;
	}
	
	
	public Long getPlanoSelecionado() {
		return planoSelecionado;
	}

	public void setPlanoSelecionado(Long plano) {
		this.planoSelecionado = plano;
	}
	
	public List<PlanoSaude> getPlanosList() {
		this.planosList = planoBR.list();
		return this.planosList;
	}

	public void setPlanosList(List<PlanoSaude> planos) {
		this.planosList = planos;
	}

	public LogType getTipoLog() {
		return tipoLog;
	}

	public void setTipoLog(LogType tipoLog) {
		this.tipoLog = tipoLog;
	}

	public List<PlanoSaudeLog> getPlanoSaudeLogList() {
		return planoSaudeLogList;
	}

	public void setPlanoSaudeLogList(List<PlanoSaudeLog> planoSaudeLogList) {
		this.planoSaudeLogList = planoSaudeLogList;
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
