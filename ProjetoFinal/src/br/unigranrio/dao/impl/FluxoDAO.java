package br.unigranrio.dao.impl;

import br.unigranrio.bean.requisito.Fluxo;
import br.unigranrio.dao.AbstractHibernateDAO;

@SuppressWarnings("rawtypes")
public class FluxoDAO extends AbstractHibernateDAO{
	
	@SuppressWarnings("unchecked")
	public FluxoDAO() {
		super(Fluxo.class);
	}


}
