package br.com.drerp.financeiro.business.transferencia;

import java.util.ArrayList;
import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.transferencia.TransferenciaDAOImpl;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class TransferenciaBR extends GenericBR<TransferenciaDAOImpl, Transferencia> {

	public List<Transferencia> searchTransferencia(){
		List<Transferencia> list = new ArrayList<Transferencia>();
		return list;
	}
}
