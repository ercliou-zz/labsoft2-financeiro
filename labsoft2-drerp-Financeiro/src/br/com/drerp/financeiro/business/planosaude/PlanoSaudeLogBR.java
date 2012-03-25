package br.com.drerp.financeiro.business.planosaude;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.planosaude.PlanoSaudeLogDAOImpl;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.planosaude.PlanoSaudeLog;

public class PlanoSaudeLogBR extends GenericBR<PlanoSaudeLogDAOImpl, PlanoSaudeLog>{
	
	
	static final Comparator<PlanoSaudeLog> DATE_ORDER = 
            new Comparator<PlanoSaudeLog>() {
				public int compare(PlanoSaudeLog e1, PlanoSaudeLog e2) {
					return e2.getDataMS().compareTo(e1.getDataMS());
				}
			};
	
	
	public List<PlanoSaudeLog> filtrar (LogType tipoLog, Long planoId, Date dInicial, Date dFinal){
		Calendar dataInicial = null;
		Calendar dataFinal = null;
		
		if(dFinal!=null){
			dataFinal = new GregorianCalendar();
			dataFinal.setTimeInMillis(dFinal.getTime());
			dataFinal = new GregorianCalendar(dataFinal.get(Calendar.YEAR), dataFinal.get(Calendar.MONTH), dataFinal.get(Calendar.DATE)+1);
		}
		if(dInicial!=null){
			dataInicial = new GregorianCalendar();
			dataInicial.setTimeInMillis(dInicial.getTime());
		}
		
		return super.dao.listByFiltros(tipoLog, planoId, dataInicial, dataFinal);
	}
	
}
