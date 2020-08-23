package com.iqqcode.juc02;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-08 17:27
 * @Description:同步队列
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<> ();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "放入元素" + "1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName() + "放入元素" + "2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName() + "放入元素" + "3");
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "-->>" + queue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "-->>" + queue.take());
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName() + "-->>" + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程2").start();
    }
}
