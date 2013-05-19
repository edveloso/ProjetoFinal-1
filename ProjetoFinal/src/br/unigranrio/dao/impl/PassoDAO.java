package br.unigranrio.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.unigranrio.bean.requisito.Passo;
import br.unigranrio.dao.AbstractHibernateDAO;
import br.unigranrio.dao.HibernateUtil;

@SuppressWarnings("rawtypes")
public class PassoDAO extends AbstractHibernateDAO{
	
	Session session = HibernateUtil.getSession();
	
	@SuppressWarnings("unchecked")
	public PassoDAO() {
		super(Passo.class);
	}

	@SuppressWarnings("unchecked")
	public List<Passo> retornaPorFluxo(long id){
		Query query = session.createSQLQuery("select * from passo where idFluxo=:id")
				.addEntity(Passo.class)
				.setParameter("id", id);
		return query.list();
	}
	
	public void merge(Passo passo){
		try {
			if(session == null)
				session = HibernateUtil.getSession();
			session.beginTransaction();
			session.merge(passo);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
}
