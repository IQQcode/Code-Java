package com.iqqcode.pool;
import	java.util.concurrent.Executors;

import java.util.concurrent.ExecutorService;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-30 16:38
 * @Description:线程池基本使用
 */
class Sync implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "创建了，执行线程任务");
    }
}
public class ThreadPools {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        //创建一个线程执行任务
        es.submit(new Sync());
        es.submit(new Sync());
        //线程池会一直开启，使用完了线程，会自动把线程归还給线程池线程可以继续使用
        es.submit(new Sync());

        //调用ExecutorService中的shutdown方法销毁线程池（不建议执行）
        //es.shutdown();
    }
}
