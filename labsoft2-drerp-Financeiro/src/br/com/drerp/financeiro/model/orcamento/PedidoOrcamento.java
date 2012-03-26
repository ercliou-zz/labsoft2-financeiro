package br.com.drerp.financeiro.model.orcamento;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;
import br.com.drerp.financeiro.model.transferencia.Pagador;


@Entity
@Table (name = "FIN_PEDIDOORCAMENTO")
public class PedidoOrcamento extends GenericModel {

	@OneToOne(cascade = CascadeType.ALL)
	private Pagador pagador;
	
//	@OneToMany
//    @JoinTable(
//            name="FIN_PEDIDO_PROCEDIMENTO",
//            joinColumns = { @JoinColumn( name="PEDIDO_ID") },
//            inverseJoinColumns = @JoinColumn( name="PROCEDIMENTO_ID"))
//	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinColumn(name="PEDIDO_ID")
	
//	@ManyToMany(cascade = CascadeType.PERSIST)
	
	
	@ManyToMany(
	        targetEntity=br.com.drerp.financeiro.model.procedimento.Procedimento.class,
	        cascade={CascadeType.PERSIST, CascadeType.MERGE}
	    )
	    @JoinTable(
	        name="FIN_PEDIDO_PROCEDIMENTO",
	        joinColumns={@JoinColumn(name="PEDIDO_ID")},
	        inverseJoinColumns={@JoinColumn(name="PROCEDIMENTO_ID")}
	    )
	private List<Procedimento> procedimentos;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PlanoSaude plano;
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Orcamento orcamento;
	
	private Long dataPedidoMilis;

	public Pagador getPagador() {
		return pagador;
	}

	public void setPagador(Pagador pagador) {
		this.pagador = pagador;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
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

	public Long getDataPedidoMilis() {
		return dataPedidoMilis;
	}

	public void setDataPedidoMilis(Long dataPedidoMilis) {
		this.dataPedidoMilis = dataPedidoMilis;
	}
	
	public Date getDataRequisicao() {
		return new Date(this.dataPedidoMilis);
	}
	
}
