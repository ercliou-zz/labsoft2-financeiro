package br.com.drerp.financeiro.web.planosaude;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.planosaude.GuiaBR;
import br.com.drerp.financeiro.model.planosaude.Guia;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

@ManagedBean(name="GuiaBean")
@RequestScoped
public class GuiaBean {

	private Guia guia;
	private GuiaBR guiaBR;
	private List<Guia> guias;
	
	public GuiaBean(){
		this.guia = new Guia();
		this.guiaBR = new GuiaBR();
		this.guias = new ArrayList<Guia>();
	}
	

	public String edit() {
		return "edit";
	}
	
	public String view(){
		return "view";
	}
	
	public String create() {
		this.guia = new Guia();
		return edit();
	}
	
	public String save() {
		this.guiaBR.save(this.guia);
		return list();
	}

	public String delete(){
		this.guiaBR.delete(this.guia);
		return list();
	}
	
	public String list() {
		return "list";
	}
	
	public Guia getGuia() {
		return guia;
	}
	public void setGuia(Guia guia) {
		this.guia = guia;
	}
	public GuiaBR getGuiaBR() {
		return guiaBR;
	}
	public void setGuiaBR(GuiaBR guiaBR) {
		this.guiaBR = guiaBR;
	}
	public List<Guia> getGuias() {
		return guias;
	}
	public void setGuias(List<Guia> guias) {
		this.guias = guias;
	}
	
}
