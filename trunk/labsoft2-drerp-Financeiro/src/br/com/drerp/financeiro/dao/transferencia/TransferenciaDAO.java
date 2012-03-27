package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public interface TransferenciaDAO extends GenericDAO<Transferencia>{
	public List<Transferencia> listarAbertas();
	public List<Transferencia> listarEfetuadas();
}
