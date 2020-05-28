package com.iqqcode.thread06;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-26 20:29
 * @Description:静态同步方法--全局锁
 */
class WholeSync implements Runnable{
    @Override
    public void run() {
        WholeSync whole = new WholeSync();
        whole.test();
    }

    //锁的是Sync的对象
    public static synchronized void test() {
        System.out.println("test->开始，当前线程为： " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test-->>结束，当前线程为： " + Thread.currentThread().getName());
    }
}

public class ObjectWholeSync {
    public static void main(String[] args) {
        WholeSync run = new WholeSync();
        new Thread(run,"A").start();
        new Thread(run,"B").start();
        new Thread(run,"C").start();
    }
}
