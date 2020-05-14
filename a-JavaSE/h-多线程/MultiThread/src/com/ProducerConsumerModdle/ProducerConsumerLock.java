package com.ProducerConsumerModdle;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-07 10:46
 * @Description: Lock实现生产者消费者模型
 */

// 商品类
class Cargo {
    private String name; // 商品名称
    private int maxSize; // 商品存放的最大数量
    private int currentSize;// 当前商品数量
    private Lock lock = new ReentrantLock();  // lock锁，维护线程安全
    // 产生生产者等待队列
    private Condition producerQueue = lock.newCondition();
    // 产生消费者等待队列
    private Condition consumerQueue = lock.newCondition();

    public Cargo(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public String toString() {
        return " Cargo {" +
                "name='" + name + '\'' +
                ", maxSize=" + maxSize +
                ", currentSize=" + currentSize +
                '}';
    }

    // 生产者方法
    public void setCargo(String name) {
        try {
            lock.lock();
            // 判断 currentSize 是否等于 maxSize
            //此时商品数量已经达到最大值,生产者需要阻塞
            while (currentSize == maxSize) {
                System.out.println(Thread.currentThread().getName() +"商品数量已经达到最大值,生产者等待...");
                producerQueue.await();
            }
            //商品数量还未达到最大值,生产者继续生产
            this.name = name;
            currentSize++;  //生产商品
            System.out.println(Thread.currentThread().getName() +" 生产商品！" + toString());
            // 唤醒所有消费者
            consumerQueue.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 消费者方法
    public void getCargo() {
        try {
            lock.lock();
            // 当前商品数量是否为0,消费者等待
            while (currentSize == 0) {
                System.out.println(Thread.currentThread().getName() + " 商品为空，消费者等待...");
                consumerQueue.await();
            }
            currentSize--; //消费商品
            System.out.println(Thread.currentThread().getName() +" 消费" + toString());
            // 唤醒生产者线程
            producerQueue.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

// 生产者
class Producers implements Runnable {
    private Cargo cargo; //传入商品类

    public Producers(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                //生产商品
                this.cargo.setCargo("旺仔老馒头");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 消费者
class Consumers implements Runnable {
    private Cargo cargo; //传入相同的商品类

    public Consumers(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                this.cargo.getCargo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumerLock {
    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        Cargo cargo = new Cargo(10);
        Producers producers = new Producers(cargo);
        Consumers consumers = new Consumers(cargo);
        //产生3个生产者线程
        for(int i = 0; i < 3; i++) {
            list.add(new Thread(producers,"生产者"+(i+1)));
        }
        //产生6个消费者线程
        for(int i = 0; i < 6; i++) {
            list.add(new Thread(consumers,"消费者"+(i+1)));
        }
        for(Thread thread : list) {
            thread.start();
        }
    }
}
