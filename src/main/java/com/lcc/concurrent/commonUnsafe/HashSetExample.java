package com.lcc.concurrent.commonUnsafe;

import com.lcc.concurrent.annoations.NotThreadSafe;
import com.lcc.concurrent.util.ExecutorsTemplate;
import com.lcc.concurrent.util.RealMethod;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
/**
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Slf4j
@NotThreadSafe
public class HashSetExample implements RealMethod<Integer> {

	private static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws Exception {
		HashSetExample h = new HashSetExample();
		ExecutorsTemplate executorsTemplate = new ExecutorsTemplate();
		executorsTemplate.executeCollection(set, h);
	}

	@Override
	public void update(Integer i) {
		set.add(i);
	}
}
