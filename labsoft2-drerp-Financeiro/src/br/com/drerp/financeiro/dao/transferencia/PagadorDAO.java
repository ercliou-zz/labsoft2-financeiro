package br.com.drerp.financeiro.dao.transferencia;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.transferencia.Pagador;

public interface PagadorDAO extends GenericDAO<Pagador> {
	public Pagador getClinica();
}
