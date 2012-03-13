package br.com.drerp.financeiro.api;

import java.math.BigDecimal;
import java.util.Date;

import br.com.drerp.financeiro.model.transferencia.Beneficiario;
import br.com.drerp.financeiro.model.transferencia.Pagador;

public interface FinanceiroFacade {
	public Boolean requisitarTransferencia(Beneficiario beneficiario, Pagador pagador, BigDecimal valor, Date data);
}
