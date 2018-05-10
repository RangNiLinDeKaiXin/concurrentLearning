package com.lcc.concurrent.syncContainer;

import com.lcc.concurrent.annoations.NotRecommend;
import com.lcc.concurrent.annoations.ThreadSafe;
import com.lcc.concurrent.util.ExecutorsTemplate;
import com.lcc.concurrent.util.RealMethod;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Slf4j
@ThreadSafe
@NotRecommend
public class HashTableExample implements RealMethod<Integer> {

	//这里注意Hashtable key val 不能为null ，使用 synchronized  效率低
	// 并发修改 存在问题 throw new ConcurrentModificationException()
	private static Map<Integer, Integer> map = new Hashtable<>();
	//同hashtable 一样
	private static List<Integer> list = new Vector<>();

	public static void main(String[] args) throws Exception {
        HashTableExample hashTableExample = new HashTableExample();
        ExecutorsTemplate executorsTemplate = new ExecutorsTemplate();
        executorsTemplate.executeCollection(map, hashTableExample);

	}

	private static void update(int i) {
		map.put(i, i);
	}

	@Override
	public void update(Integer i) {
		map.put(i, i);
	}
}
