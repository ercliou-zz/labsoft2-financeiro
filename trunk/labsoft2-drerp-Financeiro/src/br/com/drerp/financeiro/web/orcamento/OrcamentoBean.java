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
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import br.com.drerp.financeiro.business.orcamento.PedidoOrcamentoBR;
import br.com.drerp.financeiro.business.planosaude.PlanoSaudeBR;
import br.com.drerp.financeiro.business.procedimento.ProcedimentoBR;
import br.com.drerp.financeiro.business.transferencia.PagadorBR;
import br.com.drerp.financeiro.model.orcamento.TipoGrafico;
import br.com.drerp.financeiro.model.orcamento.TipoParametroGrafico;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;

@ManagedBean(name="orcamentoBean")
@RequestScoped
public class OrcamentoBean implements Serializable {
	
	private static final long serialVersionUID = 7458469470665154192L;
	
	private CartesianChartModel categoryModel;
	
	private PieChartModel pieModel;
	
	private TipoGrafico tipoGrafico;
	
	private TipoParametroGrafico eixoY;
	
	private int maxEixoY;
	
	private List<PlanoSaude> planosList;
	
	private List<String> planosSelecionados;
	
	private PlanoSaudeBR planoSaudeBR;
	
	private PedidoOrcamentoBR pedidoOrcamentoBR;
	  
    public OrcamentoBean() {
    	planoSaudeBR = new PlanoSaudeBR();
    	pedidoOrcamentoBR = new PedidoOrcamentoBR();
    	planosList = planoSaudeBR.list();
    	planosSelecionados = new ArrayList<String>();
    	categoryModel = new CartesianChartModel();
    	pieModel = new PieChartModel();
    	maxEixoY= 0;
    	
    	planosSelecionados.add("1");
    	planosSelecionados.add("2");
    	planosSelecionados.add("3");
    }
    
    public String gerarGrafico(){
    	
    	PagadorBR pagadorBR = new PagadorBR();
    	ProcedimentoBR procedimentoBR = new ProcedimentoBR();
    	
    	List<Procedimento> procedimentos = new ArrayList<Procedimento>();
    	procedimentos.add(procedimentoBR.getById(1l));
    	procedimentos.add(procedimentoBR.getById(2l));
    	procedimentos.add(procedimentoBR.getById(3l));
    	procedimentos.add(procedimentoBR.getById(4l));
    	
    	
    	
    	pedidoOrcamentoBR.pedirOrcamento(pagadorBR.getById(1l), procedimentos, planoSaudeBR.getById(1l));
    	
    	switch (tipoGrafico) {
		case BARRA:
			this.gerarBarraOuLinha();
			break;
			
		case LINHA:
			this.gerarBarraOuLinha();
			break;
			
		case PIZZA:
			this.gerarPizza();
			break;
			
		default:
			break;
		}
    	
    	return null;
    }
    
    
    private void gerarBarraOuLinha(){
    	categoryModel = new CartesianChartModel();
    	Calendar data = new GregorianCalendar();
    	Calendar dataFim;
    	int mes;
    	int ano;
    	int novoDadoInt = 0;
    	ChartSeries planoSeries;
		BigDecimal novoDado = new BigDecimal(0);
		PlanoSaude plano;
		
    	for (String psId : planosSelecionados) {
    		
    		plano = planoSaudeBR.getById(Long.parseLong(psId));
    		
    		if(tipoGrafico.equals(TipoGrafico.BARRA)){
    			planoSeries = new ChartSeries();
    		} else {
    			planoSeries = new LineChartSeries();
    		}
    		
    		planoSeries.setLabel(plano.getNome());
    		
    		mes = data.get(Calendar.MONTH) - 11;
    		ano = data.get(Calendar.YEAR);
    		if(mes<0){
    			mes +=12;
    			ano --;
    		}
    		
    		for (int i = 0; i < 12; i++) {
    			if(mes+1==12){
    				dataFim = new GregorianCalendar(ano+1, 0, 1);
    			} else{
    				dataFim = new GregorianCalendar(ano, mes+1, 1);
    			}
    			switch (eixoY) {
				case N_PEDIDOS:
					novoDado = new BigDecimal(pedidoOrcamentoBR.getQtdOrcamentoByPeriodo(plano, new GregorianCalendar(ano, mes, 1), dataFim));
					planoSeries.set((mes+1)+"-"+ano, novoDado);
					break;
				case VAL_PEDIDOS:
					novoDado = pedidoOrcamentoBR.getValorOrcamentoByPeriodo(plano, new GregorianCalendar(ano, mes, 1), dataFim);
					planoSeries.set((mes+1)+"-"+ano, novoDado);
					break;
				default:
					break;
				}
    			
    			mes++;
    			if(mes==12){
    				ano++;
    				mes=0;
    			}
    			
    			novoDadoInt = novoDado.intValue(); 
    			if(novoDadoInt > maxEixoY){
    				maxEixoY = (novoDadoInt/10)*10+10;
    			}
    			
			}
    		categoryModel.addSeries(planoSeries);
		}
    }
    
    private void gerarPizza(){
    	
    	pieModel = new PieChartModel();
    	Calendar data = new GregorianCalendar();
    	int mes = data.get(Calendar.MONTH);
    	int ano = data.get(Calendar.YEAR);
    	
    	if(mes+1==12){
    		mes = 0;
    		ano--;
    	} else {
    		mes++;
    	}
    	
    	for (String psId : planosSelecionados) {
    		PlanoSaude plano = planoSaudeBR.getById(Long.parseLong(psId));
    		
    		switch (eixoY) {
			case N_PEDIDOS:
				pieModel.set(plano.getNome(), pedidoOrcamentoBR.getQtdOrcamentoByPeriodo(plano, new GregorianCalendar(ano-1, mes, 1), new GregorianCalendar(ano, mes, 1)));
				break;
			case VAL_PEDIDOS:
				pieModel.set(plano.getNome(), pedidoOrcamentoBR.getValorOrcamentoByPeriodo(plano, new GregorianCalendar(ano-1, mes, 1), new GregorianCalendar(ano, mes, 1)));
				break;
			default:
				break;
			}
    	}
    }
    
  
    public CartesianChartModel getCategoryModel() {  
        return categoryModel;  
    }
  
    public PieChartModel getPieModel() {
		return pieModel;
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

	public int getMaxEixoY() {
		return maxEixoY;
	}

	public void setMaxEixoY(int maxEixoY) {
		this.maxEixoY = maxEixoY;
	}
	
	
	
    
}
