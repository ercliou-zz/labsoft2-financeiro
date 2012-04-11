package br.com.drerp.financeiro.web.transferencia;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DualListModel;

import br.com.drerp.financeiro.api.FinanceiroFacade;
import br.com.drerp.financeiro.api.FinanceiroFacadeImpl;
import br.com.drerp.financeiro.business.planosaude.PlanoSaudeBR;
import br.com.drerp.financeiro.business.procedimento.ProcedimentoBR;
import br.com.drerp.financeiro.business.transferencia.ContaReceberBR;
import br.com.drerp.financeiro.business.transferencia.FaturaBR;
import br.com.drerp.financeiro.business.transferencia.PagadorBR;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.transferencia.ContaReceber;
import br.com.drerp.financeiro.model.transferencia.Fatura;
import br.com.drerp.financeiro.model.transferencia.ItemFatura;
import br.com.drerp.financeiro.model.transferencia.Pagador;
import br.com.drerp.financeiro.model.transferencia.StatusTransferencia;
import br.com.drerp.financeiro.util.FinanceiroConstants;

@ManagedBean(name = "faturaBean")
@RequestScoped
public class FaturaBean {
	private Fatura fatura;
	private FaturaBR faturaBR;
	private List<Fatura> faturas;
	
	private PagadorBR pagadorBR;
	private List<Pagador> pagadores;
	private Long pagadorSelecionado;
	
	private PlanoSaudeBR planoSaudeBR;
	private List<PlanoSaude> planos;
	private Long planoSelecionado;
	
	private DualListModel<Procedimento> procedimentos;
	private ProcedimentoBR procedimentoBR;
	
	private ContaReceberBR contaReceberBR;
	
	private FinanceiroFacade facade;

	public FaturaBean() {
		this.fatura = new Fatura();
		this.faturaBR = new FaturaBR();
		this.pagadorBR = new PagadorBR();
		this.procedimentoBR = new ProcedimentoBR();
		this.planoSaudeBR = new PlanoSaudeBR();
		this.contaReceberBR = new ContaReceberBR();
		this.facade = new FinanceiroFacadeImpl();
		
		List<Procedimento> source = this.procedimentoBR.list();
		List<Procedimento> target = new ArrayList<Procedimento>();
		this.procedimentos = new DualListModel<Procedimento>(source, target);
	}

	public String edit() {
		return "edit";
	}

	public String view() {
		return "view";
	}
	
	public String list() {
		return "list";
	}

	public String create() {
		this.fatura = new Fatura();
		return edit();
	}

	public String save() {
		this.fatura.setDataMS((new Date()).getTime());
		this.fatura.setPaga(false);
		Pagador pagador = this.pagadorBR.getById(pagadorSelecionado);
		this.fatura.setPagador(pagador);
		this.fatura.setPlanoSaude(this.planoSaudeBR.getById(planoSelecionado));
		List<Procedimento> procedimentosSelecionados = new ArrayList<Procedimento>();
		List<ItemFatura> itens = new ArrayList<ItemFatura>();
		for (Object procedimentoId : procedimentos.getTarget()) {
			if(procedimentoId.getClass().isAssignableFrom(String.class)){
				Procedimento proc = this.procedimentoBR.getById(Long.parseLong((String)procedimentoId));
				procedimentosSelecionados.add(proc);
				ItemFatura item = new ItemFatura();
				item.setFatura(fatura);
				item.setProcedimento(proc);
				List<Procedimento> procedimentoItem = new ArrayList<Procedimento>();
				procedimentoItem.add(proc);
				item.setValor(this.facade.pedirOrcamento(fatura.getPagador(), procedimentoItem, fatura.getPlanoSaude()));
				itens.add(item);
			}
		}
		this.fatura.setItens(itens);
		this.fatura.setValor(this.facade.pedirOrcamento(fatura.getPagador(), procedimentosSelecionados, fatura.getPlanoSaude()));
		this.faturaBR.save(this.fatura);
		
		// Para guias e contas a receber:
		if(this.fatura.getPlanoSaude().getNome().equals(FinanceiroConstants.PLANO_PARTICULAR)){
			ContaReceber conta = new ContaReceber();
			conta.setPagador(pagador);
			conta.setDataRequisicaoMilis((new Date()).getTime());
			//Limite de pagamento de 60dias corridos
			conta.setDataLimiteMilis((new Date()).getTime() + 60*24*60*60*1000);
			conta.setStatus(StatusTransferencia.PENDENTE);
			conta.setValor(fatura.getValor());
			List<Fatura> fats = new ArrayList<Fatura>();
			fats.add(fatura);
			conta.setFaturas(fats);
			this.contaReceberBR.save(conta);
			
		}
		else{
			//ContaReceber conta;
			//conta.setBeneficiario(beneficiario)
		}
		return list();
	}

	public String delete() {
		this.faturaBR.delete(this.fatura);
		return list();
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

	public List<Fatura> getFaturas() {
		this.faturas = (List<Fatura>) faturaBR.list();
		return this.faturas;
	}

	public void setFaturas(List<Fatura> faturas) {
		this.faturas = faturas;
	}

	public List<Pagador> getPagadores() {
		pagadores = pagadorBR.list();
		return pagadores;
	}

	public void setPagadores(List<Pagador> pagadores) {
		this.pagadores = pagadores;
	}

	public Long getPagadorSelecionado() {
		return pagadorSelecionado;
	}

	public void setPagadorSelecionado(Long pagadorSelecionado) {
		this.pagadorSelecionado = pagadorSelecionado;
	}

	public List<PlanoSaude> getPlanos() {
		this.planos = this.planoSaudeBR.list();
		return planos;
	}

	public void setPlanos(List<PlanoSaude> planos) {
		this.planos = planos;
	}

	public Long getPlanoSelecionado() {
		return planoSelecionado;
	}

	public void setPlanoSelecionado(Long planoSelecionado) {
		this.planoSelecionado = planoSelecionado;
	}

	public DualListModel<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(DualListModel<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

}
