package com.iqqcode.lock2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-16 09:44
 * @Description:ReentrantLock公平锁与非公平锁
 */
class FairUnfair {
    private Lock lock;

    public FairUnfair(boolean isfair) {
        //默认无参为非公平锁
        lock = new ReentrantLock(isfair);
    }

    public void foo() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "获得锁");
        } finally {
            lock.unlock();
        }
    }
}

class ThreadService extends Thread {
    private FairUnfair service;

    public ThreadService(FairUnfair service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.foo();
    }
}

public class FairUnfairLock {
    public static void main(String[] args) {
        //FairUnfair fu = new FairUnfair(false); //非公平锁
        FairUnfair fu = new FairUnfair(true); //公平锁
        Thread[] threads = new Thread[20];
        //创建线程组测试
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ThreadService(fu);
        }
        //尽量同时启动线程组
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
