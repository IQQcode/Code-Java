package com.juc;

import java.util.concurrent.Semaphore;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-12 16:25
 * @Description:Semaphore
 */

// 网吧开黑
class SemaphoreDemo implements Runnable {
    private Semaphore semaphore;
    private int num;

    public SemaphoreDemo(Semaphore semaphore, int num) {
        this.semaphore = semaphore;
        this.num = num;
    }

    @Override
    public void run() {
        //尝试申请设备
        try {
            semaphore.acquire();
            System.out.println("玩家"+ this.num +"使用一台电脑打游戏...");
            Thread.sleep(2000);
            System.out.println("玩家"+ this.num +"释放一台设备！");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class SemaphoreTest {
    public static void main(String[] args) {
        //信号量为5
        Semaphore semaphore = new Semaphore(5); //5台设备
        for(int i = 0; i < 8; i++) { //8名玩家
            new Thread(new SemaphoreDemo(semaphore,(i+1))).start();
        }
    }
}
