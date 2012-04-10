package br.com.drerp.financeiro.web.orcamento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.util.TipoGrafico;
import br.com.drerp.financeiro.util.TipoParametroGrafico;
import br.com.drerp.financeiro.util.TipoStepGrafico;

@ManagedBean(name="orcamentoBean")
@RequestScoped
public class OrcamentoBean implements Serializable {
	
	private static final long serialVersionUID = 7458469470665154192L;
	
	private CartesianChartModel categoryModel;
	
	private PieChartModel pieModel;
	
	private TipoGrafico tipoGrafico;
	
	private TipoParametroGrafico eixoY;
	
	private int maxEixoY;
	
	private GregorianCalendar dataInicial;
	
	private GregorianCalendar dataFinal;
	
	private TipoStepGrafico step;
	
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
    }
    
    public String gerarGrafico(){
    	
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
    	
    	int calendarField = getCalendarField();
    	List<GregorianCalendar> listaDatas = getListaDatas();
    	categoryModel = new CartesianChartModel();
    	int maxDadoTemp = 0;
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
    		
    		for (int i = 1; i < listaDatas.size(); i++) {
    			switch (eixoY) {
				case N_PEDIDOS:
					novoDado = new BigDecimal(pedidoOrcamentoBR.getQtdOrcamentoByPeriodo(plano, listaDatas.get(i-1), listaDatas.get(i)));
					break;
				case VAL_PEDIDOS:
					novoDado = pedidoOrcamentoBR.getValorOrcamentoByPeriodo(plano, listaDatas.get(i-1), listaDatas.get(i));
					
					break;
				default:
					break;
				}
    			planoSeries.set(listaDatas.get(i-1).get(calendarField)+"-"+listaDatas.get(i-1).get(proxGranularidadeGrossa(calendarField)), novoDado);
    			
    			maxDadoTemp = novoDado.intValue(); 
    			if(maxDadoTemp > maxEixoY){
    				maxEixoY = (maxDadoTemp/10)*10+10;
    			}
			}
    		categoryModel.addSeries(planoSeries);
		}
    }
    
    private void gerarPizza(){
    	
    	pieModel = new PieChartModel();
    	
    	for (String psId : planosSelecionados) {
    		PlanoSaude plano = planoSaudeBR.getById(Long.parseLong(psId));
    		GregorianCalendar dataFinalLimite = new GregorianCalendar();
    		dataFinalLimite.setTime(dataFinal.getTime());
    		dataFinalLimite.add(Calendar.DATE, 1); //granularidade nao faz efeito em pizzas
    		
    		switch (eixoY) {
			case N_PEDIDOS:
				pieModel.set(plano.getNome(), pedidoOrcamentoBR.getQtdOrcamentoByPeriodo(plano, dataInicial, dataFinalLimite));
				break;
			case VAL_PEDIDOS:
				pieModel.set(plano.getNome(), pedidoOrcamentoBR.getValorOrcamentoByPeriodo(plano, dataInicial, dataFinalLimite));
				break;
			default:
				break;
			}
    	}
    }
    
    private int getCalendarField(){
    	switch (step) {
		case DIA:
			return Calendar.DATE;
		case MES:
			return Calendar.MONTH;
		case ANO:
			return Calendar.YEAR;
		default:
			return -1;
		}
    }
    
    private List<GregorianCalendar> getListaDatas(){
    	
    	List<GregorianCalendar> lista = new ArrayList<GregorianCalendar>();
    	int calendarField = getCalendarField();
    	
    	GregorianCalendar primeiraData = new GregorianCalendar();
    	primeiraData.setTime(dataInicial.getTime());
    	primeiraData.set(proxGranularidadeFina(calendarField), dataInicial.getMinimum(proxGranularidadeFina(calendarField)));
    	
    	GregorianCalendar ultimaData = new GregorianCalendar();
    	ultimaData.setTime(dataFinal.getTime());
    	ultimaData.set(proxGranularidadeFina(calendarField), dataFinal.getMinimum(proxGranularidadeFina(calendarField)));
    	ultimaData.add(calendarField, 1);
    	
    	for (GregorianCalendar data = primeiraData; primeiraData.before(dataFinal); data.add(calendarField, 1)){
    		GregorianCalendar temp = new GregorianCalendar();
    		temp.setTime(data.getTime());
    		lista.add(temp);
    	}
    	lista.add(ultimaData);
    	return lista;
    }
    
    private int proxGranularidadeFina(int gran){
    	switch (gran) {
		case Calendar.DATE:
			return Calendar.HOUR;
		case Calendar.MONTH:
			return Calendar.DATE;
		case Calendar.YEAR:
			return Calendar.MONTH;
		default:
			return -1;
		}
    }
    
    private int proxGranularidadeGrossa(int gran){
    	switch (gran) {
		case Calendar.DATE:
			return Calendar.MONTH;
		case Calendar.MONTH:
			return Calendar.YEAR;
		case Calendar.YEAR:
			return Calendar.ERA;
		default:
			return -1;
		}
    }
  
    public Date getDataInicial() {
    	if(this.dataInicial == null)
    		return null;
		return dataInicial.getTime();
	}

	public void setDataInicial(Date dataInicio) {
		if(dataInicio == null){
			this.dataInicial = null;
		} else {
			this.dataInicial = new GregorianCalendar();
			this.dataInicial.setTimeInMillis(dataInicio.getTime());
		}
	}

	public Date getDataFinal() {
		if(this.dataFinal == null)
			return null;
		return dataFinal.getTime();
	}

	public void setDataFinal(Date dataFinal) {
		if(dataFinal == null){
			this.dataFinal = null;
		} else {
			this.dataFinal = new GregorianCalendar();
			this.dataFinal.setTimeInMillis(dataFinal.getTime());
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

	public TipoStepGrafico getStep() {
		return step;
	}

	public void setStep(TipoStepGrafico step) {
		this.step = step;
	}
	
    
}
