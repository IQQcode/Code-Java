package com.MultiThread;


import java.util.concurrent.ExecutorService;

/**
 * @Author: Mr.Q
 * @Date: 2019-07-26 16:05
 * @Description:
 */

public class InterruptStop extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("收到中断信号！");
                        break;
                    }
                }
            }
        };
        thread.start();
        Thread.sleep(1000);
        System.out.println("是否中断？"+ thread.isInterrupted());
        thread.interrupt();
        System.out.println("是否中断？"+ thread.isInterrupted());
    }
}
