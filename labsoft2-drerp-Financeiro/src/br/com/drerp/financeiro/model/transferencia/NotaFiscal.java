package br.com.drerp.financeiro.model.transferencia;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.drerp.financeiro.model.GenericModel;

@Entity
@Table(name="FIN_NOTAFISCAL")
public class NotaFiscal extends GenericModel{
	
	@OneToOne
	@JoinColumn(name="contaReceber_fk")
	private ContaReceber contaReceber;

	public ContaReceber getContaReceber() {
		return contaReceber;
	}

	public void setContaReceber(ContaReceber contaReceber) {
		this.contaReceber = contaReceber;
	}
	
}
