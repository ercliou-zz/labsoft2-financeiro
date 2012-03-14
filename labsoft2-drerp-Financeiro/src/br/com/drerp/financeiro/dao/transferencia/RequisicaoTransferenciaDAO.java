package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;

public interface RequisicaoTransferenciaDAO extends GenericDAO<RequisicaoTransferencia>{
	public List<RequisicaoTransferencia> listarAbertas();
	public List<RequisicaoTransferencia> listarAceitas();
	public List<RequisicaoTransferencia> listarEfetuadas();
}
