package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.transferencia.ContaPagar;

public interface ContaPagarDAO extends GenericDAO<ContaPagar>{
	public List<ContaPagar> listarAbertas();
	public List<ContaPagar> listarEfetuadas();
}
