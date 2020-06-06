package com.iqqcode.juc02;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-06 12:18
 * @Description:八锁问题一--谁先执行
 */
class Lock1 {
    public synchronized void send() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1-send message");
    }

    public synchronized void call() {
        System.out.println("2-call phone");
    }
}

public class Sync01 {
    public static void main(String[] args) throws InterruptedException {
        Lock1 lock1 = new Lock1();
        Lock1 lock2 = new Lock1();


        new Thread(() -> {
            lock1.send();
        },"线程A").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            lock2.call();
        },"线程B").start();
    }
}
