package com.lcc.concurrent.syncContainer;


import com.lcc.concurrent.annoations.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;

@NotThreadSafe
public class SyncCollectionThrow {

	private static Vector<Integer> vector = new Vector<>();

	public static void main(String[] args) {

		vectorThrow();
		foreachThorw();
		iteratorThorw();

	}

	/**
	 * 并发异常
	 * ArrayIndexOutOfBoundsException
	 */
	private static void vectorThrow() {
		int j = 1;
		while (j < 100) {

			for (int i = 0; i < 10; i++) {
				vector.add(i);
			}

			Thread thread1 = new Thread() {
				public void run() {
					for (int i = 0; i < vector.size(); i++) {  //remove例如执行到低9个 下面正好get第九个 就会发生异常
						vector.remove(i);
					}
				}
			};

			Thread thread2 = new Thread() {
				public void run() {
					for (int i = 0; i < vector.size(); i++) {
						vector.get(i);
					}
				}
			};
			thread1.start();
			thread2.start();
			j++;
		}
	}

//       if (modCount != expectedModCount)
//			throw new ConcurrentModificationException();
//       }
	//单线程 对集合进行foreach/iterator 循环时做增删操作会发送ConcurrentModificationException异常，使modCount != expectedModCount 多线程出现的概率就更大了

	private static  void foreachThorw() { // foreach
		Vector<Integer> v1 = new Vector<>();
		for (int i = 0; i < 10; i++) {
			v1.add(i);
		}
		for (Integer i : v1) {
			if (i.equals(3)) {
				v1.remove(i);
			}
		}
	}

	private static void iteratorThorw() { // iterator
		Vector<Integer> v1 = new Vector<>();
		for (int i = 0; i < 10; i++) {
			v1.add(i);
		}
		Iterator<Integer> iterator = v1.iterator();
		while (iterator.hasNext()) {
			Integer i = iterator.next();
			if (i.equals(3)) {
				v1.remove(i);
			}
		}
	}

}
