package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/14
 */
public class TestThreadA {
    
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("MyThread1");
        MyThread myThread2 = new MyThread("MyThread2");
        MyThread myThread3 = new MyThread("MyThread3");

//        myThread1.run();
//        myThread2.run();
//        myThread3.run();
        System.out.println("main 方法中的代码 A");
        
        myThread1.start();
        myThread2.start();
        myThread3.start();
        
        System.out.println("main 方法中的代码 B");
        
    }
}

class MyThread extends Thread {
    
    private String title;
    
    public MyThread(String title) {
        this.title = title;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + " " + i);
        }
    }
}


