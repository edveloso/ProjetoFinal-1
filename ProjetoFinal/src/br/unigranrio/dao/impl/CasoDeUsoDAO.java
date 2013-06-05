package br.unigranrio.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.unigranrio.bean.requisito.CasoDeUso;
import br.unigranrio.dao.AbstractHibernateDAO;
import br.unigranrio.dao.HibernateUtil;

@SuppressWarnings("rawtypes")
public class CasoDeUsoDAO extends AbstractHibernateDAO{
	
	private Session session = HibernateUtil.getSession();
	
	@SuppressWarnings("unchecked")
	public CasoDeUsoDAO() {
		super(CasoDeUso.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<CasoDeUso> retornaPorProjeto(long id){
		Query query = session.createSQLQuery("select * from casodeuso where projeto_id=:id")
				.addEntity(CasoDeUso.class)
				.setParameter("id", id);
		return query.list();
	}

	public String countItensParaCodigo(long id){
		Query query = session.createSQLQuery("select count(*) from casodeuso where projeto_id=:id").setParameter("id", id);
		return query.uniqueResult().toString();
	}

}
