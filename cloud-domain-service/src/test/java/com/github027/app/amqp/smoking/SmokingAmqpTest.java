package com.github027.app.amqp.smoking;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github027.core.amqp.AmqpProducer;
import com.github027.domain.dao.SysQueueLogDao;
import com.github027.domain.model.SysQueueLog;
import com.github027.domain.model.consts.AmqpConst;
import com.github027.domain.model.enums.SysQueueLogStatus;
import com.github027.util._Sys;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokingAmqpTest {

	@Autowired
	AmqpProducer amqqpProducer;

	@Autowired
	SysQueueLogDao sysQueueLogDao;

	@Test
	public void testSendAndReceive() {
		SmokingAmqpDto dto = new SmokingAmqpDto();
		dto.setUsername(_Sys.Username.TEST.toString());
		dto.setMessage("Smoking test at " + _Sys.now());

		amqqpProducer.send(AmqpConst.Category.SMOKING, dto);
		log.info("send message {} to {}", dto, AmqpConst.Category.SMOKING.getExchange());

		_Sys.sleepSeconds(3);

		SysQueueLog sysQueueLog = null;
		if (dto.getSysQueueLogId() != null) {
			sysQueueLog = sysQueueLogDao.getJpa().findOne(dto.getSysQueueLogId());
		}

		Assert.assertNotNull(sysQueueLog);

		Assert.assertEquals(_Sys.Username.TEST.toString(), sysQueueLog.getCreateUser());
		Assert.assertNotNull(sysQueueLog.getCreateTime());
		Assert.assertEquals(_Sys.Username.TEST.toString(), sysQueueLog.getModifyUser());
		Assert.assertNotNull(sysQueueLog.getModifyTime());

		Assert.assertEquals(AmqpConst.Category.SMOKING, sysQueueLog.getCategory());
		Assert.assertNotNull(sysQueueLog.getSendTime());
		Assert.assertNotNull(sysQueueLog.getRecvTime());
		Assert.assertNotNull(sysQueueLog.getFinishTime());
		Assert.assertEquals(SysQueueLogStatus.S, sysQueueLog.getStatus());

		log.info("{}", sysQueueLog);
	}

}
