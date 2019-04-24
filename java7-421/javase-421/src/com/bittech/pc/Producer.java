package com.bittech.pc;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者
 * <p>
 * Author: secondriver
 * Created: 2019/4/21
 */
public class Producer implements Runnable {
    
    private final Queue<Goods> goodsQueue;
    
    private final Integer maxGoods;
    
    private final Long speed;
    
    private final AtomicInteger goodsId = new AtomicInteger(0);
    
    public Producer(Queue<Goods> goodsQueue, Integer maxGoods, Long speed) {
        this.goodsQueue = goodsQueue;
        this.maxGoods = maxGoods;
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
                if (this.goodsQueue.size() >= this.maxGoods) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " 商品队列已满  等待消费");
                        this.goodsQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Goods goods = new Goods("商品-" + goodsId.getAndDecrement(), Math.random());
                    this.goodsQueue.add(goods);
                    System.out.println(Thread.currentThread().getName() + " 商品队列未满  生成商品 " + goods);
                }
            }
        }
    }
}
