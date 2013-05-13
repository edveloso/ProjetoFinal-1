package br.unigranrio.dao.impl;

import java.util.List;

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
		Query query = session.createSQLQuery("select * from passo where fluxo_id=:id")
				.addEntity(Passo.class)
				.setParameter("id", id);
		return query.list();
	}
	
}
