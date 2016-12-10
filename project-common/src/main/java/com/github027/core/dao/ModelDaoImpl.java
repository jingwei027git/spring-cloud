package com.github027.core.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.Getter;

/**
 * Model DAO implements (implements wrapped JPA methods that needed in this
 * project).
 *
 * @param <T>
 * @param <ID>
 */
public abstract class ModelDaoImpl<T, ID extends Serializable> extends ModelDaoAbstract<T, ID> {

	@Getter
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void delete(final ID id) {
		getJpaRepository().delete(id);
	}

	@Override
	public void delete(final Iterable<? extends T> entities) {
		getJpaRepository().delete(entities);
	}

	@Override
	public void delete(T entity) {
		getJpaRepository().delete(entity);
	}

	@Override
	public void deleteInBatch(final Iterable<T> entities) {
		getJpaRepository().deleteInBatch(entities);
	}

	@Override
	public boolean exists(final ID id) {
		return getJpaRepository().exists(id);
	}

	@Override
	public List<T> findAll(final Iterable<ID> ids) {
		return getJpaRepository().findAll(ids);
	}

	@Override
	public T findOne(final ID id) {
		return getJpaRepository().findOne(id);
	}

	@Override
	public void flush() {
		getJpaRepository().flush();
	}

	@Override
	public <S extends T> List<S> save(final Iterable<S> entities) {
		return getJpaRepository().save(entities);
	}

	@Override
	public <S extends T> S save(final S entity) {
		return getJpaRepository().save(entity);
	}

}
