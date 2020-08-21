package com.iqqcode.waitnotify;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-29 23:10
 * @Description:生产者消费者模型
 */
class Goods {
    private String rooms;  //货物名称
    private int count;       //货物库存

    //生产商品
    public synchronized void set(String rooms) {
        this.rooms = rooms;
        this.count = count + 1;
        System.out.println(Thread.currentThread().getName()+ " 生产" + this);
    }

    //消费商品
    public synchronized void get() {
        this.count = this.count - 1;
        System.out.println(Thread.currentThread().getName() + " 消费" + this);
    }

    @Override
    public String toString() {
        return "Goods { " +
                "rooms='" + rooms + '\'' +
                ", count=" + count +
                '}';
    }
}

class Producer implements Runnable {
    private Goods goods;
    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.set("海景别墅一套，房租减半，水电全免...");
    }
}

class Consumer implements Runnable {
    private Goods goods;
    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        this.goods.get();
    }
}

public class _02ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Goods goods = new Goods();
        new Thread(new Producer(goods),"生产者线程").start();
        Thread.sleep(1000);
        new Thread(new Consumer(goods),"消费者线程").start();
    }
}
