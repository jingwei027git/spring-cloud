package com.github027.app.amqp.smoking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github027.core.amqp.AmqpProducer;
import com.github027.domain.dao.SysQueueLogDao;
import com.github027.domain.model.SysQueueLog;
import com.github027.domain.model.consts.AmqpConst.Category;
import com.github027.util._Sys;

@RequestMapping("/amqp/smoking")
@RestController
public class SmokingAmqpController {

	@Autowired
	AmqpProducer amqpProducer;

	@Autowired
	SysQueueLogDao sysQueueLogDao;

	@PostMapping("")
	public SysQueueLog doSend(@RequestBody SmokingAmqpDto dto) {
		dto.setUsername(_Sys.Username.TEST.toString());

		amqpProducer.send(Category.SMOKING, dto);

		_Sys.sleepSeconds(3);

		SysQueueLog sysQueueLog = null;
		if (dto.getSysQueueLogId() != null) {
			sysQueueLog = sysQueueLogDao.getJpa().findOne(dto.getSysQueueLogId());
		}

		return sysQueueLog;
	}

}
