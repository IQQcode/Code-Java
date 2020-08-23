package com.iqqcode.lock1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: iqqcode
 * @Date: 2020-08-23 16:17
 * @Description:可重入锁
 */
public class ReentrantLockTest {

    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try {
            System.out.println("enter main");
            //在未解锁之前调用method1()
            method1();
        } finally {
            lock.unlock();
        }
    }

    public static void method1() {
        lock.lock();
        try {
            System.out.println("enter method1...");
            //锁重入
            method2();
        } finally {
            lock.unlock();
        }
    }

    public static void method2() {
        lock.lock();
        try {
            //锁重入
            System.out.println("enter method2...");
        } finally {
            lock.unlock();
        }
    }

}
