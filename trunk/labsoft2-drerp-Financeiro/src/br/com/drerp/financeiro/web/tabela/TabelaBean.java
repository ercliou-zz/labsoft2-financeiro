package br.com.drerp.financeiro.web.tabela;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.drerp.financeiro.business.tabela.TabelaBR;
import br.com.drerp.financeiro.model.tabela.Coluna;
import br.com.drerp.financeiro.model.tabela.ItemTabela;
import br.com.drerp.financeiro.model.tabela.Valor;

@ManagedBean(name = "tabelaBean")
@SessionScoped
public class TabelaBean {

	private TabelaBR tabelaBR;
	private List<ItemTabela> itens;
	private List<Coluna> colunas;

	private Valor valor;
	private Long colunaId;
	private Long itemTabelaId;

	private ItemTabela itemTabela;
	private Long colunaIndex;

	public TabelaBean() {
		valor = new Valor();

		tabelaBR = new TabelaBR();
		itens = tabelaBR.listarItens();
		colunas = tabelaBR.listarColunas();

	}

	public List<ItemTabela> getItens() {
		return itens;
	}

	public List<Coluna> getColunas() {
		Collections.sort(colunas, new ColunaComparator());
		return colunas;
	}

	public ItemTabela getItemTabela() {
		return itemTabela;
	}

	public void setItemTabela(ItemTabela itemTabela) {
		this.itemTabela = itemTabela;
	}

	public Long getColunaIndex() {
		return colunaIndex;
	}

	public void setColunaIndex(Long colunaIndex) {
		this.colunaIndex = colunaIndex;
	}

	public Valor getValor() {
		return valor;
	}

	public void setValor(Valor valor) {
		this.valor = valor;
	}

	public Long getColunaId() {
		return colunaId;
	}

	public void setColunaId(Long colunaId) {
		this.colunaId = colunaId;
	}

	public Long getItemTabelaId() {
		return itemTabelaId;
	}

	public void setItemTabelaId(Long itemTabelaId) {
		this.itemTabelaId = itemTabelaId;
	}

	public String editValor() {

		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String colIndex = params.get("colIndex");

		this.valor = this.itemTabela.getValores().get(Integer.parseInt(colIndex));
		this.colunaId = this.valor.getColuna().getId();
		this.itemTabelaId = this.valor.getItemTabela().getId();
		return "valorEdit";
	}

	public String saveValor() {
		this.tabelaBR.updateValor(valor, colunaId, itemTabelaId);
		return "tabela";
	}

}
