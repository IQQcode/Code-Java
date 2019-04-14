package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/14
 */
public class TestThreadK {
    
    public static void main(String[] args) {
//        new MySynThread("Thread-A").start();
//        new MySynThread("Thread-B").start();
//        new MySynThread("Thread-C").start();
        Syn syn = new Syn();
        MySynRunnable runnable = new MySynRunnable(syn);
        new Thread(runnable, "Thread-A").start();
        new Thread(runnable, "Thread-B").start();
        new Thread(runnable, "Thread-C").start();
    }
}

class Syn {

//    public synchronized void test() {
//        System.out.println(Thread.currentThread().getName() + " test 方法执行开始");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName() + " test 方法执行结束");
//
//    }

//    public synchronized void test() {
//        synchronized(this) {
//            System.out.println(Thread.currentThread().getName() + " test 方法执行开始");
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + " test 方法执行结束");
//        }
//    }
    
    public synchronized void test() {
        //Syn.class Class对象
        //Syn[] 对象
        //全局锁
        synchronized(Syn.class) {
            System.out.println(Thread.currentThread().getName() + " test 方法执行开始");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " test 方法执行结束");
        }
    }
    
}

class MySynThread extends Thread {
    
    public MySynThread(String name) {
        super(name);
    }
    
    @Override
    public void run() {
        Syn syn = new Syn();
        syn.test();
    }
}

class MySynRunnable implements Runnable {
    
    private final Syn syn;
    
    MySynRunnable(Syn syn) {
        this.syn = syn;
    }
    
    @Override
    public void run() {
        Syn syn = new Syn();
        syn.test();
    }
}