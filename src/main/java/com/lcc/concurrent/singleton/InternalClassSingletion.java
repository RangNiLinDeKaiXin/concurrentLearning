package com.lcc.concurrent.singleton;

import com.lcc.concurrent.annoations.Recommend;
import com.lcc.concurrent.annoations.ThreadSafe;

/**
 * 内部类 天然的线程安全（jvm）
 *
 * @author: lcc
 * @Date: 2018-05-11
 **/
@ThreadSafe
@Recommend
public class InternalClassSingletion {

	private static class InnerSingletion {

		private static InternalClassSingletion single = new InternalClassSingletion();
	}

	public static InternalClassSingletion getInstance() {
		return InnerSingletion.single;
	}

}
