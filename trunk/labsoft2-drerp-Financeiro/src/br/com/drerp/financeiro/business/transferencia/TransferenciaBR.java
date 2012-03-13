package br.com.drerp.financeiro.business.transferencia;

import java.util.List;

import br.com.crud.util.DAOFactory;
import br.com.drerp.financeiro.dao.transferencia.TransferenciaDAO;
import br.com.drerp.financeiro.model.transferencia.Transferencia;

public class TransferenciaBR {
	private TransferenciaDAO transferenciaDAO;

	public TransferenciaBR() {
		super();
		transferenciaDAO = DAOFactory.createTransferenciaDAO();
	}
	
	public Transferencia getById(Long id){
		return transferenciaDAO.getById(id);
	}
	
	public void save(Transferencia transferencia){
		Long id = transferencia.getId();
		if(id== 0 || id == null){
			transferenciaDAO.save(transferencia);
		}
		else{
			transferenciaDAO.alter(transferencia);
		}
	}
	
	public void delete(Transferencia transferencia){
		transferenciaDAO.delete(transferencia);
	}
	
	public List<Transferencia> list(){
		return transferenciaDAO.list();
	}
}
