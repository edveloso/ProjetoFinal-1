package br.unigranrio.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.unigranrio.bean.requisito.PosCondicao;
import br.unigranrio.dao.AbstractHibernateDAO;
import br.unigranrio.dao.HibernateUtil;

@SuppressWarnings("rawtypes")
public class PosCondicaoDAO extends AbstractHibernateDAO{
	
	Session session = HibernateUtil.getSession();
	
	@SuppressWarnings("unchecked")
	public PosCondicaoDAO() {
		super(PosCondicao.class);
	}

	@SuppressWarnings("unchecked")
	public List<PosCondicao> selecionaTodosPorCasoDeUso(long id){
		Query query = session.createSQLQuery("select * from poscondicao where casoDeUso_casoDeUso_id=:id")
				.addEntity(PosCondicao.class)
				.setParameter("id", id);
		return query.list();
	}

}
