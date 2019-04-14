package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/14
 */
public class TestThreadE {
    
    public static void main(String[] args) {
        
        Thread thread = Thread.currentThread();
        System.out.println("Thread Name : " + thread.getName());
        
        new Thread(() -> {
            System.out.println("Thread1 : " + Thread.currentThread().getName());
            
        }, "Thread-Handler-Print").start();
        new Thread(() -> {
            System.out.println("Thread2 : " + Thread.currentThread().getName());
            
        }, "Thread-Handler-FileTransport").start();
    
        Thread thread1 =new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        });
        thread1.setName("Thread-Simple");
        thread1.start();
    }
    
    
}
