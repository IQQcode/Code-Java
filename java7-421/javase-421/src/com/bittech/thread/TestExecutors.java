package com.bittech.thread;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author: secondriver
 * Created: 2019/4/21
 */
public class TestExecutors {
    
    public static void main(String[] args) {

//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

//        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        ExecutorService executorService = Executors.newCachedThreadPool();
        
        ScheduledExecutorService scheduledService = Executors.newScheduledThreadPool(5);
        
        
        System.out.println(LocalDateTime.now());
//        scheduledService.schedule(
//                () -> System.out.println(Thread.currentThread().getName() + " " + LocalDateTime.now()),
//                10,
//                TimeUnit.SECONDS
//        );
        scheduledService.scheduleAtFixedRate(
                () -> System.out.println(" Fixed Rate :" + Thread.currentThread().getName() + " " + LocalDateTime.now()),
                0L,
                5L,
                TimeUnit.SECONDS
        );
        scheduledService.scheduleWithFixedDelay(
                () -> System.out.println(" Fixed Delay :" + Thread.currentThread().getName() + " " + LocalDateTime.now()),
                0L,
                5L,
                TimeUnit.SECONDS
        );
    }
}
