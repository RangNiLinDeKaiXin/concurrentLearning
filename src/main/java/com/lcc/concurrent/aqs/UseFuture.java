package com.lcc.concurrent.aqs;

import java.util.concurrent.Callable;

/**
 * @author: lcc
 * @Date: 2018-05-11
 **/
public class UseFuture implements Callable<String> {
	private String para;

	public UseFuture(String para) {
		this.para = para;
	}

	/**
	 * 这里是真实的业务逻辑，其执行可能很慢
	 */
	@Override
	public String call() throws Exception {
		//模拟执行耗时
		Thread.sleep(5000);
		String result = this.para + "处理完成";
		return result;
	}


}
