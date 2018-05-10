package com.lcc.concurrent.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch描述的是一个线程等待多个线程执行的关系。
 * 适合场景如并行计算 需要各个task执行完成之后 才开始计算任务。
 * 例如A的前置操作B,C,D（多个线程上的） ，A需要他们完成后才能执行 就可以使用countdownlatch
 *
 * @author: lcc
 * @Date: 2018-05-09
 **/
@Slf4j
public class CountDownLatchExample {

	private final static int threadCount = 200;

	public static void main(String[] args) throws Exception {

		ExecutorService exec = Executors.newCachedThreadPool();

		final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

		for (int i = 0; i < threadCount; i++) {
			final int threadNum = i;
			exec.execute(() -> {
				try {
					test(threadNum);
				} catch (Exception e) {
					log.error("exception", e);
				} finally {
					countDownLatch.countDown();
				}
			});

		}
		countDownLatch.await();
		// countDownLatch.await(10, TimeUnit.MILLISECONDS);  设置等待时间
		log.debug("finish");
		exec.shutdown();
	}

	private static void test(int threadNum) throws Exception {
		Thread.sleep(100);
		log.debug("{}", threadNum);
		Thread.sleep(100);
	}
}
