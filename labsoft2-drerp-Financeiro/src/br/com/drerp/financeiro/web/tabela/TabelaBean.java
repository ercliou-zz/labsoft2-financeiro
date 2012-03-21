package br.com.drerp.financeiro.web.tabela;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.tabela.TabelaBR;
import br.com.drerp.financeiro.model.tabela.Tabela;

@ManagedBean(name="TabelaBean")
@RequestScoped
public class TabelaBean {
	
	private Tabela tabela;
	private TabelaBR tabelaBR;
	
	public TabelaBean() {
		super();
		tabela = tabelaBR.list().get(0);
	}

	public Tabela getTabela() {
		return tabela;
	}

	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}
}
