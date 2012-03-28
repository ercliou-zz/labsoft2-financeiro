package br.com.drerp.financeiro.dao.tabela;

import java.util.Calendar;
import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.LogType;
import br.com.drerp.financeiro.model.tabela.ValorLog;

public interface ValorLogDAO extends GenericDAO<ValorLog>{
	
	public List<ValorLog> listByLogType(LogType tipo);
	
	public List<ValorLog> listByPlanoSaudeId(Long id);
	
	public List<ValorLog> listByProcedimentoId(Long id);
	
	public List<ValorLog> listByFiltros(LogType tipo, Long planoSaudeId, Long procedimentoId, Calendar dataInicial, Calendar dataFinal);
	
}
