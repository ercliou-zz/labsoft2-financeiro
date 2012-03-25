package br.com.drerp.financeiro.dao.procedimento;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.procedimento.Procedimento;

public interface ProcedimentoDAO extends GenericDAO<Procedimento>{
	
	public Procedimento merge(Procedimento procedimento);
}
