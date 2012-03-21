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

	public PlanoSaude getPlano() {
		return plano;
	}

	public void setPlano(PlanoSaude plano) {
		this.plano = plano;
	}
	
	public String save() {
		this.planoBR.save(this.plano);
		return "crudPlanosSaude&tabs-2";
	}
	
	public String edit(){
		this.planoBR.save(this.plano);
		return "crudPlanosSaude#tabs-3";
	}

	public String delete(){
		this.planoBR.delete(this.plano);
		return "crudPlanosSaude";
	}
	
	public List<PlanoSaude> getPlanos() {
		this.planos = planoBR.list();
		return this.planos;
	}
}
