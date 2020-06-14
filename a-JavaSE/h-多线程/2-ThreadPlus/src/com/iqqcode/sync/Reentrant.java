package com.iqqcode.sync;

import java.util.ArrayList;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-30 17:56
 * @Description:可重入锁验证
 * synchronized修饰的test1方法中调用test2方法
 */
class Sync implements Runnable {
    @Override
    public void run() {
        test1();
        test2();
    }

    public synchronized void test1() {
        if (Thread.currentThread().getName().equals("A")) {
            test2();
        }
    }

    public synchronized void test2() {
        if (Thread.currentThread().getName().equals("B")) {
            System.out.println("B线程进入该同步方法test2()...");
        }else {
            //此时B线程还没有启动
            System.out.println(Thread.currentThread().getName() + "线程--->进入test2()方法");
        }
    }
}

public class Reentrant {
    public static void main(String[] args) throws InterruptedException {
        Sync run = new Sync();
        new Thread(run,"A").start();
        //有时间差，保证A先启动
        Thread.sleep(2000);
        new Thread(run,"B").start();
    }
}