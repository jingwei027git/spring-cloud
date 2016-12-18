package com.github027.core.service;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class ModelServiceImpl<T, ID extends Serializable> implements ModelService<T, ID> {

	@Override
	public <S extends T> S save(S entity) {
		return getDao().getJpa().save(entity);
	}

	@Override
	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		return getDao().getJpa().save(entities);
	}

	@Override
	public T findOne(ID id) {
		return getDao().getJpa().findOne(id);
	}

	@Override
	public boolean exists(ID id) {
		return getDao().getJpa().exists(id);
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> ids) {
		return getDao().getJpa().findAll(ids);
	}

	@Override
	public void delete(ID id) {
		getDao().getJpa().delete(id);
	}

	@Override
	public void delete(T entity) {
		getDao().getJpa().delete(entity);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		getDao().getJpa().delete(entities);
	}

	@Override
	public void deleteInBatch(Iterable<T> entities) {
		getDao().getJpa().deleteInBatch(entities);
	}

}
