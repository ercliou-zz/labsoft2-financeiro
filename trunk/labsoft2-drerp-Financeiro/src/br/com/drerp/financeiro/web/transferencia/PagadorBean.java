package br.com.drerp.financeiro.web.transferencia;

import java.util.List;

import br.com.drerp.financeiro.business.transferencia.PagadorBR;
import br.com.drerp.financeiro.model.transferencia.Pagador;

public class PagadorBean {
	private Pagador pagador;
	private PagadorBR pagadorBR;
	private List<Pagador> listaAprovada;

	public PagadorBean() {
		this.pagador = new Pagador();
		this.pagadorBR = new PagadorBR();
	}

	public Pagador getPagador() {
		return pagador;
	}

	public void setPagador(Pagador pagador) {
		this.pagador = pagador;
	}

	public List<Pagador> getListaAprovada() {
		this.listaAprovada = (List<Pagador>) pagadorBR.list();
		return listaAprovada;
	}
}
