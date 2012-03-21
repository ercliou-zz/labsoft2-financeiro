package br.com.drerp.financeiro.model.tributo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.drerp.financeiro.dao.GenericModel;

@Entity
@Table(name = "FIN_TRIBUTO_MENSAL")
public class TributoMensal extends GenericModel {

	private Long dataInicioMilis;
	private Long dataFimMilis;

	@OneToMany(mappedBy = "tributoMensal")
	private List<Tributo> tributos;

	@Transient
	public Date getDataInicioMilis() {
		return new Date(dataInicioMilis);
	}

	public void setDataInicioMilis(Long dataInicioMilis) {
		this.dataInicioMilis = dataInicioMilis;
	}

	@Transient
	public Date getDataFimMilis() {
		return new Date(dataFimMilis);
	}

	public void setDataFimMilis(Long dataFimMilis) {
		this.dataFimMilis = dataFimMilis;
	}

	public List<Tributo> getTributos() {
		return tributos;
	}

	public void setTributos(List<Tributo> tributos) {
		this.tributos = tributos;
	}

}
