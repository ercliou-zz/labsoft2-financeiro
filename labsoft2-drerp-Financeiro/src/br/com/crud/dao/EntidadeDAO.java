package br.com.crud.dao;

import java.util.List;

import br.com.crud.model.Entidade;

public interface EntidadeDAO {
	public void save(Entidade entidade);
	public void delete(Entidade entidade);
	public void alter(Entidade entidade);
	public Entidade getById(Long id);
	public List<Entidade> list();
}
