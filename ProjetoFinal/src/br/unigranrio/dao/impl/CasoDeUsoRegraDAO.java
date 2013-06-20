package br.unigranrio.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.unigranrio.bean.requisito.CasoDeUsoAtor;
import br.unigranrio.bean.requisito.CasoDeUsoRegra;
import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.dao.AbstractHibernateDAO;
import br.unigranrio.dao.HibernateUtil;

@SuppressWarnings("rawtypes")
public class CasoDeUsoRegraDAO extends AbstractHibernateDAO{
	
	private Session session = HibernateUtil.getSession();
	
	@SuppressWarnings("unchecked")
	public CasoDeUsoRegraDAO() {
		super(CasoDeUsoRegra.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<CasoDeUsoRegra> selecionaTodosPorCasoDeUso(long id){
		Query query = session.createSQLQuery("select * from casoDeUsoRegra where casoDeUso_id=:id")
				.addEntity(CasoDeUsoRegra.class)
				.setParameter("id", id);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RegraDeNegocio> selecionaTodosPorRegra(long id){
		Query query = session.createSQLQuery("select * from casoDeUsoRegra where id=:id")
				.addEntity(CasoDeUsoRegra.class)
				.setParameter("id", id);
		return query.list();
	}

	public void merge(CasoDeUsoRegra casoRegra){
		try {
			if(session == null)
				session = HibernateUtil.getSession();
			session.beginTransaction();
			session.merge(casoRegra);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
	
}
