package br.unigranrio.dao.impl;

import br.unigranrio.bean.requisito.Projeto;
import br.unigranrio.dao.AbstractHibernateDAO;

@SuppressWarnings("rawtypes")
public class ProjetoDAO extends AbstractHibernateDAO{

	@SuppressWarnings("unchecked")
	public ProjetoDAO() {
		super(Projeto.class);
	}

}
