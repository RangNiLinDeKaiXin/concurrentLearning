package com.lcc.concurrent.lock.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * ReentrantReadWriteLock 一个读锁,一个写锁
 * http://www.cnblogs.com/liang1101/p/6475555.html
 * 场景读取数据的操作次数通常高于写入数据的操作
 * 问题在多线程环境下，大多数情况是读的情况远远大于写的操作，因此可能导致写的饥饿问题
 * @author: lcc
 * @Date: 2018-05-09
 **/
@Slf4j
public class ReentrantReadWriteLockExample {

    private final Map<String, Data> map = new TreeMap<>();

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    public Data get(String key) {
        readLock.lock();     //获取读锁前提 没有其他线程的写锁，
        try {
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public Set<String> getAllKeys() {
        readLock.lock();
        try {
            return map.keySet();
        } finally {
            readLock.unlock();
        }
    }

    public Data put(String key, Data value) {
        writeLock.lock();  //获取写锁前提  没有其他线程的读锁 没有其他线程的写锁
        try {
            return map.put(key, value);
        } finally {
            readLock.unlock();
        }
    }

    class Data {

    }
}
