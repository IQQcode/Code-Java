package com.Synchronized;

/**
 * 对象锁(monitor)机制---JDK6之前的synchronized(重量级锁)
 *
 * 写代码证明锁的可重入与互斥
 *
 *       ---synchronized修饰的 test1()方法中调用 test2()方法
 */

class MythreadReception implements Runnable {
    @Override
    public void run() {
        test1();
        test2();
    }

    public synchronized void test1() {
        if(Thread.currentThread().getName().equals("A")) {
            test2();
        }
    }
    public synchronized void test2()  {
        if(Thread.currentThread().getName().equals("B")) {
            System.out.println("B线程进入该同步方法test2()...");
        }else {
            System.out.println(Thread.currentThread().getName() + "线程--->进入test2()方法");
        }
    }
}

public class Synchronized_monitor {
    public static void main(String[] args) throws InterruptedException {
        MythreadReception mt = new MythreadReception();
        Thread threadA = new Thread(mt,"A");
        Thread threadB = new Thread(mt,"B");
        threadA.start();
        Thread.sleep(2000);  //有时间差，保证 A先启动
        threadB.start();
    }
}


