package br.com.drerp.financeiro.dao.transferencia;

import java.util.List;

import org.hibernate.Session;

import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class TransferenciaDAOImpl implements TransferenciaDAO{

private Session session;
	
	public void setSession(Session s){
		session = s;
	}
	
	public void save(Transferencia entidade) {
		session.save(entidade);
		
	}

	public void delete(Transferencia entidade) {
		session.delete(entidade);
	}

	public void alter(Transferencia entidade) {
		session.update(entidade);
	}

	public Transferencia getById(Long id) {
		return (Transferencia) session.get(Transferencia.class,id);
	}

	@SuppressWarnings("unchecked")
	public List<Transferencia> list() {
		List<Transferencia> list = session.createCriteria(Transferencia.class).list();
		return list;
	}
	
}
