package com.github027.app.amqp.smoking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github027.app.amqp.core.service.AmqpProducer;
import com.github027.domain.consts.AmqpConst;
import com.github027.domain.enums.Character;
import com.github027.util._Sys;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpSmokingTest {

	@Autowired
	AmqpProducer amqqpProducer;

	@Test
	public void testSendAndReceive() {
		SmokingAmqpDto dto = new SmokingAmqpDto(Character.TESTING.toString());
		dto.setMessage("Smoking test at " + _Sys.now());

		amqqpProducer.send(AmqpConst.Category.SMOKING, dto);
		log.info("send message {} to {}", dto, AmqpConst.Category.SMOKING.getExchange());

		_Sys.sleepSeconds(10);
	}

}
