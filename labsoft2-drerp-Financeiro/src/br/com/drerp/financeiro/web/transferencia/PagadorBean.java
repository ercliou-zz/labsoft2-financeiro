package br.com.drerp.financeiro.web.transferencia;

import java.util.List;

import br.com.drerp.financeiro.business.transferencia.PagadorBR;
import br.com.drerp.financeiro.model.transferencia.Pagador;

public class PagadorBean {
	private Pagador pagador;
	private PagadorBR pagadorBR;
	private List<Pagador> pagadores;

	public PagadorBean() {
		this.pagador = new Pagador();
		this.pagadorBR = new PagadorBR();
	}

	public String edit() {
		return "edit";
	}

	public String view() {
		return "view";
	}

	public String create() {
		this.pagador = new Pagador();
		return edit();
	}

	public String save() {
		this.pagadorBR.save(this.pagador);
		return list();
	}

	public String delete() {
		this.pagadorBR.delete(this.pagador);
		return list();
	}

	public String list() {
		return "list";
	}

	public Pagador getPagador() {
		return pagador;
	}

	public void setPagador(Pagador pagador) {
		this.pagador = pagador;
	}

	public List<Pagador> getPagadores() {
		this.pagadores = (List<Pagador>) pagadorBR.list();
		return this.pagadores;
	}

	public void setPagadores(List<Pagador> pagadores) {
		this.pagadores = pagadores;
	}

}
