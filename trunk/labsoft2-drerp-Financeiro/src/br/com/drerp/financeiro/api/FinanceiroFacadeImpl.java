package br.com.drerp.financeiro.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.drerp.financeiro.business.orcamento.PedidoOrcamentoBR;
import br.com.drerp.financeiro.business.transferencia.RequisicaoTransferenciaBR;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.tabela.ItemTabela;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;
import br.com.drerp.financeiro.model.transferencia.Pagador;
import br.com.drerp.financeiro.model.transferencia.RequisicaoTransferencia;
import br.com.drerp.financeiro.model.transferencia.StatusRequisicaoTransferencia;

public class FinanceiroFacadeImpl implements FinanceiroFacade {

	private RequisicaoTransferenciaBR requisicaoBR;
	private PedidoOrcamentoBR pedidoBR;

	public FinanceiroFacadeImpl() {
		this.requisicaoBR = new RequisicaoTransferenciaBR();
		this.pedidoBR = new PedidoOrcamentoBR();
	}

	@Override
	public Boolean requisitarTransferencia(Beneficiario beneficiario,
			Pagador pagador, BigDecimal valor, Date data) {

		// helderrrrrr acho que isso deveria ta no BR
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

	@Override
	public BigDecimal pedirOrcamento(Pagador pagador, List<ItemTabela> procedimentos, PlanoSaude planoSaude) {
		
		// tratar excecao!!
		
		return this.pedidoBR.pedirOrcamento(pagador, procedimentos, planoSaude);
	}

}
