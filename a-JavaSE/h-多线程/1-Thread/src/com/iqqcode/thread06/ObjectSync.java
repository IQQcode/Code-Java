package com.iqqcode.thread06;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-26 20:29
 * @Description:同步方法--对象锁
 */
class Sync implements Runnable{
    @Override
    public void run() {
        Sync sync = new Sync();
        sync.test();
    }

    //锁的是Sync的对象
    public synchronized void test() {
        System.out.println("test->开始，当前线程为： " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test-->>结束，当前线程为： " + Thread.currentThread().getName());
    }
}

public class ObjectSync {
    public static void main(String[] args) {
        Sync mythread = new Sync();
        new Thread(mythread,"A").start();
        new Thread(mythread,"B").start();
        new Thread(mythread,"C").start();
    }
}
