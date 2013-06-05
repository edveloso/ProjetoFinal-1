package br.unigranrio.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.unigranrio.bean.requisito.Fluxo;
import br.unigranrio.dao.AbstractHibernateDAO;
import br.unigranrio.dao.HibernateUtil;

@SuppressWarnings("rawtypes")
public class FluxoDAO extends AbstractHibernateDAO{
	
	Session session = HibernateUtil.getSession();
	
	@SuppressWarnings("unchecked")
	public FluxoDAO() {
		super(Fluxo.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Fluxo> retornaPorCaso(long id){
		Query query = session.createSQLQuery("select * from fluxo where casoDeUso_casoDeUso_id=:id")
				.addEntity(Fluxo.class)
				.setParameter("id", id);
		return query.list();
	}
	
	public String countItensParaCodigo(long id){
		Query query = session.createSQLQuery("select count(*) from fluxo where casoDeUso_casoDeUso_id=:id").setParameter("id", id);
		return query.uniqueResult().toString();
	}
}
