package br.com.drerp.financeiro.web.transferencia;

import java.util.List;

import br.com.drerp.financeiro.business.transferencia.NotaFiscalBR;
import br.com.drerp.financeiro.model.transferencia.NotaFiscal;

public class NotaFiscalBean {
	private NotaFiscal notaFiscal;
	private NotaFiscalBR notaFiscalBR;
	private List<NotaFiscal> notasFiscais;
	
	public NotaFiscalBean() {
		this.notaFiscal = new NotaFiscal();
		this.notaFiscalBR = new NotaFiscalBR();
	}
	
	public String edit() {
		return "edit";
	}

	public String view() {
		return "view";
	}

	public String create() {
		this.notaFiscal = new NotaFiscal();
		return edit();
	}

	public String save() {
		this.notaFiscalBR.save(this.notaFiscal);
		return list();
	}

	public String delete() {
		this.notaFiscalBR.delete(this.notaFiscal);
		return list();
	}

	public String list() {
		return "list";
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public List<NotaFiscal> getNotasFiscais() {
		this.notasFiscais = notaFiscalBR.list();
		return this.notasFiscais;
	}

	public void setNotasFiscais(List<NotaFiscal> notasFiscais) {
		this.notasFiscais = notasFiscais;
	}

	
}
