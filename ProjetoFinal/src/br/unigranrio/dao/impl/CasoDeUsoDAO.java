package br.unigranrio.dao.impl;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.dao.AbstractHibernateDAO;

@SuppressWarnings("rawtypes")
public class CasoDeUsoDAO extends AbstractHibernateDAO{
	
	@SuppressWarnings("unchecked")
	public CasoDeUsoDAO() {
		super(Ator.class);
	}


}
