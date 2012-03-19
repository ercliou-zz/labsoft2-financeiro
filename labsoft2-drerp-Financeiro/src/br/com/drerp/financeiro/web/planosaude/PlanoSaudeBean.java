package br.com.drerp.financeiro.web.planosaude;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

@ManagedBean(name="PlanoSaudeBean")
@RequestScoped
public class PlanoSaudeBean {

	private PlanoSaude plano;
	
	public PlanoSaudeBean(){
		this.plano = new PlanoSaude();
	}

	public PlanoSaude getPlano() {
		return plano;
	}

	public void setPlano(PlanoSaude plano) {
		this.plano = plano;
	}

}
