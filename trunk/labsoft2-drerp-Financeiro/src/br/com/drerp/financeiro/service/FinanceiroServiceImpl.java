package br.com.drerp.financeiro.service;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.drerp.financeiro.business.planosaude.PlanoSaudeBR;
import br.com.drerp.financeiro.business.procedimento.ProcedimentoBR;
import br.com.drerp.financeiro.business.transferencia.PagadorBR;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;
import br.com.drerp.financeiro.model.transferencia.ContaPagar;
import br.com.drerp.financeiro.model.transferencia.NotaFiscal;

public class FinanceiroServiceImpl implements FinanceiroService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2683423957843060597L;

	@Override
	public Boolean pagarProduto(BigDecimal valor, Beneficiario empresa) {

		ContaPagar contaPagar = new ContaPagar();
		contaPagar.setBeneficiario(empresa);
		
		PagadorBR pagadorBR = new PagadorBR();
		contaPagar.setPagador(null);
		return Boolean.TRUE;
	}

	@Override
	public BigDecimal pagarSalario(BigDecimal valor, Beneficiario funcionario) {
		// TODO Auto-generated method stub
		return new BigDecimal(10000);
	}

	@Override
	public Procedimento[] listarProcedimentos() {
		
		ProcedimentoBR procedimentoBR = new ProcedimentoBR();
		return (Procedimento[]) procedimentoBR.list().toArray();
	}

	@Override
	public PlanoSaude[] listarPlanosSaude() {

		PlanoSaudeBR planoSaudeBR = new PlanoSaudeBR();
		return (PlanoSaude[]) planoSaudeBR.list().toArray();
	}

	@Override
	public Boolean pagarConsultaPlanoSaude(PlanoSaude planoSaude,
			Procedimento[] listaProcedimentos) {
		// TODO Auto-generated method stub
		return Boolean.TRUE;
	}

	@Override
	public NotaFiscal pagarConsultaParticular(PlanoSaude planoSaude,
			Procedimento[] listaProcedimentos) {
		// TODO Auto-generated method stub
		return new NotaFiscal();
	}

}
