package br.com.drerp.financeiro.business.procedimento;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.tabela.ValorLogDAOImpl;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.tabela.ValorLog;

public class ValorLogBR extends GenericBR<ValorLogDAOImpl, ValorLog>{
	
	
	static final Comparator<ValorLog> DATE_ORDER = 
            new Comparator<ValorLog>() {
				public int compare(ValorLog e1, ValorLog e2) {
					return e2.getDataMS().compareTo(e1.getDataMS());
				}
			};
	
	
	public List<ValorLog> filtrar (LogType tipoLog, Long planoSaudeId, Long procedimentoId, Date dInicial, Date dFinal){
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
		
		return super.dao.listByFiltros(tipoLog, planoSaudeId, procedimentoId, dataInicial, dataFinal);
	}
	
}
