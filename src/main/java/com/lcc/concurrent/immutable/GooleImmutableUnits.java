package com.lcc.concurrent.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.lcc.concurrent.annoations.ThreadSafe;

/**
 * google 不可变工具栏
 *
 * @author: lcc
 * @Date: 2018-05-08
 **/
@ThreadSafe
public class GooleImmutableUnits {
	private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);

	private final static ImmutableSet set = ImmutableSet.copyOf(list);

	private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);

	private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
			.put(1, 2).put(3, 4).put(5, 6).build();


	public static void main(String[] args) {
		//	map2.put()
		System.out.println(map2.get(3));
	}
}
