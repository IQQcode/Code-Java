package com.Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-04 13:45
 * @Description:
 */
class ThreadLockTime implements Runnable {
    private Lock lock = new ReentrantLock(); //实现Lock的接口
    @Override
    public void run() {
        fun();
    }

    private void fun() {
        try {
            if(lock.tryLock(1,TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + "获取锁成功！");
                // sleep 2000ms,线程2获取不到锁
                Thread.sleep(2000);
            }else {
                System.err.println(Thread.currentThread().getName() + "获取锁失败...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class LockTime {
    public static void main(String[] args) {
        ThreadLockTime threadLockTime = new ThreadLockTime();
        new Thread(threadLockTime,"ThreadA").start();
        new Thread(threadLockTime,"ThreadB").start();
    }
}
