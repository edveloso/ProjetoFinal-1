package br.unigranrio.dao.impl;

import java.util.List;

import org.hibernate.Session;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.dao.AbstractHibernateDAO;
import br.unigranrio.dao.HibernateUtil;

@SuppressWarnings("rawtypes")
public class AtorDAO extends AbstractHibernateDAO{
	
	private Session session = HibernateUtil.getSession();
	
	@SuppressWarnings("unchecked")
	public AtorDAO() {
		super(Ator.class);
	}

	public String retornaNomePorId(long id){
		return selecionaPorId(id).toString();
	}
	
	public List<Ator> retornaPorProjeto(long id){
		session.beginTransaction();
		session.createSQLQuery("select * from Ator where projeto_id="+id);
		
	}

}
