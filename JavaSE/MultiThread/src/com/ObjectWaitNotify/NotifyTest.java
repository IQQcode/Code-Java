package com.ObjectWaitNotify;


/**
 * @Author: Mr.Q
 * @Date: 2019-07-26 11:46
 * @Description:    notify()唤醒等待的线程
 */

class MyThread implements Runnable {
    private boolean flag;
    private Object obj;

    public MyThread(boolean flag, Object obj) {
        this.flag = flag;
        this.obj = obj;
    }

    public void waitMethod() {
       synchronized (obj) {
           try {
               while (true) {
                   System.out.println("wait()方法开始..."+ Thread.currentThread().getName());
                   obj.wait();
                   System.out.println("wait()方法结束！"+ Thread.currentThread().getName());
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

    public void notifyMethod() {
        synchronized (obj) {
            System.out.println("notify()方法开始..."+ Thread.currentThread().getName());
            obj.notify();
            System.out.println("notify()方法结束！"+ Thread.currentThread().getName());
        }
    }
    @Override
    public void run() {
        if(flag) {
            this.waitMethod();
        }else {
            this.notifyMethod();
        }
    }
}

public class NotifyTest {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        MyThread waitThread = new MyThread(true, object);
        MyThread notifyThread = new MyThread(false, object);
        Thread thread1 = new Thread(waitThread, "wait线程");
        Thread thread2 = new Thread(notifyThread, "notify线程");
        thread1.start();
        Thread.sleep(2000);
        thread2.start();
        System.out.println("main方法结束!!");
    }
}
