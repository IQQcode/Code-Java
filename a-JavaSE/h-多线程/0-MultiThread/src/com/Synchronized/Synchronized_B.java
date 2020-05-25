package com.Synchronized;


/**
 * @Author: Mr.Q
 * @Date: 2019-07-20 10:36
 * @Description:
 */

class SyncB {
    //锁的是 Sync的对象
    public synchronized void test() {
        System.out.println("test()方法开始，当前线程为： " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test()方法结束，当前线程为： " + Thread.currentThread().getName());
    }
}

class MythreadB implements Runnable {
    SyncB sync = new SyncB();
    @Override
    public void run() {
        sync.test();
    }
}

public class Synchronized_B {
    public static void main(String[] args) {
        MythreadB mythreadB = new MythreadB();
        new Thread(mythreadB,"A").start();
        new Thread(mythreadB,"B").start();
        new Thread(mythreadB,"C").start();
    }
}
