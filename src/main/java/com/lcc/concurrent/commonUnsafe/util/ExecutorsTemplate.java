package com.lcc.concurrent.commonUnsafe.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 线程执行模版
 *
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Slf4j
public class ExecutorsTemplate<T> {
	// 请求总数
	public static int clientTotal = 5000;

	// 同时并发执行的线程数
	public static int threadTotal = 200;


	public void execute(T t, RealMethod realMethod) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		final Semaphore semaphore = new Semaphore(threadTotal);
		final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
		for (int i = 0; i < clientTotal; i++) {
			final int count = i;
			executorService.execute(() -> {
				try {
					semaphore.acquire();
					realMethod.update(count);
					semaphore.release();
				} catch (Exception e) {

				}
				countDownLatch.countDown();
			});
		}
		countDownLatch.await();
		executorService.shutdown();
		if (t instanceof Collection) {
			Collection collection = (Collection) t;
			log.debug("size:{}", collection.size());
		} else if (t instanceof CharSequence) {
			CharSequence charSequence = (CharSequence) t;
			log.debug("size:{}", charSequence.length());
		} else if (t instanceof Map) {
			Map map = (Map) t;
			log.debug("size:{}", map.size());
		}

	}

}
