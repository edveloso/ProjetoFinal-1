package br.unigranrio.dao.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.unigranrio.bean.requisito.RegraDeNegocio;
import br.unigranrio.dao.AbstractHibernateDAO;
import br.unigranrio.dao.HibernateUtil;

@SuppressWarnings("rawtypes")
public class RegraDeNegocioDAO extends AbstractHibernateDAO{
	
	Session session = HibernateUtil.getSession();
	
	@SuppressWarnings("unchecked")
	public RegraDeNegocioDAO() {
		super(RegraDeNegocio.class);
	}

	@SuppressWarnings("unchecked")
	public List<RegraDeNegocio> selecionaTodosPorCasoDeUso(long id){
		Query query = session.createSQLQuery("select * from regraDeNegocio where casoDeUso_casoDeUso_id=:id")
				.addEntity(RegraDeNegocio.class)
				.setParameter("id", id);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RegraDeNegocio> selecionaTodosPorProjeto(long id){
		Query query = session.createSQLQuery("select * from regraDeNegocio where projeto_id=:id")
				.addEntity(RegraDeNegocio.class)
				.setParameter("id", id);
		return query.list();
	}
	
	public String countItensParaCodigo(long id){
		Query query = session.createSQLQuery("select count(*) from regraDeNegocio where projeto_id=:id").setParameter("id", id);
		return query.uniqueResult().toString();
	}

}
