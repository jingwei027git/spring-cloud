package com.github027.core.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.github027.core.exception.NotSupportException;
import com.github027.core.jpa.ModelJpa;

/**
 * Model DAO (wrapper Spring JPA)
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface ModelDao<T, ID extends Serializable> extends JpaRepository<T, ID> {
	
	default public ModelJpa<T, ID> getJpaRepository() {
		throw new NotSupportException("jpa repository not assign");
	}

}
