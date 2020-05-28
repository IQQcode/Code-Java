package com.iqqcode.thread05;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-26 16:36
 * @Description:同步代码块
 */

class Web123 implements Runnable {
    //静态同步方法访问资源
    private static int tickets = 20;

    @Override
    public void run() {
        while (tickets > 0) {
            sale();
        }
    }

    private static void sale() {
        //此处通过静态同步方法上锁,锁的是类的class属性
        //访问的是类中的静态成员
        synchronized (Web123.class) {
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

public class SyncStaticMethod {
    public static void main(String[] args) {
        Web123 run = new Web123();
        new Thread(run,"线程A").start();
        new Thread(run,"线程B").start();
        new Thread(run,"线程C").start();
    }
}
