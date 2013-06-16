package br.unigranrio.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.unigranrio.bean.requisito.CasoDeUsoRequisito;
import br.unigranrio.bean.requisito.RequisitoNaoFuncional;
import br.unigranrio.dao.AbstractHibernateDAO;
import br.unigranrio.dao.HibernateUtil;

@SuppressWarnings("rawtypes")
public class CasoDeUsoRequisitoDAO extends AbstractHibernateDAO{
	
	private Session session = HibernateUtil.getSession();
	
	@SuppressWarnings("unchecked")
	public CasoDeUsoRequisitoDAO() {
		super(CasoDeUsoRequisito.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<CasoDeUsoRequisito> selecionaTodosPorCasoDeUso(long id){
		Query query = session.createSQLQuery("select * from casodeusorequisito where casoDeUso_id=:id")
				.addEntity(CasoDeUsoRequisito.class)
				.setParameter("id", id);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RequisitoNaoFuncional> selecionaTodosPorRequisito(long id){
		Query query = session.createSQLQuery("select * from casodeusorequisito where requisito_id=:id")
				.addEntity(CasoDeUsoRequisito.class)
				.setParameter("id", id);
		return query.list();
	}

	public void merge(CasoDeUsoRequisito casoRequisito){
		try {
			if(session == null)
				session = HibernateUtil.getSession();
			session.beginTransaction();
			session.merge(casoRequisito);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
}
