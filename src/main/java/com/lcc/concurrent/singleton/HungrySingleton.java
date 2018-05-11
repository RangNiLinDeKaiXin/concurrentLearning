package com.lcc.concurrent.singleton;

import com.lcc.concurrent.annoations.ThreadSafe;


/**
 * 饿汉模式
 * 单例实例在类装载时进行创建
 *
 * @author: lcc
 * @Date: 2018-05-11
 **/
@ThreadSafe
public class HungrySingleton {

	// 私有构造函数
	private HungrySingleton() {

	}

	// 单例对象
	private static HungrySingleton instance = new HungrySingleton();

	// 静态的工厂方法
	public static HungrySingleton getInstance() {
		return instance;
	}
}
