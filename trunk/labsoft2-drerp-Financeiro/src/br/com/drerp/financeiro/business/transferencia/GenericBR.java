package br.com.drerp.financeiro.business.transferencia;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import br.com.crud.util.GenericDAOFactory;
import br.com.drerp.financeiro.dao.GenericDAO;
import br.com.drerp.financeiro.model.transferencia.GenericModel;

public abstract class GenericBR<T extends GenericDAO<Y>, Y extends GenericModel> {

	private T dao;

	private Class<T> persistentClass;

	public GenericBR() {
		super();
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		this.dao = (T) new GenericDAOFactory<T>().createDAO(persistentClass);

	}

	public T getById(Long id) {
		return (T) this.dao.getById(id);
	}

	public List<Y> list() {
		return this.dao.list();
	}

	public void save(Y entidade) {
		Long id = entidade.getId();
		if (id == null || id.equals(0)) {
			dao.save(entidade);
		} else {
			dao.edit(entidade);
		}
	}

	public void delete(Y entidade) {
		dao.delete(entidade);
	}
}
