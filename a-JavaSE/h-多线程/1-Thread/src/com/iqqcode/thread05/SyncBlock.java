package com.iqqcode.thread05;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-26 16:36
 * @Description:同步代码块
 */

class Web12306 implements Runnable {

    private int tickets = 20;

    @Override
    public void run() {
        while (tickets > 0) {
            //此处通过同步代码块加上锁
            //this表示当前对象
            synchronized (this) {
                //在此同步代码块中，只有一个线程在跑
                if (tickets >= 0) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        System.err.println("执行线程任务时出现了异常...");
                    }
                    System.out.println(Thread.currentThread().getName() + "还剩" + tickets-- + "张票");
                }
            }
        }
    }
}

public class SyncBlock {
    public static void main(String[] args) {
        Web12306 run = new Web12306();
        new Thread(run,"线程A").start();
        new Thread(run,"线程B").start();
        new Thread(run,"线程C").start();
    }
}
