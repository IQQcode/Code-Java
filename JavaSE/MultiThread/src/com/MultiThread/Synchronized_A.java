package com.MultiThread;

/**
 *同步问题
 */

/*class MythreadA implements Runnable {
    private Integer tickets = 10;

    @Override
    public void run() {
        while(tickets > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    "还有" + this.tickets-- + "张票");
        }
    }
}*/


/**
 *  synchronized()处理同步问题
 *
 *  实现这把"锁"的功能，可以采用关键字synchronized来处理
 *
 *  使用synchronized关键字处理有两种模式：同步代码块、同步方法
 */

//同步代码块

/*
class MythreadA implements Runnable {
    private Integer tickets = 10;

    @Override
    public void run() {
        while(tickets > 0) {
            synchronized (this) {
                if(tickets > 0) {

                    //在此同步代码块中，只有一个线程在跑
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +
                            "还有" + this.tickets-- + "张票");
                }
            }
        }
    }
}
*/

//同步方法

class MythreadA implements Runnable {
    private Integer tickets = 10;

    @Override
    public void run() {
        while(tickets > 0) {
            this.sale();
        }
    }
    //隐式锁对象this
    public synchronized void sale() {
        if(this.tickets > 0) {

            //在此同步代码块中，只有一个线程在跑
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    "还有" + this.tickets-- + "张票");
        }
    }
}


public class Synchronized_A {
    public static void main(String[] args) {
        MythreadA mythreadA = new MythreadA();
        Thread thread1 = new Thread(mythreadA,"黄牛A");
        Thread thread2 = new Thread(mythreadA,"黄牛B");
        Thread thread3 = new Thread(mythreadA,"黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
