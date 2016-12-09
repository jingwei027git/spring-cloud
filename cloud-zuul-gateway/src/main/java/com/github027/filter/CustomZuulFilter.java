package com.github027.filter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomZuulFilter extends ZuulFilter {
	
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		final RequestContext context = RequestContext.getCurrentContext();
		final HttpSession httpSession = context.getRequest().getSession();
		httpSession.setAttribute("redis", "great");
		
		context.addZuulRequestHeader("Cookie", "SESSION=" + httpSession.getId());
		log.info("HttpSession ID is {}", httpSession.getId());

        return null;
	}	

}
