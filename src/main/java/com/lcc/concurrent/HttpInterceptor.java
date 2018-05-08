package com.lcc.concurrent;

import com.lcc.concurrent.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        log.info("preHandle");
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		//移除ThreadLocal数据
		RequestHolder.remove();
//        log.info("afterCompletion");
		return;
	}
}
