package com.tracker.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class TrackerAbstractHibernateDAO<T extends Serializable> {

	private final Class<T> clazz;

	@Autowired
	SessionFactory trackerSessionFactory;

	public TrackerAbstractHibernateDAO(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@SuppressWarnings("unchecked")
	public T getById(final Integer id) {
		return (T) this.getCurrentSession().get(this.clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public T getByStringId(final String id) {
		return (T) this.getCurrentSession().get(this.clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return this.getCurrentSession()
				.createQuery("from " + this.clazz.getName()).list();
	}

	public void create(final T entity) {
		this.getCurrentSession().persist(entity);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public T save(final T entity) {
		this.getCurrentSession().save(entity);
		return entity;
	}

	public void update(final T entity) {
		this.getCurrentSession().merge(entity);
	}

	public void delete(final T entity) {
		this.getCurrentSession().delete(entity);
	}

	public void deleteById(final Integer entityId) {
		final T entity = this.getById(entityId);
		this.delete(entity);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.trackerSessionFactory = sessionFactory;
	}

	protected final Session getCurrentSession() {
		return this.trackerSessionFactory.getCurrentSession();
	}

}
