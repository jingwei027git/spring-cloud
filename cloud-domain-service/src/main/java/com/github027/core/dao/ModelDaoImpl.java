package com.github027.core.dao;

import java.io.Serializable;

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
public abstract class ModelDaoImpl<T, ID extends Serializable> implements ModelDao<T, ID> {

	@Getter
	@PersistenceContext
	protected EntityManager entityManager;

}
