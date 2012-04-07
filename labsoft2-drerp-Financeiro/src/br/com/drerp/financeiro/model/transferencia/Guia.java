package br.com.drerp.financeiro.model.transferencia;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.drerp.financeiro.model.GenericModel;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

@Entity
@Table(name="FIN_GUIA")
public class Guia extends GenericModel{
	
	@ManyToOne
	private PlanoSaude planoSaude;
	
	@OneToOne
	private Pagador pagador;
	
	@ManyToMany
	private List<Fatura> faturas;
	
	private Long dataInicialMS;
	private Long dataFinalMS;

	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}

	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}

	public Pagador getPagador() {
		return pagador;
	}

	public void setPagador(Pagador pagador) {
		this.pagador = pagador;
	}

	public List<Fatura> getFaturas() {
		return faturas;
	}

	public void setFaturas(List<Fatura> faturas) {
		this.faturas = faturas;
	}

	public Long getDataInicialMS() {
		return dataInicialMS;
	}

	public void setDataInicialMS(Long dataInicial) {
		this.dataInicialMS = dataInicial;
	}
	@Transient
	public Date getDataInicial() {
		if (dataInicialMS == null) {
			dataInicialMS = System.currentTimeMillis();
			return new Date();
		}
		return new Date(dataInicialMS);
	}

	public Long getDataFinalMS() {
		return dataFinalMS;
	}

	public void setDataFinalMS(Long dataFinal) {
		this.dataFinalMS = dataFinal;
	}
	
	@Transient
	public Date getDataFinal() {
		if (dataFinalMS == null) {
			dataFinalMS = System.currentTimeMillis();
			return new Date();
		}
		return new Date(dataFinalMS);
	}
	
}
