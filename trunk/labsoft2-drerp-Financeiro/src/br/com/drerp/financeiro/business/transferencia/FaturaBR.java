package br.com.drerp.financeiro.business.transferencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.drerp.financeiro.api.FinanceiroFacade;
import br.com.drerp.financeiro.api.FinanceiroFacadeImpl;
import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.business.planosaude.PlanoSaudeBR;
import br.com.drerp.financeiro.dao.transferencia.FaturaDAOImpl;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.transferencia.Fatura;
import br.com.drerp.financeiro.model.transferencia.ItemFatura;
import br.com.drerp.financeiro.model.transferencia.Pagador;

public class FaturaBR extends GenericBR<FaturaDAOImpl, Fatura> {

	public List<Fatura> listarFaturas(PlanoSaude plano, Long dataInicial,
			Long dataFinal){
		return super.dao.listarFaturas(plano, dataInicial, dataFinal);
	}
	
	public Fatura salvarFatura(Long pagadorSelecionado, Long planoSelecionado, List<Procedimento> procedimentos){
		Fatura fatura = new Fatura();
		
		PlanoSaudeBR planoSaudeBR = new PlanoSaudeBR();
		PagadorBR pagadorBR = new PagadorBR();
		FinanceiroFacade facade = new FinanceiroFacadeImpl();
		
		fatura.setDataMS((new Date()).getTime());
		fatura.setPaga(false);
		Pagador pagador = pagadorBR.getById(pagadorSelecionado);
		fatura.setPagador(pagador);
		PlanoSaude plano = planoSaudeBR.getById(planoSelecionado);
		fatura.setPlanoSaude(plano);

		List<ItemFatura> itens = new ArrayList<ItemFatura>();
		for (Procedimento procedimento : procedimentos) {
			ItemFatura item = new ItemFatura();
			item.setFatura(fatura);
			item.setProcedimento(procedimento);
			List<Procedimento> proc = new ArrayList<Procedimento>();
			proc.add(procedimento);
			item.setValor(facade.pedirOrcamento(pagador, proc, plano));
			itens.add(item);
		}
		
		fatura.setItens(itens);
		fatura.setValor(facade.pedirOrcamento(fatura.getPagador(), procedimentos, fatura.getPlanoSaude()));
		this.dao.save(fatura);
		return fatura;
	}
	
}
