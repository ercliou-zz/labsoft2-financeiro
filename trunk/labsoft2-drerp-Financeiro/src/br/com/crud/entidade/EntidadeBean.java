package br.com.crud.entidade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.crud.model.Entidade;

@ManagedBean(name="EntidadeBean")
@RequestScoped
public class EntidadeBean {
	
	private Entidade entidade = new Entidade();
	
	
	
	public String novo(){
		entidade = new Entidade();
		entidade.setPropriedade("nova propriedade");
		return "entidadeList";
	}

	public String salvar(){
		//FacesContext context = FacesContext.getCurrentInstance();
		EntidadeBR entidadeBR = new EntidadeBR();
		entidadeBR.save(entidade);
		return "usuarioList";
	}

	public Entidade getEntidade() {
		return entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}
	
	
}
