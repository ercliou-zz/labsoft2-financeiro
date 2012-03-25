package br.com.drerp.financeiro.dao.procedimento;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.procedimento.Procedimento;

public class ProcedimentoDAOImpl extends GenericDAOImpl<Procedimento> implements ProcedimentoDAO{
	
	public Procedimento merge(Procedimento procedimento){
		return (Procedimento) session.merge(procedimento);
	}
}
