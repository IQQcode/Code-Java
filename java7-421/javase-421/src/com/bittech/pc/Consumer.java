package com.bittech.pc;

import java.util.Queue;

/**
 * Author: secondriver
 * Created: 2019/4/21
 */
public class Consumer implements Runnable {
    
    private final Queue<Goods> goodsQueue;
    
    private final Long speed;
    
    public Consumer(Queue<Goods> goodsQueue, Long speed) {
        this.goodsQueue = goodsQueue;
        this.speed = speed;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(this.speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(this.goodsQueue) {
                if (this.goodsQueue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " 商品队列已空  通知生产");
                    this.goodsQueue.notifyAll();
                } else {
                    Goods goods = this.goodsQueue.poll();
                    if (goods != null) {
                        System.out.println(Thread.currentThread().getName() + " 商品队列有货  消费商品" + goods);
                    }
                }
            }
            
        }
    }
}
