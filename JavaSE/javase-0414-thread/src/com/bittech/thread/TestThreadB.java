package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/14
 */
public class TestThreadB {
    
    public static void main(String[] args) {
        MyRunnable myRunnableA = new MyRunnable("MyRunnable-ThreadA");
        MyRunnable myRunnableB = new MyRunnable("MyRunnable-ThreadB");
        
        
        Thread threadA = new Thread(myRunnableA);
        Thread threadB = new Thread(myRunnableB);
        
        System.out.println("TestThreadB-Main-Method Before");
        threadA.start();
        threadB.start();
        System.out.println("TestThreadB-Main-Method After");
        
    }
    
}

class MyRunnable implements Runnable {
    
    private String title;
    
    MyRunnable(String title) {
        this.title = title;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.title + " " + i);
        }
    }
}
