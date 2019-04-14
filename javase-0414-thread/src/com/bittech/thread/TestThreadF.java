package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/14
 */
public class TestThreadF {
    
    public static void main(String[] args) {

//        new MyTickThreadA("Thread-A").start();
//        new MyTickThreadA("Thread-B").start();
//        new MyTickThreadA("Thread-C").start();
        
        System.out.println(Thread.currentThread().getName() + " 开始");
        Thread thread = new Thread(new MyRunnableJoin(), "Thread-Join");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 结束");
        
        
    }
    
}

class MyTickThreadA extends Thread {
    
    public MyTickThreadA(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //                Thread.sleep(1000);
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + " " + i);
            
        }
    }
}

class MyRunnableJoin implements Runnable {
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " run  i = " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
