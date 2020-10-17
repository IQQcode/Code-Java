package bbb;

import java.util.*;
import java.util.concurrent.locks.*;

public class ProduceConsumer {
    private static final int CAPACITY = 5;
    private static final Lock lock = new ReentrantLock();
    //队列满的条件
    private static final Condition fullCondition = lock.newCondition();
    //队列空的条件
    private static final Condition emptyCondition = lock.newCondition();


    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedList<Integer>();

        Thread producer1 = new Producer("P-1", queue, CAPACITY);
        Thread producer2 = new Producer("P-2", queue, CAPACITY);
        Thread consumer1 = new Consumer("C1", queue, CAPACITY);
        Thread consumer2 = new Consumer("C2", queue, CAPACITY);
        Thread consumer3 = new Consumer("C3", queue, CAPACITY);

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }

    /**
     * 生产者
     */
    public static class Producer extends Thread {
        private Queue<Integer> queue;
        String name;
        int maxSize;
        int i = 0;

        public Producer(String name, Queue<Integer> queue, int maxSize) {
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                //获得锁
                lock.lock();
                while (queue.size() == maxSize) {
                    try {
                        System.err.println("对队列为满，<生产者>" + name + "线程等待...");
                        //条件不满足，生产阻塞
                        fullCondition.await();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("[" + name + "] Producing value : +" + i);
                queue.offer(i++);

                //唤醒其他所有生产者、消费者
                fullCondition.signalAll();
                emptyCondition.signalAll();

                //释放锁
                lock.unlock();

                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 消费者
     */
    public static class Consumer extends Thread {
        private Queue<Integer> queue;
        String name;
        int maxSize;

        public Consumer(String name, Queue<Integer> queue, int maxSize) {
            super(name);
            this.name = name;
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            while (true) {
                //获得锁
                lock.lock();

                while (queue.isEmpty()) {
                    try {
                        System.out.println("Queue is empty, Consumer[" + name + "] thread is waiting for Producer");
                        //条件不满足，消费阻塞
                        emptyCondition.await();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                int x = queue.poll();
                System.out.println("[" + name + "] Consuming value : " + x);

                //唤醒其他所有生产者、消费者
                fullCondition.signalAll();
                emptyCondition.signalAll();

                //释放锁
                lock.unlock();

                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

