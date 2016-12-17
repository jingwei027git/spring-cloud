package com.github027.domain.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github027.core.jpa.ModelJpa;
import com.github027.domain.model.SysQueueLog;

@Transactional
@Repository
public interface SysQueueLogJpa extends ModelJpa<SysQueueLog, Long> {

}
