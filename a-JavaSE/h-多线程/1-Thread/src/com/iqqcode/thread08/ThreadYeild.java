package com.iqqcode.thread08;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-27 23:11
 * @Description:yiled---线程让步
 */
class TYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "<--结束执行");
    }
}

public class ThreadYeild {
    public static void main(String[] args) {
        TYield ty = new TYield();
        new Thread(ty,"A线程").start();
        new Thread(ty,"B线程").start();
    }
}
