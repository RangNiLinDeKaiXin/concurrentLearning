package com.lcc.concurrent.commonUnsafe;

import com.lcc.concurrent.annoations.NotThreadSafe;
import com.lcc.concurrent.commonUnsafe.util.ExecutorsTemplate;
import com.lcc.concurrent.commonUnsafe.util.RealMethod;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Slf4j
@NotThreadSafe
public class HashMapExample implements RealMethod<Integer> {


	private static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		HashMapExample h = new HashMapExample();
		ExecutorsTemplate executorsTemplate = new ExecutorsTemplate();
		executorsTemplate.execute(map, h);
	}


	@Override
	public void update(Integer i) {
		map.put(i, i);
	}
}
