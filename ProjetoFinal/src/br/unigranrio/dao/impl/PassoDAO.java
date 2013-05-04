package br.unigranrio.dao.impl;

import br.unigranrio.bean.requisito.Passo;
import br.unigranrio.dao.AbstractHibernateDAO;

@SuppressWarnings("rawtypes")
public class PassoDAO extends AbstractHibernateDAO{
	
	@SuppressWarnings("unchecked")
	public PassoDAO() {
		super(Passo.class);
	}


}
