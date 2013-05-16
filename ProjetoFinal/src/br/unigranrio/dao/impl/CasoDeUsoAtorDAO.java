package br.unigranrio.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

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
		Query query = session.createSQLQuery("select * from casodeusoator where casoDeUso_id=:id")
				.addEntity(CasoDeUsoAtor.class)
				.setParameter("id", id);
		return query.list();
	}


}
