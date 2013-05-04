package br.unigranrio.dao.impl;

import br.unigranrio.bean.requisito.RequisitoNaoFuncional;
import br.unigranrio.dao.AbstractHibernateDAO;

@SuppressWarnings("rawtypes")
public class RequisitoNaoFuncionalDAO extends AbstractHibernateDAO{
	
	@SuppressWarnings("unchecked")
	public RequisitoNaoFuncionalDAO() {
		super(RequisitoNaoFuncional.class);
	}


}
