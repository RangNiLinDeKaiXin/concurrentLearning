package com.lcc.concurrent.singleton;

import com.lcc.concurrent.annoations.ThreadSafe;


/**
 * 双重同步锁单例模式
 * 单例实例在第一次使用时进行创建
 *
 * @author: lcc
 * @Date: 2018-05-11
 **/
@ThreadSafe
public class DubbleSingleton {

	// 私有构造函数
	private DubbleSingleton() {

	}

	// 1、memory = allocate() 分配对象的内存空间
	// 2、ctorInstance() 初始化对象
	// 3、instance = memory 设置instance指向刚分配的内存

	// JVM和cpu优化，发生了指令重排

	// 1、memory = allocate() 分配对象的内存空间
	// 3、instance = memory 设置instance指向刚分配的内存
	// 2、ctorInstance() 初始化对象


	// 单例对象 volatile + 双重检测机制 -> 禁止指令重排
	private volatile static DubbleSingleton instance = null;

	// 静态的工厂方法
	public static DubbleSingleton getInstance() {
		if (instance == null) { // 双重检测机制        // B
			//模拟初始化对象的准备时间...
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (DubbleSingleton.class) { // 同步锁
				if (instance == null) {
					instance = new DubbleSingleton(); // A - 3
				}
			}
		}
		return instance;
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(DubbleSingleton.getInstance().hashCode());
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(DubbleSingleton.getInstance().hashCode());
			}
		}, "t2");
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(DubbleSingleton.getInstance().hashCode());
			}
		}, "t3");

		t1.start();
		t2.start();
		t3.start();
	}
}
