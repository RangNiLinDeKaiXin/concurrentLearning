package com.lcc.concurrent.immutable;

import com.google.common.collect.Maps;
import com.lcc.concurrent.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Slf4j
@NotThreadSafe
public class FinalUse {
	//final 修饰基本数据类型时值不可变，修饰引用类型时，引用不可变
	private final static Integer a = 1;
	private final static Map<Integer, Integer> map = Maps.newHashMap();
	private final static String b = "2";

	static {
		map.put(1, 2);
		map.put(3, 4);
		map.put(5, 6);
	}

	public static void main(String[] args) {
//        a = 2;  //修饰基本类型，不能改变值
//        b = "3"; //修饰基本类型，不能改变值
//        map = Maps.newHashMap(); //修饰的map不能改变对象引用
		map.put(1, 3); //虽然map被final修饰 但是 还是可以修改map 的值

//		log.info("{}", map.get(1));
		int[] nums ={1,2,3,4};
		int a =IntStream.of(nums).sum();
		System.out.println(a);
	}

	//修饰参数，基本数据类型时值不可变，引用类型时，引用不可变
	private void test(final int a) {
//        a = 1;
	}


}


