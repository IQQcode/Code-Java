package com.iqqcode.juc02;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-08 12:48
 * @Description:阻塞队列
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        //test1();
        //test2();
        //test3();
        test4();
    }

    //抛出异常
    public static void test1() {
        ArrayBlockingQueue bq = new ArrayBlockingQueue<>(3);
        System.out.println("添加元素" + bq.add(1));
        System.out.println("添加元素" + bq.add(2));
        System.out.println("添加元素" + bq.add(3));
        //System.out.println("添加元素" + bq.add(4));
        //---------------------------------------
        System.out.println(bq.remove());
        System.out.println(bq.remove());
        System.out.println(bq.remove());
        System.out.println(bq.element());
        System.out.println(bq.remove());
    }

    //有返回值,不抛出异常
    public static void test2() {
        ArrayBlockingQueue bq = new ArrayBlockingQueue<>(3);
        System.out.println("添加元素" + bq.offer(1));
        System.out.println("添加元素" + bq.offer(2));
        System.out.println("添加元素" + bq.offer(3));
        //System.out.println("添加元素" + bq.add(4));
        //---------------------------------------
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        //System.out.println(bq.peek());
        System.out.println(bq.poll());
    }

    //阻塞等待
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue bq = new ArrayBlockingQueue<>(3);
        bq.put(1);
        bq.put(2);
        bq.put(3);
        System.err.println("阻塞中...");
        bq.put(4);
        //---------------------------------------
        System.out.println(bq.take());
        System.out.println(bq.take());
        System.out.println(bq.take());
        System.err.println("阻塞中...");
        System.out.println(bq.take());
    }

    //超时等待，到达等待时间自动退出
    public static void test4() throws InterruptedException {
        ArrayBlockingQueue bq = new ArrayBlockingQueue<>(3);
        bq.offer(1,2, TimeUnit.SECONDS);
        bq.offer(2,2, TimeUnit.SECONDS);
        bq.offer(3,2, TimeUnit.SECONDS);
        System.err.println("超时等待中...");
        bq.offer(4,2, TimeUnit.SECONDS);
        //---------------------------------------
        System.out.println(bq.poll(2, TimeUnit.SECONDS));
        System.out.println(bq.poll(2, TimeUnit.SECONDS));
        System.out.println(bq.poll(2, TimeUnit.SECONDS));
        System.err.println("超时等待中...");
        System.out.println(bq.poll(2, TimeUnit.SECONDS));
    }
}
