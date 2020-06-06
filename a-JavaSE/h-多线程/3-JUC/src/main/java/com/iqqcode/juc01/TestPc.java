package com.iqqcode.juc01;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-06 09:16
 * @Description:生产者消费者问题--虚假唤醒验证2
 */
class Resource {
    /** 产品数 */
    private int product = 0;

    /** 进货 */
    public synchronized void get() {
        if(product >= 10) {
            System.out.println(Thread.currentThread().getName()+":"+"产品已满!");
            /** 当商品已经满的时候，进货线程挂起 */
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /** 进货 */
        System.out.println(Thread.currentThread().getName()+":"+ ++product);
        /** 唤醒其他线程 */
        this.notifyAll();

    }

    /** 售货 */
    public synchronized void sale() {
        if(product <= 0) {
            System.out.println(Thread.currentThread().getName()+":"+"产品已空");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+":"+ --product);
        this.notify();
    }
}


public class TestPc {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    /** 睡眠，便于观察结果 */
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resource.get();
            }
        },"生产者A").start();



        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                resource.sale();
            }

        },"消费者C").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {

                resource.get();
            }

        },"生产者B").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                resource.sale();
            }

        },"消费者D").start();
    }
}
