package com.github027.core.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * include {id}
 * <p>
 * <p>
 */
@Getter
@Setter
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class ModelBase implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
