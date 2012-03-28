package br.com.drerp.financeiro.dao.procedimento;

import java.util.Calendar;
import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.procedimento.ProcedimentoLog;

public interface ProcedimentoLogDAO extends GenericDAO<ProcedimentoLog>{
	
	public List<ProcedimentoLog> listByLogType(LogType tipo);
	
	public List<ProcedimentoLog> listByProcedimentoId(Long id);
	
	public List<ProcedimentoLog> listByFiltros(LogType tipo, Long id, Calendar dataInicial, Calendar dataFinal);
	
}
