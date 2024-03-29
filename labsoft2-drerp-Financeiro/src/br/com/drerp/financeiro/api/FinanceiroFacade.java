package br.com.drerp.financeiro.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;
import br.com.drerp.financeiro.model.transferencia.Pagador;

public interface FinanceiroFacade {
	
	public Boolean requisitarTransferencia(Beneficiario beneficiario, Pagador pagador, BigDecimal valor, Date data);
	
	public BigDecimal pedirOrcamento(Pagador pagador, List<Procedimento> procedimentos, PlanoSaude planoSaude);
}
