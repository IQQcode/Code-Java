package com.bittech.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: secondriver
 * Created: 2019/4/14
 */
public class TestThreadL {
    
    public static void main(String[] args) {
        Runnable runnable = new MyTickRunnableSyn2();
        new Thread(runnable, "黄牛A").start();
        new Thread(runnable, "黄牛B").start();
        new Thread(runnable, "黄牛C").start();
        
    }
}

class MyTickRunnableSyn2 implements Runnable {
    
    private int tick = 30;
    
    private Lock lock = new ReentrantLock();
    
    @Override
    public void run() {
        while (this.tick > 0) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            /*
                lock.lock();
                try{
                
                }finally{
                    lock.unlock();
                }
             */
            lock.lock();
            try {
                if (this.tick > 0) {
                    System.out.println(Thread.currentThread().getName() + " 买票, 剩余 " + (--this.tick));
                    if (this.tick == 0) {
                        System.out.println("票卖光了。。");
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
}




