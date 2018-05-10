package com.lcc.concurrent.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量 控制资源被同时访问的线程数
 *
 * @author: lcc
 * @Date: 2018-05-09
 **/
@Slf4j
public class SemaphoreExample {

    private final static int threadCount = 20;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    //每个线程进来 获取一个许可，执行完后释放一个许可，总共3个许可  同时执行的线程最多就3个
                    semaphore.acquire(); // 获取一个许可
                    test(threadNum);
                    semaphore.release(); // 释放一个许可

//                   // 可以一次获取多个许可  例如每次获取3个许可 总共就3个许可，意味同时执行的线程 就只有 1个  （总共许可数/一次获取许可数）
//                    semaphore.acquire(3);
//                    test(threadNum);
//                    semaphore.release(3);

//               //  尝试获取许可，如果有 那么就执行 没有就丢弃不执行
//                    if (semaphore.tryAcquire()) {    semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS) 可以在5秒内能获取许可，获取就执行，获取不了就放弃
//                        test(threadNum);
//                        semaphore.release();
//                    }
                } catch (Exception e) {
                    log.error("exception", e);
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
        log.info("{}", threadNum);
        Thread.sleep(1000);
    }
}
