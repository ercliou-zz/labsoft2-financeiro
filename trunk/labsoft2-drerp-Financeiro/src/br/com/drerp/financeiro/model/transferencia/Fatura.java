package br.com.drerp.financeiro.model.transferencia;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.drerp.financeiro.model.GenericModel;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

@Entity
@Table(name="FIN_FATURA")
public class Fatura extends GenericModel{
	
	@ManyToOne
	private PlanoSaude planoSaude;
	
	@OneToMany(mappedBy="fatura", cascade=CascadeType.ALL)
	private List<ItemFatura> itens;
	
	@OneToOne
	@JoinColumn(name="pagador_fk")
	private Pagador pagador;
	
	private Long dataMS;
	
	private Boolean paga;
	
	private BigDecimal valor;
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getValorFormatado(){
		if (valor != null) {
			DecimalFormat formatter = new DecimalFormat();
			formatter.setMaximumFractionDigits(2);
			return "R$ " + formatter.format(valor);
		}
		return "Indefinido";
	}
	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}
	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}
	public List<ItemFatura> getItens() {
		return itens;
	}
	public void setItens(List<ItemFatura> itens) {
		this.itens = itens;
	}
	public Pagador getPagador() {
		return pagador;
	}
	public void setPagador(Pagador pagador) {
		this.pagador = pagador;
	}
	@Transient
	public Date getData() {
		return new Date(dataMS);
	}
	public Long getDataMS() {
		return dataMS;
	}
	public void setDataMS(Long dataMS) {
		this.dataMS = dataMS;
	}
	public String getPlanoData(){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return this.planoSaude.getNome() + ", " + format.format(new Date(dataMS));
	}
	
	public Boolean getPaga() {
		return paga;
	}
	public void setPaga(Boolean paga) {
		this.paga = paga;
	}
	
}
