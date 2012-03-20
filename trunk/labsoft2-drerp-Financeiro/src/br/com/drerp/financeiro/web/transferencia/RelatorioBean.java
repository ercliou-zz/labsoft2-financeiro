package br.com.drerp.financeiro.web.transferencia;

import br.com.drerp.financeiro.business.transferencia.TransferenciaBR;
import br.com.drerp.financeiro.model.transferencia.Relatorio;

public class RelatorioBean {

	private Relatorio relatorio = new Relatorio();

	public Relatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}

	public String searchTransferencias(){
		TransferenciaBR trans = new TransferenciaBR();
		relatorio.setTransferencias(trans.searchTransferencia());
		return "relatorioTransferencia";
	}
}
