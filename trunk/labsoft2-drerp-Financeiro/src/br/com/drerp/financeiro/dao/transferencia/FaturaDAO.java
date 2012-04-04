package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.transferencia.Fatura;

public interface FaturaDAO extends GenericDAO<Fatura> {
	public List<Fatura> listarFaturas(PlanoSaude plano, Long dataInicial, Long dataFinal);
}
