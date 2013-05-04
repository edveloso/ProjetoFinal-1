package br.unigranrio.dao.impl;


import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.dao.AbstractHibernateDAO;

@SuppressWarnings("rawtypes")
public class RegraDeNegocioDAO extends AbstractHibernateDAO{
	
	@SuppressWarnings("unchecked")
	public RegraDeNegocioDAO() {
		super(RegraDeNegocio.class);
	}


}
