package br.com.drerp.financeiro.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.drerp.financeiro.business.orcamento.PedidoOrcamentoBR;
import br.com.drerp.financeiro.business.transferencia.TransferenciaBR;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;
import br.com.drerp.financeiro.model.transferencia.ContaPagar;
import br.com.drerp.financeiro.model.transferencia.Pagador;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class FinanceiroFacadeImpl implements FinanceiroFacade {

	private TransferenciaBR requisicaoBR;
	private PedidoOrcamentoBR pedidoBR;

	public FinanceiroFacadeImpl() {
		this.requisicaoBR = new TransferenciaBR();
		this.pedidoBR = new PedidoOrcamentoBR();
	}

	@Override
	public Boolean requisitarTransferencia(Beneficiario beneficiario,
			Pagador pagador, BigDecimal valor, Date data) {

		// helderrrrrr acho que isso deveria ta no BR
		try {
			Transferencia req = new ContaPagar();
			req.setBeneficiario(beneficiario);
			req.setDataRequisicaoMilis((new Date().getTime()));
			req.setPagador(pagador);
			req.setStatus(StatusTransferencia.PENDENTE);

			this.requisicaoBR.save(req);
		} catch (Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public BigDecimal pedirOrcamento(Pagador pagador, List<Procedimento> procedimentos, PlanoSaude planoSaude) {
		
		// tratar excecao!!
		
		return this.pedidoBR.pedirOrcamento(pagador, procedimentos, planoSaude);
	}
	

}
