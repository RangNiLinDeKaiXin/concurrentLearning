package com.lcc.concurrent.concurrent;

import com.lcc.concurrent.annoations.ThreadSafe;
import com.lcc.concurrent.util.ExecutorsTemplate;
import com.lcc.concurrent.util.RealMethod;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 分段锁，在hashtable上改进，每个段相当于一个小的hashtable最大支持16个段，
 * https://my.oschina.net/hosee/blog/675884 ConcurrentHashMap详解
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Slf4j
@ThreadSafe
public class ConcurrentHashMapExample implements RealMethod<Integer> {

	private static Map<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();

	//private static Set<Integer> set = new ConcurrentSkipListSet<>();
	//private static Map<Integer, Integer> concurrentSkipListMap = new ConcurrentSkipListMap<>();
	public static void main(String[] args) throws Exception {
		ConcurrentHashMapExample concurrentHashMapExample = new ConcurrentHashMapExample();
		ExecutorsTemplate executorsTemplate = new ExecutorsTemplate();
		executorsTemplate.executeCollection(concurrentHashMap, concurrentHashMapExample);
	}


	@Override
	public void update(Integer i) {
		concurrentHashMap.put(i, i);
	}
}
