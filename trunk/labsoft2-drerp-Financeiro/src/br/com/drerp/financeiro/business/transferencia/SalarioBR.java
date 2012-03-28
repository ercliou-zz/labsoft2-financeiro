package br.com.drerp.financeiro.business.transferencia;

import java.util.Date;
import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.transferencia.SalarioDAOImpl;
import br.com.drerp.financeiro.model.transferencia.Salario;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class SalarioBR extends GenericBR<SalarioDAOImpl, Salario> {
	
	public List<Salario> listarPendentes(){
		return super.dao.listarPendentes();
	}
	
	public List<Salario> listarEfetuadas(){
		return super.dao.listarEfetuadas();
	}
	
	public Transferencia realizarTransferencia (Salario conta){
		conta.setDataRealizacaoMilis((new Date()).getTime());
		// mais coisassssssss
		conta.setStatus(StatusTransferencia.EFETUADA);
		save(conta);
		return conta;
	}
	
	public Transferencia registrarErro (Salario conta){
		conta.setDataRealizacaoMilis((new Date()).getTime());
		conta.setStatus(StatusTransferencia.ERRO);
		save(conta);
		return conta;
	}
}
