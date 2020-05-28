package com.iqqcode.thread09;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-28 09:25
 * @Description:线程的优先级
 * - 设置线程优先级: setPriority(int priority)`
 * - 获取优先级: int getPriority
 */
public class ThreadPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " -->> " + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        System.out.println("[" + Thread.currentThread().getName() + "] 优先级为 -> " + Thread.currentThread().getPriority());
        ThreadPriority tp = new ThreadPriority();
        Thread t1 = new Thread(tp);
        Thread t2 = new Thread(tp);
        Thread t3 = new Thread(tp);
        Thread t4 = new Thread(tp);
        Thread t5 = new Thread(tp);
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();

        t2.setPriority(3);
        t2.start();

        t3.setPriority(Thread.NORM_PRIORITY);
        t3.start();

        t4.setPriority(7);
        t4.start();

        t5.setPriority(Thread.MAX_PRIORITY);
        t5.start();
    }
}
