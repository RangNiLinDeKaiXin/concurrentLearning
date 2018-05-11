package com.lcc.concurrent.singleton;

import com.lcc.concurrent.annoations.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 *
 * @author: lcc
 * @Date: 2018-05-11
 */
@NotThreadSafe
public class LazySingleton {

	// 私有构造函数
	private LazySingleton() {

	}

	// 单例对象
	private static LazySingleton instance = null;

	// 静态的工厂方法
	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
