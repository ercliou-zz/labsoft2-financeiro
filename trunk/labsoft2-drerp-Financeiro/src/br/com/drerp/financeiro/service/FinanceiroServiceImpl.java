package br.com.drerp.financeiro.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.jws.WebService;

import br.com.drerp.financeiro.business.planosaude.PlanoSaudeBR;
import br.com.drerp.financeiro.business.procedimento.ProcedimentoBR;
import br.com.drerp.financeiro.business.tabela.TabelaBR;
import br.com.drerp.financeiro.business.transferencia.BeneficiarioBR;
import br.com.drerp.financeiro.business.transferencia.ContaPagarBR;
import br.com.drerp.financeiro.business.transferencia.ContaReceberBR;
import br.com.drerp.financeiro.business.transferencia.FaturaBR;
import br.com.drerp.financeiro.business.transferencia.PagadorBR;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.transferencia.Beneficiario;
import br.com.drerp.financeiro.model.transferencia.ContaPagar;
import br.com.drerp.financeiro.model.transferencia.ContaReceber;
import br.com.drerp.financeiro.model.transferencia.Departamento;
import br.com.drerp.financeiro.model.transferencia.Pagador;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;
import br.com.drerp.financeiro.util.FinanceiroConstants;

@WebService(targetNamespace = "http://service.financeiro.drerp.com.br/", portName = "FinanceiroServiceImplPort", serviceName = "FinanceiroServiceImplService")
public class FinanceiroServiceImpl implements FinanceiroService, Serializable {

	private static final long serialVersionUID = 2683423957843060597L;

	public Beneficiario[] listarEmpresas() {
		BeneficiarioBR beneficiarioBR = new BeneficiarioBR();
		List<Beneficiario> empresas = beneficiarioBR.listarEmpresas();
		return empresas.toArray(new Beneficiario[empresas.size()]);
	}

	public Boolean registrarEmpresa(Beneficiario empresa) {
		BeneficiarioBR beneficiarioBR = new BeneficiarioBR();
		try {
			beneficiarioBR.salvar(empresa);
		} catch (Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public Boolean pagarProduto(BigDecimal valor, Beneficiario empresa) {
		long now = System.currentTimeMillis();
		ContaPagar conta = new ContaPagar();
		conta.setDataRequisicaoMilis(now);
		conta.setDataRealizacaoMilis(now + 10);
		conta.setDataLimiteMilis(now + 300000);

		ContaPagarBR contaBR = new ContaPagarBR();
		BeneficiarioBR beneficiarioBR = new BeneficiarioBR();
		Beneficiario beneficiario = beneficiarioBR.salvar(empresa);
		conta.setBeneficiario(beneficiario);

		PagadorBR pagadorBR = new PagadorBR();
		Pagador clinica = pagadorBR.getClinica();

		conta.setPagador(clinica);
		conta.setDepartamento(Departamento.ALMOXARIFADO);

		try {
			contaBR.save(conta);
		} catch (Exception e) {
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	public Imposto[] pagarSalario(BigDecimal salarioBruto,
			Beneficiario funcionario) {
		long now = System.currentTimeMillis();
		ContaPagar conta = new ContaPagar();
		conta.setDataRequisicaoMilis(now);
		conta.setDataRealizacaoMilis(now + 10);
		conta.setDataLimiteMilis(now + 300000);
		conta.setStatus(StatusTransferencia.PENDENTE);

		ContaPagarBR contaBR = new ContaPagarBR();

		Beneficiario beneficiario = new Beneficiario();
		// beneficiario.setNome(funcionario.getNome());
		// beneficiario.setDocumento(funcionario.getDocumento());
		// beneficiario.setInfoBancaria(funcionario.getInfoBancaria());
		// beneficiario.setTipoBeneficiario(funcionario.getTipoBeneficiario());
		//
		BeneficiarioBR beneficiarioBR = new BeneficiarioBR();
		beneficiario = beneficiarioBR.salvar(funcionario);

		conta.setBeneficiario(beneficiario);
		conta.setValor(salarioBruto);
		conta.setDepartamento(Departamento.RH);

		PagadorBR pagadorBR = new PagadorBR();
		Pagador clinica = pagadorBR.getClinica();

		conta.setPagador(clinica);

		try {
			contaBR.save(conta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Imposto> impostos = Imposto.aplicaImpostos(salarioBruto
				.doubleValue());
		return impostos.toArray(new Imposto[impostos.size()]);
	}

	public Procedimento[] listarProcedimentos() {

		ProcedimentoBR procedimentoBR = new ProcedimentoBR();
		List<Procedimento> procedimentoList = procedimentoBR.list();
		return procedimentoList.toArray(new Procedimento[procedimentoList
				.size()]);
	}

	public PlanoSaude[] listarPlanosSaude() {

		PlanoSaudeBR planoSaudeBR = new PlanoSaudeBR();
		List<PlanoSaude> planoSaudeList = planoSaudeBR.list();
		return planoSaudeList.toArray(new PlanoSaude[planoSaudeList.size()]);
	}

	public Boolean pagarConsultaPlanoSaude(PlanoSaude planoSaude, Procedimento[] listaProcedimentos) {
		
		PagadorBR pagadorBR = new PagadorBR();
		Pagador pag = new Pagador();
		pag.setNome(planoSaude.getNome());
		pag.setDocumento(planoSaude.getNome());

		Pagador pagador = pagadorBR.salvar(pag);

		BigDecimal valor = new BigDecimal(0);

		TabelaBR t = new TabelaBR();

		PlanoSaudeBR psBR = new PlanoSaudeBR();
		PlanoSaude ps = psBR.getById(planoSaude.getId());
		
		ProcedimentoBR pBR = new ProcedimentoBR();
		Procedimento p;
		for (Procedimento proc : listaProcedimentos) {
			p = pBR.getById(proc.getId());
			valor = valor.add(t.recuperarValor(ps, p));
		}
		
		FaturaBR faturaBR = new FaturaBR();
		faturaBR.salvarFatura(pagador.getId(), planoSaude.getId(), Arrays.asList(listaProcedimentos));
		
		return Boolean.TRUE;
	}

	public NotaFiscal pagarConsultaParticular(Pagador paciente,
			Procedimento[] listaProcedimentos) {
		long now = System.currentTimeMillis();
		ContaReceber conta = new ContaReceber();
		conta.setDataRequisicaoMilis(now);
		conta.setDataLimiteMilis(now + 2592000000l);
		conta.setStatus(StatusTransferencia.PENDENTE);

		ContaReceberBR contaBR = new ContaReceberBR();
		PagadorBR pagadorBR = new PagadorBR();

		Pagador pagador = pagadorBR.salvar(paciente);

		conta.setPagador(pagador);
		BigDecimal valor = new BigDecimal(0);

		PlanoSaudeBR psBR = new PlanoSaudeBR();
		PlanoSaude ps = psBR.getByNome(FinanceiroConstants.PLANO_PARTICULAR);

		TabelaBR t = new TabelaBR();

		ProcedimentoBR pBR = new ProcedimentoBR();
		Procedimento p;
		for (Procedimento proc : listaProcedimentos) {
			p = pBR.getById(proc.getId());
			valor = valor.add(t.recuperarValor(ps, p));
		}
		conta.setValor(valor);

		BeneficiarioBR beneficiarioBR = new BeneficiarioBR();
		Beneficiario clinica = beneficiarioBR.getClinica();

		conta.setBeneficiario(clinica);
		
		FaturaBR faturaBR = new FaturaBR();
		faturaBR.salvarFatura(pagador.getId(), ps.getId(), Arrays.asList(listaProcedimentos));

		try {
			contaBR.lancarPagamento(conta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		NotaFiscal nota = new NotaFiscal(valor);
		return nota;
	}

}
