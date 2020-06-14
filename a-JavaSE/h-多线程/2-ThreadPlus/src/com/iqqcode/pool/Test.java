package com.iqqcode.pool;

import java.util.concurrent.*;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-08 23:17
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(2,
                5,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            for (int i = 1; i <= 10; i++) {
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " -->> OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
