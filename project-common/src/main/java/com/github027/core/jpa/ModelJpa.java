package com.github027.core.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Model JPA
 *
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface ModelJpa<T, ID extends Serializable> extends JpaRepository<T, ID> {

}
