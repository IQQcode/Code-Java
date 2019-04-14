package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/14
 */
public class TestThreadI {
    
    public static void main(String[] args) {
        
        System.out.println("main 执行 。。。。 ");
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "  running " + (i++));
                }
            }
        }, "Thread-A");
        //!!!! 设置线程为守护线程的方法，必须在start之前调用
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main 执行 。。。。 ");
        System.out.println("main 执行 。。。。 ");
        System.out.println("main 执行完啦 。。。。 ");
    }
}
