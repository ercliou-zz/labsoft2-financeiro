package br.com.drerp.financeiro.api;

import java.math.BigDecimal;
import java.util.Date;

import br.com.drerp.financeiro.business.transferencia.RequisicaoTransferenciaBR;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;
import br.com.drerp.financeiro.model.transferencia.Pagador;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.StatusRequisicaoTransferencia;

public class FinanceiroFacadeImpl implements FinanceiroFacade {

	private RequisicaoTransferenciaBR requisicaoBR;

	public FinanceiroFacadeImpl() {
		this.requisicaoBR = new RequisicaoTransferenciaBR();
	}

	@Override
	public Boolean requisitarTransferencia(Beneficiario beneficiario,
			Pagador pagador, BigDecimal valor, Date data) {

		try {
			RequisicaoTransferencia req = new RequisicaoTransferencia();
			req.setBeneficiario(beneficiario);
			req.setDataRequisicaoMilis((new Date().getTime()));
			req.setPagador(pagador);
			req.setStatus(StatusRequisicaoTransferencia.ABERTA);

			this.requisicaoBR.save(req);
		} catch (Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
