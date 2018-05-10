package com.lcc.concurrent.lock.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ConditionExample {

	public static void main(String[] args) {
		ReentrantLock reentrantLock = new ReentrantLock();
		Condition condition = reentrantLock.newCondition();

		new Thread(() -> {
			try {
				reentrantLock.lock();
				log.debug("wait signal"); // 1
				condition.await();    //从正常的aqs队列移除 加入condition队列
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			log.debug("get signal"); // 4
			reentrantLock.unlock();
		}).start();

		new Thread(() -> {
			reentrantLock.lock();
			log.debug("get lock"); // 2
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			condition.signalAll();
			log.debug("send signal ~ "); // 3
			reentrantLock.unlock();
		}).start();
	}
}
