package com.github027.core.service;

import java.io.Serializable;

import com.github027.core.dao.ModelDao;

/**
 * Model DAO (wrapper Spring JPA)
 *
 * @param <T>
 * @param <ID>
 */
public interface ModelService<T, ID extends Serializable> {

	public ModelDao<T, ID> getDao();

	/**
	 * @see org.springframework.data.repository.CrudRepository.save(S)
	 */
	public <S extends T> S save(S entity);

	/**
	 * @see org.springframework.data.repository.CrudRepository.save(Iterable<S>)
	 */
	public <S extends T> Iterable<S> save(Iterable<S> entities);

	/**
	 * @see org.springframework.data.repository.CrudRepository.findOne(ID)
	 */
	public T findOne(ID id);

	/**
	 * @see org.springframework.data.repository.CrudRepository.exists(ID)
	 */
	public boolean exists(ID id);

	/**
	 * @see org.springframework.data.repository.CrudRepository.findAll()
	 */
	public Iterable<T> findAll(Iterable<ID> ids);

	/**
	 * @see org.springframework.data.repository.CrudRepository.delete(ID)
	 */
	public void delete(ID id);

	/**
	 * @see org.springframework.data.repository.CrudRepository.delete(T)
	 */
	public void delete(T entity);

	/**
	 * @see org.springframework.data.repository.CrudRepository.delete(Iterable<? extends T>)
	 */
	public void delete(Iterable<? extends T> entities);

	/**
	 * @see org.springframework.data.jpa.repository.JpaRepository.deleteInBatch(Iterable<T>)
	 */
	public void deleteInBatch(Iterable<T> entities);

}
