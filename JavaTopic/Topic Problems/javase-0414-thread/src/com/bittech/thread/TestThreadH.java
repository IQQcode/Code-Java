package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/14
 */
public class TestThreadH {
    
    public static void main(String[] args) {
    
        System.out.println(Thread.currentThread().getName()+ "  优先级  "+Thread.currentThread().getPriority());

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " 优先级 "+Thread.currentThread().getPriority());
                Thread threadAB = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName()+ " 优先级 "+Thread.currentThread().getPriority());
                    }
                });
                threadAB.start();
            }
        },"Thread-A");
        threadA.setPriority(10);
//        Thread.MAX_PRIORITY
        threadA.start();
    }
}
