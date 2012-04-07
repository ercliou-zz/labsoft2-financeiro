package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.transferencia.Salario;

public interface SalarioDAO extends GenericDAO<Salario> {
	
	public List<Salario> listarPendentes();
	public List<Salario> listarEfetuadas();
}
