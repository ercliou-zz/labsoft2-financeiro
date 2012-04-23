package br.com.drerp.financeiro.business.transferencia;

import java.util.Date;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.transferencia.ContaReceberDAOImpl;
import br.com.drerp.financeiro.model.transferencia.ContaReceber;
import br.com.drerp.financeiro.model.transferencia.Fatura;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;

public class ContaReceberBR extends
		GenericBR<ContaReceberDAOImpl, ContaReceber> {

	private FaturaBR faturaBR;

	public ContaReceberBR() {
		super();
		faturaBR = new FaturaBR();
	}

	public ContaReceber registrarErro(ContaReceber conta) {
		conta.setDataRealizacaoMilis((new Date()).getTime());
		conta.setStatus(StatusTransferencia.ERRO);
		save(conta);
		return conta;
	}

	public ContaReceber lancarPagamento(ContaReceber conta) {
		conta.setDataRealizacaoMilis((new Date()).getTime());
		conta.setStatus(StatusTransferencia.EFETUADA);
		save(conta);

		if (conta.getFaturas() != null) {
			for (Fatura fatura : conta.getFaturas()) {
				fatura.setPaga(true);
				this.faturaBR.save(fatura);
			}
		}
		return conta;
	}
}
