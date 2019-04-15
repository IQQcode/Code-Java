package com.MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * java实现多线程：
 *
 * 1.继承Thread{ }类;
 * 2.Runnable接口;
 * 3.Callable实现(return ->);
 */

//一、继承 Thread


class MyThread extends Thread {
    private String title;
    public MyThread(String title) {
        this.title = title;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10;i++) {
            System.out.println(this.title + " i = " + i);
        }
    }
}

public class TestThread {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("A");
        MyThread myThread2 = new MyThread("B");
        MyThread myThread3 = new MyThread("C");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}



//二、Runnable接口


class MyThread implements Runnable {
    private String title;
    public MyThread(String title) {
        this.title = title;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10;i++) {
            System.out.println(this.title + " i = " + i);
        }
    }
}

public class TestThread {
    public static void main(String[] args) {
        //I. Thread类提供的构造方法接收 Runnable对象

        // public Thread(Runnable target)

        // MyThread mt = new MyThread();
        // new Thread(mt).start();

        MyThread myThread1 = new MyThread("A");
        MyThread myThread2 = new MyThread("B");
        MyThread myThread3 = new MyThread("C");
        new Thread(myThread1).start();
        new Thread(myThread2).start();
        new Thread(myThread3).start();

        //II. 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        //III. Lambda表达式
        Runnable runnable = () -> System.out.println("Lambda表达式实例化Runnable对象");
        new Thread(runnable).start();

    }
}



//三、Callable实现多线程

class MyThread implements Callable<String> {
    private Integer tickets = 6;

    @Override
    public String call() throws  Exception {
        while(this.tickets > 0) {
            System.out.println("剩余票数为" + (this.tickets--));
        }
        return "票卖完了……";
    }
}

public class TestThread {
    public static void main(String[] args) throws Exception {
        FutureTask<String> task = new FutureTask<>(new MyThread());
        new Thread(task).start();
        new Thread(task).start();
        System.out.println(task.get());
    }
}


