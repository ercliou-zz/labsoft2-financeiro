package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.transferencia.ContaPagar;
import br.com.drerp.financeiro.model.transferencia.Departamento;

public interface ContaPagarDAO extends GenericDAO<ContaPagar>{
	public List<ContaPagar> listarAbertas();
	public List<ContaPagar> listarEfetuadas();
	public List<ContaPagar> getByDpto(Departamento dpto, Long inicioMillis, Long fimMillis);
}
