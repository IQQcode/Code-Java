package com.iqqcode.thread07;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-27 19:42
 * @Description:isInterrupted 返回为true || false
 */

public class InterruptStatus implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println("收到中断信号！");
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptStatus tr = new InterruptStatus();
        Thread thread = new Thread(tr);
        Thread.sleep(1000);
        thread.start();
        System.out.println("是否中断？"+ thread.isInterrupted());
        thread.interrupt();
        System.out.println("是否中断？"+ thread.isInterrupted());
    }
}
