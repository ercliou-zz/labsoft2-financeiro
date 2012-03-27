package br.com.drerp.financeiro.model.transferencia;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FIN_CONTARECEBER")
public class ContaReceber extends Transferencia{
	
	@OneToOne
	private NotaFiscal notaFiscal;

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	
}
