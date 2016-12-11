package com.github027.core.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

import com.github027.core.exception.NotSupportException;

/**
 * Model DAO abstract layer
 * <p>
 * Disable methods that not support in this project.
 * <p>
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public abstract class ModelDaoAbstract<T, ID extends Serializable> implements ModelDao<T, ID> {

	@Override
	public final long count() {
		throw new NotSupportException();
	}

	@Override
	public final <S extends T> long count(final Example<S> example) {
		throw new NotSupportException();
	}

	@Override
	public final void deleteAll() {
		throw new NotSupportException();
	}

	@Override
	public final void deleteAllInBatch() {
		throw new NotSupportException();
	}

	@Override
	public final <S extends T> boolean exists(final Example<S> example) {
		throw new NotSupportException();
	}

	@Override
	public final List<T> findAll() {
		throw new NotSupportException();
	}

	@Override
	public final <S extends T> List<S> findAll(final Example<S> example) {
		throw new NotSupportException();
	}

	@Override
	public final <S extends T> Page<S> findAll(final Example<S> example, final Pageable pageable) {
		throw new NotSupportException();
	}

	@Override
	public final <S extends T> List<S> findAll(final Example<S> example, final Sort sort) {
		throw new NotSupportException();
	}

	@Override
	public final Page<T> findAll(final Pageable pageable) {
		throw new NotSupportException();
	}

	@Override
	public final List<T> findAll(final Sort sort) {
		throw new NotSupportException();
	}

	@Override
	public final <S extends T> S findOne(final Example<S> example) {
		throw new NotSupportException();
	}

	@Override
	public final T getOne(final ID id) {
		throw new NotSupportException();
	}

	@Override
	public final <S extends T> S saveAndFlush(final S entity) {
		throw new NotSupportException();
	}

}
