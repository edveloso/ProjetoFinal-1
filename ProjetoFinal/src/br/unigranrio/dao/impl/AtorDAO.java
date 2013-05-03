package br.unigranrio.dao.impl;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.dao.AbstractHibernateDAO;

@SuppressWarnings("rawtypes")
public class AtorDAO extends AbstractHibernateDAO{
	
	@SuppressWarnings("unchecked")
	public AtorDAO() {
		super(Ator.class);
	}


}
