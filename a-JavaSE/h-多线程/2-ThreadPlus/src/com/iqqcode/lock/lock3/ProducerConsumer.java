package com.iqqcode.lock.lock3;

import	java.util.concurrent.locks.Condition;
import  java.util.concurrent.locks.Lock;
import	java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-03 18:41
 * @Description:生产者消费者模型
 * @Solution: 线程A -> 线程B -> 线程C (交替执行,依次唤醒，同一时刻只有一个在执行)
 */

class Data {

    private int number = 1;

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();


    //condition.await() 等待
    //condition.signal() 唤醒

    //执行A业务
    public void workA()  {
        lock.lock();
        try {
            //业务：判断 -> 执行 -> 通知
            while (number != 1) {
               condition1.await(); //等待
            }
            System.out.println(Thread.currentThread().getName() + " --> " + number);
            number = 2;
            //线程A执行完，唤醒线程B
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //执行B业务
    public void workB() {
        lock.lock();
        try {
            while (number != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + " --> " + number);
            number = 3;
            //线程B执行完，唤醒线程C
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //执行C业务
    public void workC() {
        lock.lock();
        try {
            while (number != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + " --> " + number);
            number = 1;
            //线程B执行完，唤醒线程C
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.workA();
            }
        },"线程A").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.workB();
            }
        },"线程B").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.workC();
            }
        },"线程C").start();
    }
}
