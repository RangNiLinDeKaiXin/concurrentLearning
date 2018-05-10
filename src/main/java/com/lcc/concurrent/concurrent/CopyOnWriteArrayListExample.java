package com.lcc.concurrent.concurrent;

import com.lcc.concurrent.annoations.ThreadSafe;
import com.lcc.concurrent.util.ExecutorsTemplate;
import com.lcc.concurrent.util.RealMethod;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * cow 读写分离设计，保证最终一致性 高并发读性能非常好，在原有数组基础上copy一个新的容器进行写操作 写完把对象引用指向新容器 （写的时候加ReentrantLock锁）
 * 不适合频繁写（写的成本高），原数据比较多容易发生 full gc ，不能用于实时读场景（复制容器需要时间）
 *
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Slf4j
@ThreadSafe
public class CopyOnWriteArrayListExample implements RealMethod<Integer> {
	private static List<Integer> list = new CopyOnWriteArrayList<>();

//	private static Set<Integer> set = new CopyOnWriteArraySet<>();

	public static void main(String[] args) throws Exception {
		CopyOnWriteArrayListExample copyOnWriteArrayListExample = new CopyOnWriteArrayListExample();
		ExecutorsTemplate executorsTemplate = new ExecutorsTemplate();
		executorsTemplate.executeCollection(list, copyOnWriteArrayListExample);
	}


	@Override
	public void update(Integer i) {
		list.add(i);
	}
}
