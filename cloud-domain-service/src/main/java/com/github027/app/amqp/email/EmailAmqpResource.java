package com.github027.app.amqp.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github027.app.amqp.core.service.AmqpProducer;
import com.github027.domain.consts.AmqpConst.Category;
import com.github027.domain.dao.SysQueueLogDao;
import com.github027.domain.enums.Character;
import com.github027.domain.model.SysQueueLog;
import com.github027.util._Sys;

@RequestMapping("/amqp/email")
@RestController
public class EmailAmqpResource {

	@Autowired
	AmqpProducer amqpProducer;

	@Autowired
	SysQueueLogDao sysQueueLogDao;

	@GetMapping("")
	public SysQueueLog doSend() {
		EmailAmqpDto dto = new EmailAmqpDto(Character.TESTING.toString());

		amqpProducer.send(Category.EMAIL, dto);

		System.out.println("***************11111111111111111");
		_Sys.sleepSeconds(3);
		System.out.println("***************22222222222222222");

		SysQueueLog sysQueueLog = null;
		if (dto.getSysQueueLogId() != null) {
			sysQueueLog = sysQueueLogDao.getJpa().findOne(dto.getSysQueueLogId());
		}

		return sysQueueLog;
	}

}
