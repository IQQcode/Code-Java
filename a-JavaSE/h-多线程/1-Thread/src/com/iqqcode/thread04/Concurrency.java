package com.iqqcode.thread04;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-26 09:53
 * @Description:买票带来的并发问题
 */
class Web12306 implements Runnable{
    private int ticket = 20;

    @Override
    public void run() {
        while (ticket > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.err.println("执行线程任务时出现异常...");
            }
            System.out.println(Thread.currentThread().getName() + "还剩" + this.ticket-- +"张票");
        }
    }
}

public class Concurrency {
    public static void main(String[] args) {
        Web12306 run = new Web12306();
        new Thread(run,"黄牛A").start();
        new Thread(run,"黄牛B").start();
        new Thread(run,"黄牛C").start();
    }
}
