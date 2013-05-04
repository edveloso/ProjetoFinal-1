package br.unigranrio.dao.impl;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.dao.AbstractHibernateDAO;

@SuppressWarnings("rawtypes")
public class PassoDAO extends AbstractHibernateDAO{
	
	@SuppressWarnings("unchecked")
	public PassoDAO() {
		super(Ator.class);
	}


}
