package br.com.drerp.financeiro.web.transferencia;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.CartesianChartModel;

import br.com.drerp.financeiro.util.TipoGrafico;
import br.com.drerp.financeiro.util.TipoParametroGrafico;

@ManagedBean(name="transferenciaOutBean")
@RequestScoped
public class TransferenciaOutBean implements Serializable{
	
	private static final long serialVersionUID = -3229300148690484732L;

	private CartesianChartModel categoryModel;
	
	private TipoGrafico tipoGrafico;
	
	private TipoParametroGrafico eixoY;
	
	private int maxEixoY;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	public String gerarGrafico(){
    	
    	switch (tipoGrafico) {
		case BARRA:
//			this.gerarBarraOuLinha();
			break;
			
		case LINHA:
//			this.gerarBarraOuLinha();
			break;
			
		case PIZZA:
//			this.gerarPizza();
			break;
			
		default:
			break;
		}
    	
    	return null;
    }
	
	

	public CartesianChartModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CartesianChartModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public TipoGrafico getTipoGrafico() {
		return tipoGrafico;
	}

	public void setTipoGrafico(TipoGrafico tipoGrafico) {
		this.tipoGrafico = tipoGrafico;
	}

	public TipoParametroGrafico getEixoY() {
		return eixoY;
	}

	public void setEixoY(TipoParametroGrafico eixoY) {
		this.eixoY = eixoY;
	}

	public int getMaxEixoY() {
		return maxEixoY;
	}

	public void setMaxEixoY(int maxEixoY) {
		this.maxEixoY = maxEixoY;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	
	
	
}
