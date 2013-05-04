package br.unigranrio.dao.impl;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.dao.AbstractHibernateDAO;

@SuppressWarnings("rawtypes")
public class RequisitoNaoFuncionalDAO extends AbstractHibernateDAO{
	
	@SuppressWarnings("unchecked")
	public RequisitoNaoFuncionalDAO() {
		super(Ator.class);
	}


}
