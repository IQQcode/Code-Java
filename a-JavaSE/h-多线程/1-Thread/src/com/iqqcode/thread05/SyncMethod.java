package com.iqqcode.thread05;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-26 16:36
 * @Description:同步方法
 */

class Web1230 implements Runnable {

    private int tickets = 20;

    @Override
    public void run() {
        while (tickets > 0) {
            this.sale();
        }
    }

    //此处通过同步方法加上锁
    public synchronized void sale() {
        //this表示当前对象
        synchronized (this) {
            //在此同步代方法中，只有一个线程在跑
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

public class SyncMethod {
    public static void main(String[] args) {
        Web1230 run = new Web1230();
        new Thread(run,"线程A").start();
        new Thread(run,"线程B").start();
        new Thread(run,"线程C").start();
    }
}
