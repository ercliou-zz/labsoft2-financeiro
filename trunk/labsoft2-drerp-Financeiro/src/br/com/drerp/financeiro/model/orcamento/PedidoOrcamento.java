package br.com.drerp.financeiro.model.orcamento;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.dao.GenericModel;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.tabela.ItemTabela;
import br.com.drerp.financeiro.model.transferencia.Pagador;


@Entity
@Table (name = "FIN_PEDIDOORCAMENTO")
public class PedidoOrcamento extends GenericModel {

	@OneToOne(cascade = CascadeType.ALL)
	private Pagador pagador;
	
	@OneToMany
    @JoinTable(
            name="FIN_PEDIDO_ITEMTABELA",
            joinColumns = { @JoinColumn( name="PEDIDO_ID") },
            inverseJoinColumns = @JoinColumn( name="ITEMTABELA_ID"))
	private List<ItemTabela> procedimentos;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PlanoSaude plano;
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Orcamento orcamento;

	public Pagador getPagador() {
		return pagador;
	}

	public void setPagador(Pagador pagador) {
		this.pagador = pagador;
	}

	public List<ItemTabela> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<ItemTabela> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public PlanoSaude getPlano() {
		return plano;
	}

	public void setPlano(PlanoSaude plano) {
		this.plano = plano;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	
	
	

}
