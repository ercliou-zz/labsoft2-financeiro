package br.com.drerp.financeiro.business.transferencia;
import br.com.drerp.financeiro.business.GenericBR;
import br.com.drerp.financeiro.dao.transferencia.PagadorDAOImpl;
import br.com.drerp.financeiro.model.transferencia.Pagador;

public class PagadorBR extends GenericBR<PagadorDAOImpl, Pagador> {
	
	public Pagador getClinica() {
		return this.dao.getClinica();
	}

	public Pagador salvar(Pagador pagador) {
		return this.dao.salvar(pagador);
	}
}
