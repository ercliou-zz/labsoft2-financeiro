package br.com.drerp.financeiro.model.tabela;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.dao.GenericModel;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

@Entity
@Table(name="FIN_COLUNA")
public class Coluna extends GenericModel {
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="planoSaude_fk")
	private PlanoSaude planoSaude;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=Tabela.class )
	private Tabela tabela;
	
	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}
	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}
	public Tabela getTabela() {
		return tabela;
	}
	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}
}
