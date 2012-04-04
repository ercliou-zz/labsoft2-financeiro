package br.com.drerp.financeiro.web.procedimento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.planosaude.PlanoSaudeBR;
import br.com.drerp.financeiro.business.procedimento.ProcedimentoBR;
import br.com.drerp.financeiro.business.procedimento.ValorLogBR;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.tabela.ValorLog;


@ManagedBean(name="valorLogBean")
@RequestScoped
public class ValorLogBean {
	
	private LogType tipoLog;
	
	private Long planoSelecionado;
	private Long procedimentoSelecionado;
	
	private Date dataInicial;
	private Date dataFinal;
	
	private List<PlanoSaude> planosList;
	private List<Procedimento> procedimentosList;
	
	private ValorLogBR valorLogBR;
	private ProcedimentoBR procedimentoBR;
	private PlanoSaudeBR planoBR;
	
	private List<ValorLog> valorLogList;
	private ValorLog valorLog;
	
	public ValorLogBean(){
		this.planoBR = new PlanoSaudeBR();
		this.procedimentoBR = new ProcedimentoBR();
		this.valorLogBR = new ValorLogBR();
		valorLogList = valorLogBR.filtrar(null, 0l, 0l, null, null);
		this.planosList = new ArrayList<PlanoSaude>();
		this.procedimentosList = new ArrayList<Procedimento>();
	}

	public String filtrar(){
		valorLogList = valorLogBR.filtrar(tipoLog, planoSelecionado, procedimentoSelecionado, dataInicial, dataFinal);
		return "valorLog";
	}
	
	public String view(){
		return "valorLogView";
	}
	
	public List<PlanoSaude> getPlanosList() {
		this.planosList = planoBR.list();
		return planosList;
	}

	public void setPlanosList(List<PlanoSaude> planosList) {
		this.planosList = planosList;
	}

	public List<Procedimento> getProcedimentosList() {
		this.procedimentosList = procedimentoBR.list();
		return procedimentosList;
	}

	public void setProcedimentosList(List<Procedimento> procedimentosList) {
		this.procedimentosList = procedimentosList;
	}

	public Long getPlanoSelecionado() {
		return planoSelecionado;
	}

	public void setPlanoSelecionado(Long planoSelecionado) {
		this.planoSelecionado = planoSelecionado;
	}

	public Long getProcedimentoSelecionado() {
		return procedimentoSelecionado;
	}

	public void setProcedimentoSelecionado(Long procedimentoSelecionado) {
		this.procedimentoSelecionado = procedimentoSelecionado;
	}

	public LogType getTipoLog() {
		return tipoLog;
	}

	public void setTipoLog(LogType tipoLog) {
		this.tipoLog = tipoLog;
	}

	public List<ValorLog> getValorLogList() {
		return valorLogList;
	}

	public void setValorLogList(List<ValorLog> valorLogList) {
		this.valorLogList = valorLogList;
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


	public ValorLog getValorLog() {
		return valorLog;
	}

	public void setValorLog(ValorLog valorLog) {
		this.valorLog = valorLog;
	}
	
}
