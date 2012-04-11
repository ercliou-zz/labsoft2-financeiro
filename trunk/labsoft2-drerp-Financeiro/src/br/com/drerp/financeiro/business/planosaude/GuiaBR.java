package br.com.drerp.financeiro.business.planosaude;

import java.util.ArrayList;
import java.util.List;

import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.business.transferencia.FaturaBR;
import br.com.drerp.financeiro.dao.planosaude.GuiaDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.transferencia.Fatura;
import br.com.drerp.financeiro.model.transferencia.Guia;

public class GuiaBR extends GenericBR<GuiaDAOImpl, Guia>{

	private FaturaBR faturaBR;
	private PlanoSaudeBR planoSaudeBR;
	
	public GuiaBR(){
		faturaBR = new FaturaBR();
		planoSaudeBR = new PlanoSaudeBR();
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
		}
		return guias;
	}
}
