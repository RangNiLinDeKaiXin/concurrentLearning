package com.lcc.concurrent;

import com.lcc.concurrent.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Slf4j
public class HttpFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
//        log.info("do filter, {}, {}", Thread.currentThread().getId(), request.getServletPath());
		//往ThreadLocal 放数据
		RequestHolder.add(Thread.currentThread().getId());
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {

	}
}
