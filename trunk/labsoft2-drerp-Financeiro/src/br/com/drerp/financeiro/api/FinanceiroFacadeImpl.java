package br.com.drerp.financeiro.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.drerp.financeiro.business.orcamento.PedidoOrcamentoBR;
import br.com.drerp.financeiro.business.transferencia.ContaPagarBR;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;
import br.com.drerp.financeiro.model.transferencia.ContaPagar;
import br.com.drerp.financeiro.model.transferencia.Pagador;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;

public class FinanceiroFacadeImpl implements FinanceiroFacade {

	private ContaPagarBR requisicaoBR;
	private PedidoOrcamentoBR pedidoBR;

	public FinanceiroFacadeImpl() {
		this.requisicaoBR = new ContaPagarBR();
		this.pedidoBR = new PedidoOrcamentoBR();
	}

	public Boolean requisitarTransferencia(Beneficiario beneficiario,
			Pagador pagador, BigDecimal valor, Date data) {

		// helderrrrrr acho que isso deveria ta no BR
		try {
			ContaPagar req = new ContaPagar();
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

	public BigDecimal pedirOrcamento(Pagador pagador, List<Procedimento> procedimentos, PlanoSaude planoSaude) {
		
		// tratar excecao!!
		
		return this.pedidoBR.pedirOrcamento(pagador, procedimentos, planoSaude);
	}
	

}
