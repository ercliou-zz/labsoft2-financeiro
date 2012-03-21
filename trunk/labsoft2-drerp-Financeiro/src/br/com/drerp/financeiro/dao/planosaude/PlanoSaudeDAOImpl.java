package br.com.drerp.financeiro.dao.planosaude;

import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;

public class PlanoSaudeDAOImpl extends GenericDAOImpl<PlanoSaude> implements PlanoSaudeDAO{

	@SuppressWarnings("unchecked")
	public List<PlanoSaude> listarPlanosSaude() {
		return session.createCriteria(RequisicaoTransferencia.class).list();
	}

}
