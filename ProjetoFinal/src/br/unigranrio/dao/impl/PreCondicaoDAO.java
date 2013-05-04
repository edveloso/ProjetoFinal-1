package br.unigranrio.dao.impl;

import br.unigranrio.bean.requisito.PreCondicao;
import br.unigranrio.dao.AbstractHibernateDAO;

@SuppressWarnings("rawtypes")
public class PreCondicaoDAO extends AbstractHibernateDAO{
	
	@SuppressWarnings("unchecked")
	public PreCondicaoDAO() {
		super(PreCondicao.class);
	}


}
