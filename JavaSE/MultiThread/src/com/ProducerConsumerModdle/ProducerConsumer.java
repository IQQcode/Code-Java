package com.ProducerConsumerModdle;


/**
 * @Author: Mr.Q
 * @Date: 2019-07-28 09:38
 * @Description:
 */

//商品类
class Goods {
    private String goodsName;  //货物名称
    private int count;       //货物库存

    //生产商品
    public synchronized void set(String goodsName) throws InterruptedException {
        if(this.count > 0) {
            System.out.println("房源充足,等待租客...");
        }
        this.goodsName = goodsName;
        this.count = count+1;
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" 生产"+this);
        // 生产完商品后通知消费者线程可以消费了
        notify();
    }
    //消费商品
    public synchronized void get() throws InterruptedException {
        this.count = this.count-1;
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+" 消费"+this);
        // 消费完商品后通知生产者线程可以生产了
        notify();
    }

    @Override
    public String toString() {
        return "Goods { " +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}

/**
 * 生产者类
 */
class Producer implements Runnable {
    private Goods goods;
    public Producer(Goods goods) {
        super();
        this.goods = goods;
    }
    @Override
    public void run() {
        try {
            this.goods.set("海景别墅一套，房租减半，水电全免...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 消费者类
 */
class Consumer implements Runnable {
    private Goods goods;
    public Consumer(Goods goods) {
        super();
        this.goods = goods;
    }
    @Override
    public void run() {
        try {
            this.goods.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Goods goods = new Goods();
        Thread produceThread = new Thread(new Producer(goods),"生产者线程");
        Thread consumeThread = new Thread(new Consumer(goods),"消费者线程");
        produceThread.start();
        Thread.sleep(1000);
        consumeThread.start();
    }
}
