package br.com.drerp.financeiro.web.orcamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

import br.com.drerp.financeiro.business.orcamento.PedidoOrcamentoBR;
import br.com.drerp.financeiro.business.planosaude.PlanoSaudeBR;
import br.com.drerp.financeiro.model.orcamento.TipoGrafico;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

@ManagedBean(name="orcamentoBean")
@RequestScoped
public class OrcamentoBean implements Serializable {
	
	private static final long serialVersionUID = 7458469470665154192L;
	
	private CartesianChartModel categoryModel;
	
	private TipoGrafico tipoGrafico;
	
	private String eixoX;
	
	private String eixoY;
	
	private List<PlanoSaude> planosList;
	
	private List<String> planosSelecionados;
	
	private PlanoSaudeBR planoSaudeBR;
	
	private PedidoOrcamentoBR pedidoOrcamentoBR;
	  
    public OrcamentoBean() {
    	planoSaudeBR = new PlanoSaudeBR();
    	planosList = planoSaudeBR.list();
    	planosSelecionados = new ArrayList<String>();
        createCategoryModel();  
    }
    
    public String gerarGrafico(){
    	
    	switch (tipoGrafico) {
		case BARRA:
			
			this.gerarBarra();
			
			break;
			
		case LINHA:
			
			break;
			
		case PIZZA:
			
			break;
			
		default:
			break;
		}
    	
    	return null;
    }
    
    
    private void gerarBarra(){
    	categoryModel = new CartesianChartModel();
    	
    	for (String psId : planosSelecionados) {
    		
    		PlanoSaude plano = planoSaudeBR.getById(Long.parseLong(psId));
			
    		ChartSeries planoSeries = new ChartSeries();
    		planoSeries.setLabel(plano.getNome());
    		
//    		Calendar data = new GregorianCalendar();
//    		int mes = data.get(Calendar.MONTH);
//    		int ano = data.get(Calendar.YEAR);
//    		
//    		for (int i = 0; i < 12; i++) {
//    			planoSeries.set(mes+"-"+ano, pedidoOrcamentoBR.qtdOrcamento(plano, new GregorianCalendar(ano, mes, 1)));
//    			mes--;
//    			if(mes<0){
//    				mes=11;
//    				ano--;
//    			}
//			}
    		
    		planoSeries.set("Jan", 5);
    		planoSeries.set("Fev", 10);
    		planoSeries.set("Mar", 15);
//    		plano.set("Abr", 1);
//    		plano.set("Mai", 1);
//    		plano.set("Jun", 1);
//    		plano.set("Jul", 1);
//    		plano.set("Ago", 1);
//    		plano.set("Sep", 1);
//    		plano.set("Out", 1);
//    		plano.set("Nov", 1);
//    		plano.set("Dez", 1);
    		
    		categoryModel.addSeries(planoSeries);
    		
		}
    	
    }
    
    private BigDecimal preencherDadosY(){
    	return null;
    }
    
  
    public CartesianChartModel getCategoryModel() {  
        return categoryModel;  
    }  
  
    private void createCategoryModel() {  
        categoryModel = new CartesianChartModel();  
  
        ChartSeries boys = new ChartSeries();  
        boys.setLabel("Boys");  
  
        boys.set("2004", 120);  
        boys.set("2005", 100);  
        boys.set("2006", 44);  
        boys.set("2007", 150);  
        boys.set("2008", 25);  
  
        ChartSeries girls = new ChartSeries();  
        girls.setLabel("Girls");  
  
        girls.set("2004", 52);  
        girls.set("2005", 60);  
        girls.set("2006", 110);  
        girls.set("2007", 135);  
        girls.set("2008", 120);  
  
        categoryModel.addSeries(boys);  
        categoryModel.addSeries(girls);  
    }

	public TipoGrafico getTipoGrafico() {
		return tipoGrafico;
	}

	public void setTipoGrafico(TipoGrafico tipoGrafico) {
		this.tipoGrafico = tipoGrafico;
	}

	public String getEixoX() {
		return eixoX;
	}

	public void setEixoX(String eixoX) {
		this.eixoX = eixoX;
	}

	public String getEixoY() {
		return eixoY;
	}

	public void setEixoY(String eixoY) {
		this.eixoY = eixoY;
	}
	
	public List<PlanoSaude> getPlanosList() {
		return planosList;
	}

	public void setPlanosList(List<PlanoSaude> planosList) {
		this.planosList = planosList;
	}

	public List<String> getPlanosSelecionados() {
		return planosSelecionados;
	}

	public void setPlanosSelecionados(List<String> planosSelecionados) {
		this.planosSelecionados = planosSelecionados;
	}
    
}
