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

/**
 * @static 全局锁
 */
class Sync {
    //锁的是 Sync的对象
    public static synchronized void test() {
        System.out.println("test()方法开始，当前线程为： " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test()方法结束，当前线程为： " + Thread.currentThread().getName());
    }
}

class Mythread implements Runnable {
    @Override
    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}

public class Synchronized_A {
    public static void main(String[] args) {
            Mythread mythread = new Mythread();
            new Thread(mythread,"A").start();
            new Thread(mythread,"B").start();
            new Thread(mythread,"C").start();
    }
}
