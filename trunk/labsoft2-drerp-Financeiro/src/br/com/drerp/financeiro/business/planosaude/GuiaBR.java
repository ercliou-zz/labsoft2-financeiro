package br.com.drerp.financeiro.business.planosaude;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.business.transferencia.ContaReceberBR;
import br.com.drerp.financeiro.business.transferencia.FaturaBR;
import br.com.drerp.financeiro.dao.planosaude.GuiaDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.transferencia.ContaReceber;
import br.com.drerp.financeiro.model.transferencia.Fatura;
import br.com.drerp.financeiro.model.transferencia.Guia;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;

public class GuiaBR extends GenericBR<GuiaDAOImpl, Guia>{

	private FaturaBR faturaBR;
	private PlanoSaudeBR planoSaudeBR;
	private ContaReceberBR contaReceberBR;
	
	public GuiaBR(){
		faturaBR = new FaturaBR();
		planoSaudeBR = new PlanoSaudeBR();
		contaReceberBR = new ContaReceberBR();
	}
	
	public List<Guia> lancarFaturasDoMes(Long inicio, Long fim){
		List<Guia> guias = new ArrayList<Guia>();
		for (PlanoSaude plano : planoSaudeBR.list()) {
			Guia guia = new Guia();
			guia.setDataInicialMS(inicio);
			guia.setDataFinalMS(fim);
			List<Fatura> faturas = faturaBR.listarFaturas(plano, inicio, fim);
			guia.setFaturas(faturas);
			guia.setPlanoSaude(plano);
			guia.setPagador(faturas.get(0).getPagador());
			
			save(guia);
			guias.add(guia);
			
			ContaReceber conta = new ContaReceber();
			// setar nossa clinica
			conta.setBeneficiario(null);
			conta.setDataRequisicaoMilis((new Date()).getTime());
			conta.setDataLimiteMilis((new Date()).getTime() + new Long (2592000000l));
			conta.setFaturas(faturas);
			conta.setStatus(StatusTransferencia.PENDENTE);
			
			BigDecimal total = new BigDecimal(0);
			for (Fatura fatura : faturas) {
				total.add(fatura.getValor());
			}
			
			conta.setValor(total);
			
			// TODO notafiscal
			contaReceberBR.save(conta);
		}
		return guias;
	}
}
