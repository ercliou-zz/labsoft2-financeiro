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

	private final int LISTAR = 0;
	private final int EDITAR = 1;
	
	private PlanoSaude plano;
	private PlanoSaudeBR planoBR;
	private List<PlanoSaude> planos;
	
	private int tabIndex;
	
	public PlanoSaudeBean(){
		tabIndex = LISTAR;
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
	
	public String edit() {
		tabIndex = EDITAR;
		return "crudPlanosSaude";
	}
	
	public String create() {
		tabIndex = LISTAR;
		this.plano.setId(null);
		this.planoBR.save(this.plano);
		return "crudPlanosSaude";
	}
	
	public String update() {
		tabIndex = LISTAR;
		this.planoBR.save(this.plano);
		return "crudPlanosSaude";
	}

	public String delete(){
		this.planoBR.delete(this.plano);
		return "crudPlanosSaude";
	}
	
	public List<PlanoSaude> getPlanos() {
		this.planos = planoBR.list();
		return this.planos;
	}

	public int getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
	}

	public void setPlanos(List<PlanoSaude> planos) {
		this.planos = planos;
	}
	
}
