package br.unigranrio.dao.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;

import br.unigranrio.bean.requisito.Glossario;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.dao.AbstractHibernateDAO;
import br.unigranrio.dao.HibernateUtil;

@SuppressWarnings("rawtypes")
public class GlossarioDAO extends AbstractHibernateDAO {
	
	Session session = HibernateUtil.getSession();

	@SuppressWarnings("unchecked")
	public GlossarioDAO() {
		super(Glossario.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Glossario> selecionaTodosPorProjeto(long id){
		Query query = session.createSQLQuery("select * from glossario where projeto_id=:id")
				.addEntity(Glossario.class)
				.setParameter("id", id);
		return query.list();
	}

}
