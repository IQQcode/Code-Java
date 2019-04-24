package com.bittech.object;

/**
 * Author: secondriver
 * Created: 2019/4/21
 */
public class TestWaitAndNotify {
    
    public static void main(String[] args) {
        final Object monitor = new Object();
        Thread waitThread = new WaitThread(monitor);
        waitThread.setName("Thread-Wait");
        Thread waitThread1 = new WaitThread(monitor);
        waitThread1.setName("Thread-Wait1");
        
        Thread notifyThread = new NotifyThread(monitor);
        notifyThread.setName("Thread-Notify");
        
        waitThread.start();
        waitThread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyThread.start();
        
    }
    
}

class WaitThread extends Thread {
    
    private final Object monitor;
    
    public WaitThread(Object monitor) {
        this.monitor = monitor;
    }
    
    @Override
    public void run() {
        synchronized(monitor) {
            System.out.println(Thread.currentThread().getName() + " 开始执行");
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 结束执行");
            
        }
        
    }
}

class NotifyThread extends Thread {
    
    private final Object monitor;
    
    public NotifyThread(Object monitor) {
        this.monitor = monitor;
    }
    
    @Override
    public void run() {
        synchronized(monitor) {
            System.out.println(Thread.currentThread().getName() + " 开始执行");
//            monitor.notify(); //通知一个wait线程
            monitor.notifyAll();//通知所有wait线程
            System.out.println(Thread.currentThread().getName() + "结束执行");
        }
    }
}
