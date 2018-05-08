package com.lcc.concurrent.threadLocal;

/**
 * ThreadLocal 使用
 * @author: lcc
 * @Date: 2018-05-08
 **/
public class RequestHolder {
    //ThreadLocal 线程隔离
	private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();
    //当前台访问url接口前 在fitle中将id放入threadlocal中，在这个url实际处理中就可以重threadlocal中取到id
	public static void add(Long id) {
		requestHolder.set(id);
	}

	public static Long getId() {
		return requestHolder.get();
	}
    //在接口被处理完后利用拦截器清除ThreadLocal数据，防止溢出
	public static void remove() {
		requestHolder.remove();
	}
}
