package com.lcc.concurrent.commonUnsafe;

import com.lcc.concurrent.annoations.NotThreadSafe;
import com.lcc.concurrent.util.ExecutorsTemplate;
import com.lcc.concurrent.util.RealMethod;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Slf4j
@NotThreadSafe
public class StringBuilderExample implements RealMethod<Integer> {

	public static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) throws Exception {
		StringBuilderExample stringBuilderExample = new StringBuilderExample();
		ExecutorsTemplate executorsTemplate = new ExecutorsTemplate();
		executorsTemplate.executeCollection(stringBuilder, stringBuilderExample);
	}

	@Override
	public void update(Integer integer) {
	}
}
