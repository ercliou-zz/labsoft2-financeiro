package br.com.drerp.financeiro.web.planosaude;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DualListModel;

import br.com.drerp.financeiro.business.planosaude.GuiaBR;
import br.com.drerp.financeiro.business.transferencia.FaturaBR;
import br.com.drerp.financeiro.model.transferencia.Fatura;
import br.com.drerp.financeiro.model.transferencia.Guia;

@ManagedBean(name="guiaBean")
@RequestScoped
public class GuiaBean {

	private Guia guia;
	private GuiaBR guiaBR;
	private List<Guia> guias;
	private DualListModel<Fatura> faturas; 
	private FaturaBR faturaBR;
	
	public GuiaBean(){
		this.guia = new Guia();
		this.guiaBR = new GuiaBR();
		this.guias = guiaBR.listGuia();
		this.faturaBR = new FaturaBR();
        this.faturas = new DualListModel<Fatura>(this.faturaBR.list(), new ArrayList<Fatura>()); 
        
        this.listarFaturas();
		
	}
	
	public String gerar(){
		Long now = (new Date()).getTime();
		guiaBR.lancarFaturasDoMes(now - 2592000000l, now);
		return list();
	}

	public String edit() {
		return "edit";
	}
	
	public String view(){
		return "view";
	}
	
	public String list() {
		return "list";
	}
	
	public String create() {
		this.guia = new Guia();
		return edit();
	}
	
	public String save() {
		this.guia.setFaturas(this.faturas.getTarget());
		this.guiaBR.save(this.guia);
		return list();
	}

	public String delete(){
		this.guiaBR.delete(this.guia);
		return list();
	}
	
	public void listarFaturas(){
		List<Fatura> list = this.faturaBR.listarFaturas(this.guia.getPlanoSaude(), this.guia.getDataInicialMS(), this.guia.getDataFinalMS());
		this.faturas = new DualListModel<Fatura>(list, new ArrayList<Fatura>()); 
	}
	
	public Guia getGuia() {
		return guia;
	}
	public void setGuia(Guia guia) {
		this.guia = guia;
	}
	public List<Guia> getGuias() {
		return guias;
	}
	public void setGuias(List<Guia> guias) {
		this.guias = guias;
	}
	public DualListModel<Fatura> getFaturas() {
		return faturas;
	}
	public void setFaturas(DualListModel<Fatura> faturas) {
		this.faturas = faturas;
	}
	
}
