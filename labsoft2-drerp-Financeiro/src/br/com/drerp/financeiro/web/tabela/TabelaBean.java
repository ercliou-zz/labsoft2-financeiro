package br.com.drerp.financeiro.web.tabela;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.drerp.financeiro.business.tabela.TabelaBR;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.tabela.Coluna;
import br.com.drerp.financeiro.model.tabela.ItemTabela;
import br.com.drerp.financeiro.model.tabela.Valor;

@ManagedBean(name="tabelaBean")
@RequestScoped
public class TabelaBean {
	
	private TabelaBR tabelaBR;
	private List<ItemTabela> itens;
	private List<Coluna> colunas;
	
	public TabelaBean() {
		tabelaBR = new TabelaBR();
		itens = tabelaBR.listarItens();
		colunas = tabelaBR.listarColunas();
		
		//para teste
		Procedimento pro1 = new Procedimento();
		pro1.setNome("Consulta");
		ItemTabela item1 = new ItemTabela();
		item1.setProcedimento(pro1);
		Valor val = new Valor();
		val.setValor((new BigDecimal(1.1)));
		Valor val2 = new Valor();
		val2.setValor(new BigDecimal(2.1));
		List<Valor> valores = new ArrayList<Valor>();
		valores.add(val);
		valores.add(val2);
		item1.setValores(valores);
		itens.add(item1);
		
		PlanoSaude ps1 = new PlanoSaude();
		ps1.setNome("PLANO1");
		PlanoSaude ps2 = new PlanoSaude();
		ps2.setNome("PLANO2");
		Coluna col1 = new Coluna();
		col1.setPlanoSaude(ps1);
		Coluna col2 = new Coluna();
		col2.setPlanoSaude(ps2);
		List<Coluna> cols = new ArrayList<Coluna>();
		cols.add(col1);
		cols.add(col2);
	}

	public List<ItemTabela> getItens() {
		return itens;
	}

	public List<Coluna> getColunas() {
		Collections.sort(colunas, new ColunaComparator());
		return colunas;
	}
	
}
