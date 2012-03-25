package br.com.drerp.financeiro.dao.planosaude;

import java.util.Calendar;
import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.planosaude.PlanoSaudeLog;

public interface PlanoSaudeLogDAO extends GenericDAO<PlanoSaudeLog>{
	
	public List<PlanoSaudeLog> listByLogType(LogType tipo);
	
	public List<PlanoSaudeLog> listByPlanoSaudeId(Long id);
	
	public List<PlanoSaudeLog> listByFiltros(LogType tipo, Long id, Calendar dataInicial, Calendar dataFinal);
	
}
