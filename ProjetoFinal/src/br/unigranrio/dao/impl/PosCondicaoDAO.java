package br.unigranrio.dao.impl;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.dao.AbstractHibernateDAO;

@SuppressWarnings("rawtypes")
public class PosCondicaoDAO extends AbstractHibernateDAO{
	
	@SuppressWarnings("unchecked")
	public PosCondicaoDAO() {
		super(Ator.class);
	}


}
