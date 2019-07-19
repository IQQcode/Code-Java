package com.Synchronized;

/**
 * synchronized说明：
 *
 * 1.synchronized(this) { } 锁同一个对象;
 *
 * 2.synchronized(sync.class) { } 全局锁，锁类对应的Class对象;
 *
 * 3. ststic synchronized相当于全局锁;
 */

class Sync {
    public  static synchronized void test() {
        System.out.println("test()方法开始，当前线程为： " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test()方法结束，当前线程为： " + Thread.currentThread().getName());
    }
}
class MythreaB implements Runnable {
    @Override
    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}

public class Synchronized_B {
    public static void main(String[] args) {
            MythreaB mythreaB = new MythreaB();
            new Thread(mythreaB,"黄牛A").start();
            new Thread(mythreaB,"黄牛B").start();
            new Thread(mythreaB,"黄牛C").start();
    }
}
