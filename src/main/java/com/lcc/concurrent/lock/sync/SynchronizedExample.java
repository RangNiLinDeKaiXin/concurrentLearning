package com.lcc.concurrent.lock.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * jdk1.6之后对Synchronized进行优化引入自旋锁等
 *
 * @author: lcc
 * @Date: 2018-05-09
 **/
@Slf4j
public class SynchronizedExample {

	// 修饰一个代码块
	public void test1(int j) {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				log.info("test1 {} - {}", j, i);
			}
		}
	}

	// 修饰一个方法
	public synchronized void test2(int j) {
		for (int i = 0; i < 10; i++) {
			log.info("test2 {} - {}", j, i);
		}
	}

	// 修饰一个类
	public static void test3(int j) {
		synchronized (SynchronizedExample.class) {
			for (int i = 0; i < 10; i++) {
				log.info("test1 {} - {}", j, i);
			}
		}
	}

	// 修饰一个静态方法
	public static synchronized void test4(int j) {
		for (int i = 0; i < 10; i++) {
			log.info("test2 {} - {}", j, i);
		}
	}

	public static void main(String[] args) {
		SynchronizedExample example1 = new SynchronizedExample();
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(() -> {
			example1.test1(1);
		});

	}
}
