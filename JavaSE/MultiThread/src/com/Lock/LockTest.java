package com.Lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-04 13:08
 * @Description:
 */
class MyLock implements Runnable {
    private Integer tickets = 50;
    private Lock ticketsLock = new ReentrantLock();
    @Override
    public void run() {
        while(tickets > 0) {
            //需要对程序上锁
            try {
                //等同于 synchronized(this)
                ticketsLock.lock();
                if(this.tickets > 0) {
                    System.out.println(Thread.currentThread().getName() +
                            "还有" + this.tickets-- + "张票");
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                ticketsLock.unlock();
            }
        }
    }
}



public class LockTest {
    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        new Thread(myLock,"黄牛A").start();
        new Thread(myLock,"黄牛B").start();

        Thread thread3 = new Thread(myLock,"黄牛C");
        thread3.start();
    }
}
