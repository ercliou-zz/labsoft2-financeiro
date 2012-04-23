package br.com.drerp.financeiro.model.transferencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FIN_CONTAPAGAR")
public class ContaPagar extends Transferencia implements Serializable{
	
	private static final long serialVersionUID = 2207536572978139692L;
	
	public ContaPagar(Transferencia transferencia) {
		this.setBeneficiario(transferencia.getBeneficiario());
		this.setDataLimiteMilis(transferencia.getDataLimiteMilis());
		this.setDataRealizacaoMilis(transferencia.getDataRealizacaoMilis());
		this.setDataRequisicaoMilis(transferencia.getDataRequisicaoMilis());
		this.setPagador(transferencia.getPagador());
		this.setStatus(transferencia.getStatus());
		this.setValor(transferencia.getValor());
	}
	
	public ContaPagar() {
		super();
	}

}
