package com.lcc.concurrent.commonUnsafe;

import com.lcc.concurrent.annoations.ThreadSafe;
import com.lcc.concurrent.util.ExecutorsTemplate;
import com.lcc.concurrent.util.RealMethod;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: lcc
 * @Date: 2018-05-08
 **/
@Slf4j
@ThreadSafe
public class StringBufferExample implements RealMethod<Integer> {

	//synchronized
	public static StringBuffer stringBuffer = new StringBuffer();

	public static void main(String[] args) throws Exception {
		StringBufferExample stringBufferExample = new StringBufferExample();
		ExecutorsTemplate executorsTemplate = new ExecutorsTemplate();
		executorsTemplate.executeCollection(stringBuffer, stringBufferExample);
	}

	@Override
	public void update(Integer integer) {
		stringBuffer.append("1");
	}
}
