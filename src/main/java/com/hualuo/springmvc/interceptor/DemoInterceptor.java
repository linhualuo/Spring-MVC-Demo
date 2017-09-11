package com.hualuo.springmvc.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Joseph 
 *
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {
	
	private static final String START_TIME = "startTime";
	private static final String HANDLING_TIME = "handlingTime";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		request.setAttribute(START_TIME, startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		long startTime = (Long) request.getAttribute(START_TIME);
		request.removeAttribute(START_TIME);
		long endTime = System.currentTimeMillis();
		long handlingTime = endTime - startTime;
		System.out.println("handle time is: " + handlingTime + "ms");
		request.setAttribute(HANDLING_TIME, handlingTime);
	}

	
}
