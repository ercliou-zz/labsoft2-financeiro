package br.com.drerp.financeiro.model.tabela;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;
import br.com.drerp.financeiro.model.planosaude.Procedimento;

@Entity
@Table(name="FIN_ITEMTABELA")
public class ItemTabela extends GenericModel{
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="procedimento_fk")
	private Procedimento procedimento;
	
	@OneToMany(mappedBy="itemTabela")
	private List<Valor> valores;
	
	public Procedimento getProcedimento() {
		return procedimento;
	}
	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}
	public List<Valor> getValores() {
		return valores;
	}
	public void setValores(List<Valor> valores) {
		this.valores = valores;
	}
	
}
