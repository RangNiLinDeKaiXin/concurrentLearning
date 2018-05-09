package com.lcc.concurrent.commonUnsafe;

import com.lcc.concurrent.annoations.NotThreadSafe;
import com.lcc.concurrent.util.ExecutorsTemplate;
import com.lcc.concurrent.util.RealMethod;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Slf4j
@NotThreadSafe
public class ArrayListExample implements RealMethod<Integer> {


	private static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		ArrayListExample listExample = new ArrayListExample();
		ExecutorsTemplate executorsTemplate = new ExecutorsTemplate();
		executorsTemplate.execute(list, listExample);
	}


	@Override
	public void update(Integer i) {
		list.add(i);
	}
}
