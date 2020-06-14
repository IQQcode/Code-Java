package com.iqqcode.waitnotify;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-29 21:57
 * @Description:线程同步--wait和notify的理解
 */
class Sync implements Runnable{
    //标志位来唤醒等待的线程
    private boolean flag;
    private Object obj;

    public Sync(Object obj,boolean flag) {
        this.obj = obj;
        this.flag = flag;
    }

    public void waitMethod() {
        synchronized (obj) {
            while (true) {
                try {
                    System.out.println("wait方法开始..." + Thread.currentThread().getName());
                    obj.wait();
                    System.err.println("wait方法结束..." + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void notifyMethod() {
        synchronized (obj) {
            System.out.println("notify方法开始,唤醒等待的线程" + Thread.currentThread().getName());
            obj.notify();
            System.out.println("notify方法结束！！！" + Thread.currentThread().getName());
        }
    }


    @Override
    public void run() {
        if (flag) {
            this.waitMethod();
        }else {
            this.notifyMethod();
        }
    }
}

public class SyncWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Sync wait = new Sync(obj,true);
        Sync notify = new Sync(obj,false);
        new Thread(wait,"wait线程").start();
        Thread.sleep(2000);
        new Thread(notify,"notify线程").start();
    }
}
