package com.github027.core.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * Model with unique id
 * 
 */
@Getter
@Setter
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class ModelId implements Model {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

}
