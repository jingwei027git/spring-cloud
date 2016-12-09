package com.github027;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * <b>@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)</b>
 * <br>
 * => redisFlushMode = IMMEDIATE is necessary to pass to cloud-web-action
 * <br>
 */
@EnableRedisHttpSession(redisFlushMode = RedisFlushMode.IMMEDIATE)
@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}
}
