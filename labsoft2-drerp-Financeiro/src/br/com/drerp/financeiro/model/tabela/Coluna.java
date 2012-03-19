package br.com.drerp.financeiro.model.tabela;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.drerp.financeiro.dao.GenericModel;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

@Entity
@Table(name="FIN_COLUNA")
public class Coluna extends GenericModel {
	
	private PlanoSaude planoSaude;
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
