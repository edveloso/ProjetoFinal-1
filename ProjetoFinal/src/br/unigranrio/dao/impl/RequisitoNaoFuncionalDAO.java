package br.unigranrio.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.unigranrio.bean.requisito.RequisitoNaoFuncional;
import br.unigranrio.dao.AbstractHibernateDAO;
import br.unigranrio.dao.HibernateUtil;

@SuppressWarnings("rawtypes")
public class RequisitoNaoFuncionalDAO extends AbstractHibernateDAO{
	
	Session session = HibernateUtil.getSession();
	
	@SuppressWarnings("unchecked")
	public RequisitoNaoFuncionalDAO() {
		super(RequisitoNaoFuncional.class);
	}

	@SuppressWarnings("unchecked")
	public List<RequisitoNaoFuncional> selecionaTodosPorCasoDeUso(long id){
		Query query = session.createSQLQuery("select * from requisitonaofuncional where casoDeUso_casoDeUso_id=:id")
				.addEntity(RequisitoNaoFuncional.class)
				.setParameter("id", id);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RequisitoNaoFuncional> selecionaTodosPorProjeto(long id){
		Query query = session.createSQLQuery("select * from requisitoNaoFuncional where projeto_id=:id")
				.addEntity(RequisitoNaoFuncional.class)
				.setParameter("id", id);
		return query.list();
	}
	
	public String countItensParaCodigo(long id){
		Query query = session.createSQLQuery("select count(*) from requisitoNaoFuncional where projeto_id=:id").setParameter("id", id);
		return query.uniqueResult().toString();
	}

}
