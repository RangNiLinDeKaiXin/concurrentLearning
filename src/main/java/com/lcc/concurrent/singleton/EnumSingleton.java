package com.lcc.concurrent.singleton;

import com.lcc.concurrent.annoations.Recommend;
import com.lcc.concurrent.annoations.ThreadSafe;


/**
 * 枚举模式：最安全
 *
 * @author: lcc
 * @Date: 2018-05-11
 **/
@ThreadSafe
@Recommend
public class EnumSingleton {

	// 私有构造函数
	private EnumSingleton() {

	}

	public static EnumSingleton getInstance() {
		return Singleton.INSTANCE.getInstance();
	}

	private enum Singleton {
		INSTANCE;

		private EnumSingleton singleton;

		// JVM保证这个方法绝对只调用一次
		Singleton() {
			singleton = new EnumSingleton();
		}

		public EnumSingleton getInstance() {
			return singleton;
		}
	}
}
