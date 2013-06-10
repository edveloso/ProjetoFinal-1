package br.unigranrio.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public abstract class AbstractHibernateDAO<T extends Serializable> {

	private final Class<T> clazz;
	private Session session;

	public AbstractHibernateDAO(final Class<T> clazzToSet) {
		this.session = HibernateUtil.getSession();
		this.clazz = clazzToSet;
	}

	@SuppressWarnings("unchecked")
	public T selecionaPorId(final Long id) {
		return (T) session.get(this.clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> retornarTodos() {
		return session.createQuery("from " + this.clazz.getName()).list();
	}

	public void gravar(final T entity) {
		try {
			if(session == null)
				session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void atualizar(final T entity) {
		try {
			session.beginTransaction();
			session.merge(entity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void remover(final T entity) {
		try {
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void removerPorId(final Long entityId) {
		try {
			final T entity = this.selecionaPorId(entityId);
			this.remover(entity);
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
	}
}
