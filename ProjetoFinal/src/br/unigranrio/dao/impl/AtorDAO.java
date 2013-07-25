package br.unigranrio.dao.impl;

import java.util.List; 

import org.hibernate.Query;
import org.hibernate.Session;

import br.unigranrio.bean.requisito.Ator;
import br.unigranrio.bean.requisito.CasoDeUsoAtor;
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
	
	@SuppressWarnings("unchecked")
	public List<Ator> retornaPorProjeto(long id){
		Query query = session.createSQLQuery("select * from ator where projeto_id=:id")
				.addEntity(Ator.class)
				.setParameter("id", id);
		return query.list();
	}
	
	public CasoDeUsoAtor retornaPorPasso(long id, long idProjeto){
		Query query = session.createSQLQuery("select ca.* from passo p, casoDeUsoAtor ca, ator a where p.ator = a.nome and a.ator_id = ca.ator_id and p.idFluxo=:id and a.projeto_id=:idProjeto order by p.id desc limit 0,1")
				.addEntity(CasoDeUsoAtor.class)
				.setParameter("id", id)
				.setParameter("idProjeto", idProjeto);
		return (CasoDeUsoAtor) query.uniqueResult();
	}

}
