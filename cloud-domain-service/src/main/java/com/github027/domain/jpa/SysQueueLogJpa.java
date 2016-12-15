package com.github027.domain.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.github027.core.jpa.ModelJpa;
import com.github027.domain.enums.SysQueueLogCategory;
import com.github027.domain.model.SysQueueLog;

@Repository
public interface SysQueueLogJpa extends ModelJpa<SysQueueLog, Long> {

	public List<SysQueueLog> findByCategory(SysQueueLogCategory logCategory);

	public SysQueueLog findByUuid(String uuid);

}
