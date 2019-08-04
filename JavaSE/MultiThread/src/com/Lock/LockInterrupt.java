package com.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-04 13:18
 * @Description: 在获取锁时能够响应中断
 */
class TestLockInterrupt implements Runnable {
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            while (true) {
                lock.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            System.err.println("线程"+Thread.currentThread().getName()+" 响应中断....");
            return;
        }finally {
            lock.unlock();
        }
    }
}

public class LockInterrupt {
    public static void main(String[] args) throws InterruptedException {
        TestLockInterrupt testLock = new TestLockInterrupt();
        Thread thread = new Thread(testLock,"Thread Q");
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
