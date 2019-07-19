package com.MultiThread;

/**
 * 数据共享并发问题
 *
 * 一份资源，多个线程共享，会带来并发问题(数据的不一致性)
 */
class Web123 implements Runnable {
    private Integer tickets = 50;
    @Override
    public void run() {
        while (tickets >= 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "---->" + tickets--);
        }
    }
}

public class TicketsConcurrency {
    public static void main(String[] args) {
        Web123 web123 = new Web123();    //一分资源，多个共享
        System.out.println(Thread.currentThread().getName());
        new Thread(web123,"黄牛A").start();
        new Thread(web123,"黄牛B").start();
        new Thread(web123,"黄牛C").start();
    }
}
