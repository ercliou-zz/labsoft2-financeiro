package br.com.drerp.financeiro.business.transferencia;

import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;

public class RequisicaoTransferenciaBR {
	
	
	public void save(RequisicaoTransferencia requisicao){
		Long id = requisicao.getId();
		if(id== null || id.equals(0L)){
			//entidadeDAO.save(requisicao);
		}
		else{
			//entidadeDAO.alter(requisicao);
		}
	}
}
