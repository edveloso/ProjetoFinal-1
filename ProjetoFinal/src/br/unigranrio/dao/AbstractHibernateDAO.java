package br.unigranrio.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractHibernateDAO<T extends Serializable> {

	private final Class<T> clazz;
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public AbstractHibernateDAO(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@SuppressWarnings("unchecked")
	public T selecionaPorId(final Long id) {
		return (T) this.getCurrentSession().get(this.clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> retornarTodos() {
		return this.getCurrentSession()
				.createQuery("from " + this.clazz.getName()).list();
	}

	public void gravar(final T entity) {
		this.getCurrentSession().persist(entity);
	}

	public void atualizar(final T entity) {
		this.getCurrentSession().merge(entity);
	}

	public void remover(final T entity) {
		this.getCurrentSession().delete(entity);
	}

	public void removerPorId(final Long entityId) {
		final T entity = this.selecionaPorId(entityId);
		this.remover(entity);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected final Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
}
