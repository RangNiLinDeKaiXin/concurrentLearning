package com.lcc.concurrent.syncContainer;

import com.lcc.concurrent.annoations.NotRecommend;
import com.lcc.concurrent.annoations.ThreadSafe;
import com.lcc.concurrent.util.ExecutorsTemplate;
import com.lcc.concurrent.util.RealMethod;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lcc
 * @Date: 2018-05-08
 **/
@ThreadSafe
@NotRecommend
public class CollectionsDeal implements RealMethod<Integer> {
	//Collections.synchronize 无非在原先容器各个方法的基础上增加 synchronized 效率低
	// 并发修改 存在问题 throw new ConcurrentModificationException()
	private static Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());
//	private static Set<Integer> set = Collections.synchronizedSet(Sets.newHashSet());
//	private static List<Integer> list = Collections.synchronizedList(Lists.newArrayList());

	public static void main(String[] args) throws Exception {
		CollectionsDeal collectionsDeal = new CollectionsDeal();
		ExecutorsTemplate executorsTemplate = new ExecutorsTemplate();
		executorsTemplate.execute(map, collectionsDeal);
		//executorsTemplate.execute(set, collectionsDeal);
		//executorsTemplate.execute(list, collectionsDeal);
	}


	@Override
	public void update(Integer i) {
		map.put(i, i);
		//list.add(i);
		//set.add(i);
	}
}
