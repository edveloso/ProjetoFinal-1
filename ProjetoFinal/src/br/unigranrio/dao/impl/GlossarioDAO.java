package br.unigranrio.dao.impl;

import br.unigranrio.bean.requisito.Glossario;
import br.unigranrio.dao.AbstractHibernateDAO;

@SuppressWarnings("rawtypes")
public class GlossarioDAO extends AbstractHibernateDAO {

	@SuppressWarnings("unchecked")
	public GlossarioDAO() {
		super(Glossario.class);
	}

}
