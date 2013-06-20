package br.unigranrio.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.unigranrio.bean.requisito.PreCondicao;
import br.unigranrio.dao.AbstractHibernateDAO;
import br.unigranrio.dao.HibernateUtil;

@SuppressWarnings("rawtypes")
public class PreCondicaoDAO extends AbstractHibernateDAO{
	
	Session session = HibernateUtil.getSession();
	
	@SuppressWarnings("unchecked")
	public PreCondicaoDAO() {
		super(PreCondicao.class);
	}

	@SuppressWarnings("unchecked")
	public List<PreCondicao> selecionaTodosPorCasoDeUso(long id){
		Query query = session.createSQLQuery("select * from preCondicao where casoDeUso_casoDeUso_id=:id")
				.addEntity(PreCondicao.class)
				.setParameter("id", id);
		return query.list();
	}

}
