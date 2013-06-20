package br.unigranrio.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.CasoDeUsoAtor;
import br.unigranrio.dao.AbstractHibernateDAO;
import br.unigranrio.dao.HibernateUtil;

@SuppressWarnings("rawtypes")
public class CasoDeUsoAtorDAO extends AbstractHibernateDAO{
	
	private Session session = HibernateUtil.getSession();
	
	@SuppressWarnings("unchecked")
	public CasoDeUsoAtorDAO() {
		super(CasoDeUsoAtor.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<CasoDeUsoAtor> selecionaTodosPorCasoDeUso(long id){
		Query query = session.createSQLQuery("select * from casoDeUsoAtor where casoDeUso_id=:id")
				.addEntity(CasoDeUsoAtor.class)
				.setParameter("id", id);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Ator> selecionaTodosPorAtor(long id){
		Query query = session.createSQLQuery("select * from casoDeUsoAtor where ator_id=:id")
				.addEntity(CasoDeUsoAtor.class)
				.setParameter("id", id);
		return query.list();
	}

	public void merge(CasoDeUsoAtor casoAtor){
		try {
			if(session == null)
				session = HibernateUtil.getSession();
			session.beginTransaction();
			session.merge(casoAtor);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
}
