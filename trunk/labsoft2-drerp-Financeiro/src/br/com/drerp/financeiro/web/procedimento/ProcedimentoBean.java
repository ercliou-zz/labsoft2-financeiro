package br.com.drerp.financeiro.web.procedimento;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.procedimento.ProcedimentoBR;
import br.com.drerp.financeiro.model.procedimento.Procedimento;

@ManagedBean(name="procedimentoBean")
@RequestScoped
public class ProcedimentoBean {
	
	private Procedimento procedimento;
	private ProcedimentoBR procedimentoBR;
	private List<Procedimento> procedimentos;
	
	public ProcedimentoBean(){
		this.procedimento = new Procedimento();
		this.procedimentoBR = new ProcedimentoBR();
		this.procedimentos = new ArrayList<Procedimento>();
	}

	public String edit() {
		return "edit";
	}
	
	public String view(){
		return "view";
	}
	
	public String create() {
		this.procedimento = new Procedimento();
		return edit();
	}
	
	public String save() {
		this.procedimentoBR.save(this.procedimento);
		return list();
	}

	public String delete(){
		this.procedimentoBR.delete(this.procedimento);
		return list();
	}
	
	public String list() {
		return "list";
	}
	
	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}
	
	public List<Procedimento> getProcedimentos() {
		this.procedimentos = procedimentoBR.list();
		return this.procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}
	
}
