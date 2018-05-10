package com.lcc.concurrent.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier 实现多个线程之间相互等待 当所有线程都准备好后 才开始一起执行，可重复使用。
 * 例如跑步，所有选手准备好之后等待枪声后同时起跑
 *
 * @author: lcc
 * @Date: 2018-05-09
 **/
@Slf4j
public class CyclicBarrierExample {

	private static CyclicBarrier barrier = new CyclicBarrier(5);

	private static CyclicBarrier barrier2 = new CyclicBarrier(5, () -> {
		log.info("callback is running");
	});
	public static void main(String[] args) throws Exception {

		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < 10; i++) {
			final int threadNum = i;
			Thread.sleep(1000);
			executor.execute(() -> {
				try {
					race(threadNum);
				} catch (Exception e) {
					log.error("exception", e);
				}
			});
		}
		executor.shutdown();
	}

	private static void race(int threadNum) throws Exception {
		Thread.sleep(1000);
		log.info("{} is ready", threadNum);
		barrier.await();
		//barrier.await(2000, TimeUnit.MILLISECONDS);
		log.info("{} continue", threadNum);
	}
}
