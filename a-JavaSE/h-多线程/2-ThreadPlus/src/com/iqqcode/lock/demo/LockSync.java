package com.iqqcode.lock.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-28 16:55
 * @Description:Lock锁
 */
class Sync implements Runnable {

    //实现Lock的接口来定义锁
    private Lock ticketsLock = new ReentrantLock();
    private int tickets = 20;

    @Override
    public void run() {
        while(true) {
            //需要对程序上锁
            try {
                //等同于synchronized(this)
                ticketsLock.lock();
                Thread.sleep(200);
                if(this.tickets >= 0) {
                    System.out.println(Thread.currentThread().getName() +
                            "还有" + this.tickets-- + "张票");
                }else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                ticketsLock.unlock();
            }
        }
    }
}

public class LockSync {
    public static void main(String[] args) {
        Sync run = new Sync();
        new Thread(run,"黄牛A").start();
        new Thread(run,"黄牛B").start();
        new Thread(run,"黄牛C").start();
    }
}
