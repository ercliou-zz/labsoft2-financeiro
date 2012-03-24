package br.com.drerp.financeiro.web.planosaude;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.planosaude.PlanoSaudeBR;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

@ManagedBean(name="PlanoSaudeBean")
@RequestScoped
public class PlanoSaudeBean {
	
	private PlanoSaude plano;
	private PlanoSaudeBR planoBR;
	private List<PlanoSaude> planos;
	
	public PlanoSaudeBean(){
		this.plano = new PlanoSaude();
		this.planoBR = new PlanoSaudeBR();
		this.planos = new ArrayList<PlanoSaude>();
	}

	public String edit() {
		return "edit";
	}
	
	public String view(){
		return "view";
	}
	
	public String create() {
		this.plano = new PlanoSaude();
		return edit();
	}
	
	public String save() {
		this.planoBR.save(this.plano);
		return list();
	}

	public String delete(){
		this.planoBR.delete(this.plano);
		return list();
	}
	
	public String list() {
		return "list";
	}
	
	public PlanoSaude getPlano() {
		return plano;
	}

	public void setPlano(PlanoSaude plano) {
		this.plano = plano;
	}
	
	public List<PlanoSaude> getPlanos() {
		this.planos = planoBR.list();
		return this.planos;
	}

	public void setPlanos(List<PlanoSaude> planos) {
		this.planos = planos;
	}
	
}
