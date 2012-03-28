package br.com.drerp.financeiro.model.transferencia;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;
import br.com.drerp.financeiro.model.procedimento.Procedimento;

@Entity
@Table(name="FIN_FATURA")
public class Fatura extends GenericModel{
	
	@ManyToOne
	private PlanoSaude planoSaude;
	
	@ManyToMany
	private List<Procedimento> procedimentos;
	
	@OneToOne
	@JoinColumn(name="pagador_fk")
	private Pagador pagador;
	
	@OneToOne
	@JoinColumn(name="beneficiario_fk")
	private Beneficiario beneficiario;
	
	
	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}
	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}
	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}
	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}
	public Pagador getPagador() {
		return pagador;
	}
	public void setPagador(Pagador pagador) {
		this.pagador = pagador;
	}
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	
}
