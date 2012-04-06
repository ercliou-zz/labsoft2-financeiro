package br.com.drerp.financeiro.web.transferencia;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DualListModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import br.com.drerp.financeiro.business.planosaude.PlanoSaudeBR;
import br.com.drerp.financeiro.business.transferencia.ContaPagarBR;
import br.com.drerp.financeiro.business.transferencia.SalarioBR;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.transferencia.Departamento;
import br.com.drerp.financeiro.util.TipoGrafico;
import br.com.drerp.financeiro.util.TipoParametroGrafico;
import br.com.drerp.financeiro.util.TipoSentidoFluxoGrafico;
import br.com.drerp.financeiro.util.TipoStepGrafico;

@ManagedBean(name="fluxoCaixaBean")
@RequestScoped
public class FluxoCaixaBean implements Serializable{
	
	private static final long serialVersionUID = -3229300148690484732L;

	private CartesianChartModel categoryModel;
	
	private PieChartModel pieModel;
	
	private TipoGrafico tipoGrafico;
	
	private TipoParametroGrafico eixoY;
	
	private int maxEixoY;
	
	private GregorianCalendar dataInicial;
	
	private GregorianCalendar dataFinal;
	
	private TipoStepGrafico step;
	
	private List<Departamento> dptosSelecionados;
	
	private DualListModel<Departamento> dptosDual;
	
	private List<PlanoSaude> planosList;
	
	private List<PlanoSaude> planosSel;
	
	private List<String> planosSelecionados;
	
	private DualListModel<PlanoSaude> planosDual;
	
	private TipoSentidoFluxoGrafico sentidoSelecionado; 
	
	private PlanoSaudeBR planoSaudeBR;
	
	private ContaPagarBR contaPagarBR;
	
	private SalarioBR salarioBR;
	
	public FluxoCaixaBean() {
		planoSaudeBR = new PlanoSaudeBR();
		contaPagarBR = new ContaPagarBR();
		salarioBR = new SalarioBR();
		
		planosList = planoSaudeBR.list();
		planosSel = new ArrayList<PlanoSaude>();
		planosDual = new DualListModel<PlanoSaude>(planosList, planosSel);
		
		dptosSelecionados = new ArrayList<Departamento>();
		dptosDual = new DualListModel<Departamento>(Arrays.asList(Departamento.values()), dptosSelecionados);
		
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
		
		switch (sentidoSelecionado) {
		case OUT:
			for (Departamento dpto : dptosDual.getTarget()) {
	    		if(tipoGrafico.equals(TipoGrafico.BARRA)){
	    			planoSeries = new ChartSeries();
	    		} else {
	    			planoSeries = new LineChartSeries();
	    		}
	    		planoSeries.setLabel(dpto.toString());
	    		
	    		for (int i = 1; i < listaDatas.size(); i++) {
					novoDado = contaPagarBR.getGastoByDpto(dpto, listaDatas.get(i-1), listaDatas.get(i));
					novoDado = novoDado.add(salarioBR.getSalarioByDpto(dpto, listaDatas.get(i-1), listaDatas.get(i)));
	    			planoSeries.set(listaDatas.get(i-1).get(calendarField)+"-"+listaDatas.get(i-1).get(proxGranularidadeGrossa(calendarField)), novoDado);
	    			
	    			maxDadoTemp = novoDado.intValue(); 
	    			if(maxDadoTemp > maxEixoY){
	    				maxEixoY = (maxDadoTemp/10)*10+10;
	    			}
				}
	    		categoryModel.addSeries(planoSeries);
			}
			break;
		case IN:
//			PlanoSaude plano;
//			for (String psId : planosSelecionados) {
//				plano = planoSaudeBR.getById(Long.parseLong(psId));
//	    		if(tipoGrafico.equals(TipoGrafico.BARRA)){
//	    			planoSeries = new ChartSeries();
//	    		} else {
//	    			planoSeries = new LineChartSeries();
//	    		}
//	    		planoSeries.setLabel(plano.getNome());
//	    		
//	    		for (int i = 1; i < listaDatas.size(); i++) {
//					novoDado = contaPagarBR.getGastoByDpto(dpto, listaDatas.get(i-1), listaDatas.get(i));
//	    			planoSeries.set(listaDatas.get(i-1).get(calendarField)+"-"+listaDatas.get(i-1).get(proxGranularidadeGrossa(calendarField)), novoDado);
//	    			
//	    			maxDadoTemp = novoDado.intValue(); 
//	    			if(maxDadoTemp > maxEixoY){
//	    				maxEixoY = (maxDadoTemp/10)*10+10;
//	    			}
//				}
//	    		categoryModel.addSeries(planoSeries);
//			}
			break;
		case INOUT:
//			grupos = new ArrayList<String>();
//			grupos.add("in");
//			grupos.add("out");
			break;
		default:
			break;
		}
    }

    private void gerarPizza(){
    	
    	pieModel = new PieChartModel();
    	GregorianCalendar dataFinalLimite = new GregorianCalendar();
		dataFinalLimite.setTime(dataFinal.getTime());
		dataFinalLimite.add(Calendar.DATE, 1);
    	
    	switch (sentidoSelecionado) {
		case OUT:
    		for (Departamento dpto : dptosDual.getTarget()) {
    			pieModel.set(dpto.toString(), 
    					contaPagarBR.getGastoByDpto(dpto, dataInicial, dataFinalLimite).add(salarioBR.getSalarioByDpto(dpto, dataInicial, dataFinalLimite)));
			}
			break;
		case IN:
//			PlanoSaude plano;
//			for (String psId : planosSelecionados) {
//				plano = planoSaudeBR.getById(Long.parseLong(psId));
//	    		if(tipoGrafico.equals(TipoGrafico.BARRA)){
//	    			planoSeries = new ChartSeries();
//	    		} else {
//	    			planoSeries = new LineChartSeries();
//	    		}
//	    		planoSeries.setLabel(plano.getNome());
//	    		
//	    		for (int i = 1; i < listaDatas.size(); i++) {
//					novoDado = contaPagarBR.getGastoByDpto(dpto, listaDatas.get(i-1), listaDatas.get(i));
//	    			planoSeries.set(listaDatas.get(i-1).get(calendarField)+"-"+listaDatas.get(i-1).get(proxGranularidadeGrossa(calendarField)), novoDado);
//	    			
//	    			maxDadoTemp = novoDado.intValue(); 
//	    			if(maxDadoTemp > maxEixoY){
//	    				maxEixoY = (maxDadoTemp/10)*10+10;
//	    			}
//				}
//	    		categoryModel.addSeries(planoSeries);
//			}
			break;
		case INOUT:
//			grupos = new ArrayList<String>();
//			grupos.add("in");
//			grupos.add("out");
			break;
		default:
			break;
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
    
//    private List<PlanoSaude> getPlanos(List<String> ids){
//    	List<PlanoSaude> dptos = new ArrayList<PlanoSaude>();
//    	for (String id : ids) {
//			dptos.add(planoSaudeBR.getById(Long.parseLong(id)));
//		}
//    	return dptos;
//    }
	

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

	public TipoStepGrafico getStep() {
		return step;
	}

	public void setStep(TipoStepGrafico step) {
		this.step = step;
	}
	
	public List<Departamento> getDptosSelecionados() {
		return dptosSelecionados;
	}

	public void setDptosSelecionados(List<Departamento> dptosSelecionados) {
		this.dptosSelecionados = dptosSelecionados;
	}

	public TipoSentidoFluxoGrafico getSentidoSelecionado() {
		return sentidoSelecionado;
	}

	public void setSentidoSelecionado(TipoSentidoFluxoGrafico sentidoSelecionado) {
		this.sentidoSelecionado = sentidoSelecionado;
	}

	public List<String> getPlanosSelecionados() {
		return planosSelecionados;
	}

	public void setPlanosSelecionados(List<String> planosSelecionados) {
		this.planosSelecionados = planosSelecionados;
	}

	public List<PlanoSaude> getPlanosList() {
		return planosList;
	}

	public void setPlanosList(List<PlanoSaude> planosList) {
		this.planosList = planosList;
	}

	public DualListModel<PlanoSaude> getPlanosDual() {
		return planosDual;
	}

	public void setPlanosDual(DualListModel<PlanoSaude> planosDual) {
		this.planosDual = planosDual;
	}

	public DualListModel<Departamento> getDptosDual() {
		return dptosDual;
	}

	public void setDptosDual(DualListModel<Departamento> dptosDual) {
		this.dptosDual = dptosDual;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}
	
	
}
