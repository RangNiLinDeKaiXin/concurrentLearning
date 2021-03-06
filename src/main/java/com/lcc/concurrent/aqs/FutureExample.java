package com.lcc.concurrent.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 执行多个耗时操作可以使用该模式
 * Callable 有返回值 runnabel 没有返回值
 *
 * @author: lcc
 * @Date: 2018-05-09
 **/
@Slf4j
public class FutureExample {

	static class MyCallable implements Callable<String> {

		@Override
		public String call() throws Exception {
			log.info("do something in callable");
			Thread.sleep(5000);
			return "Done";
		}
	}

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newCachedThreadPool();
		//future模式
		Future<String> future = executorService.submit(new MyCallable());
		log.info("do something in main");
		Thread.sleep(1000);
		String result = future.get();
		log.info("result：{}", result);
	}
}
