package com.iqqcode.lock3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: iqqcode
 * @Date: 2020-08-23 16:17
 * @Description:超时获取
 */
class ThreadLockTime implements Runnable {
    //实现 Lock的接口
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        fun();
    }

    private void fun() {
        try {
            if(lock.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + "获取锁成功！");
                // sleep 2000ms,线程B获取不到锁
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