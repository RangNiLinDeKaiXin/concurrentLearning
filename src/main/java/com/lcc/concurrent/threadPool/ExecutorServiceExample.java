package com.lcc.concurrent.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lcc
 * @Date: 2018-05-11
 **/
@Slf4j
public class ExecutorServiceExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
       // ExecutorService executorService = Executors.newCachedThreadPool();
        //ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("task:{}", index);
                }
            });
        }
        executorService.shutdown();
    }
}
