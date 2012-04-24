package br.com.drerp.financeiro.dao.transferencia;

import org.hibernate.criterion.Restrictions;

import br.com.drerp.financeiro.business.transferencia.PagadorBR;
import br.com.drerp.financeiro.dao.GenericDAOImpl;
import br.com.drerp.financeiro.model.transferencia.Pagador;
import br.com.drerp.financeiro.util.FinanceiroConstants;

public class PagadorDAOImpl extends GenericDAOImpl<Pagador> implements
		PagadorDAO {

	public Pagador getClinica() {
		Object pagador = this.session.createCriteria(Pagador.class)
		.add(Restrictions.eq("nome", FinanceiroConstants.NOME_CLINICA)).uniqueResult();
		if(pagador == null){ 
			Pagador clinica = new Pagador();
			clinica.setDocumento(FinanceiroConstants.NOME_CLINICA);
			clinica.setNome(FinanceiroConstants.NOME_CLINICA);
			clinica.getEndereco().setCep(FinanceiroConstants.CEP_CLINICA);
			clinica.getEndereco().setCidade(FinanceiroConstants.CIDADE_CLINICA);
			clinica.getEndereco().setEstado(FinanceiroConstants.ESTADO_CLINICA);
			clinica.getEndereco().setRua(FinanceiroConstants.ENDERECO_CLINICA);
			clinica.setInfoBancaria(FinanceiroConstants.AGENCIA_CLINICA_BRADESCO + " " + FinanceiroConstants.CONTA_CLINICA_BRADESCO);
			
			PagadorBR pagadorBR = new PagadorBR();
			pagadorBR.save(clinica);
			
			pagador = clinica;
		}
		return (Pagador) pagador ;
	}

	public Pagador salvar(Pagador pagador) {
		Pagador p = null;
		if (pagador.getDocumento() != null) {
			p = (Pagador) this.session.createCriteria(Pagador.class)
					.add(Restrictions.eq("documento", pagador.getDocumento()))
					.uniqueResult();
		}
		if (p == null) {
			this.session.save(pagador);
			this.session.flush();
		}
		return p;
	}

}
