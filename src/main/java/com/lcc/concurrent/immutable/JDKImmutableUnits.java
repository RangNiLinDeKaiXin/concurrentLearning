package com.lcc.concurrent.immutable;

import com.google.common.collect.Maps;
import com.lcc.concurrent.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * jdk 自带不可变工具类 可以把set map list等变为不可变
 *
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Slf4j
@ThreadSafe
public class JDKImmutableUnits {
	private static Map<Integer, Integer> map = Maps.newHashMap();

	static {
		map.put(1, 2);
		map.put(3, 4);
		map.put(5, 6);
		map = Collections.unmodifiableMap(map); //被Collections.unmodifiableMap修饰后map不可改变
	}

	public static void main(String[] args) {
		map.put(1, 3); //所有修改 均会通过throw new UnsupportedOperationException() 来阻止
		//log.info("{}", map.get(1));
	}

}
