package br.com.drerp.financeiro.business.transferencia;

import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.transferencia.FaturaDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.transferencia.Fatura;

public class FaturaBR extends GenericBR<FaturaDAOImpl, Fatura> {

	public List<Fatura> listarFaturas(PlanoSaude plano, Long dataInicial,
			Long dataFinal){
		return super.dao.listarFaturas(plano, dataInicial, dataFinal);
	}
}
