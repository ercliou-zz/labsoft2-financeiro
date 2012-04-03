package br.com.drerp.financeiro.service;

import java.math.BigDecimal;

import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;
import br.com.drerp.financeiro.model.transferencia.NotaFiscal;

public interface FinanceiroService {
	
	public Boolean pagarProduto(BigDecimal valor, Beneficiario empresa);
	public BigDecimal pagarSalario(BigDecimal valor, Beneficiario funcionario);
	public Procedimento[] listarProcedimentos();
	public PlanoSaude[] listarPlanosSaude();
	public Boolean pagarConsultaPlanoSaude(PlanoSaude planoSaude, Procedimento[] listaProcedimentos);
	public NotaFiscal pagarConsultaParticular(PlanoSaude planoSaude, Procedimento[] listaProcedimentos);
	
}
