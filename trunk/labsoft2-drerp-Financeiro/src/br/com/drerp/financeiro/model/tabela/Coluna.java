package br.com.drerp.financeiro.model.tabela;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;
import br.com.drerp.financeiro.model.planosaude.PlanoSaude;

@Entity
@Table(name="FIN_COLUNA")
public class Coluna extends GenericModel implements Serializable{
	
	private static final long serialVersionUID = -4247039522186908883L;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="planoSaude_fk")
	private PlanoSaude planoSaude;
	
	public PlanoSaude getPlanoSaude() {
		return planoSaude;
	}
	public void setPlanoSaude(PlanoSaude planoSaude) {
		this.planoSaude = planoSaude;
	}
}