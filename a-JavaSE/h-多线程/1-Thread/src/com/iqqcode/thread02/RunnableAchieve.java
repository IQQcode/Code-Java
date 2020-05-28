package com.iqqcode.thread02;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-25 18:48
 * @Description:实现多线程【二】--实现Runnable接口
 */
class MyRunnable implements Runnable {
    private String thread;

    @Override
    public void run() {
        for(int i = 0; i < 10;i++) {
            System.out.println(Thread.currentThread().getName() + " i = " + i);
        }
    }
}

public class RunnableAchieve {
    public static void main(String[] args) {
        //实例化Runnable接口的实现类
        MyRunnable run = new MyRunnable();
        //创建 Thread类对象，构造方法中传递 Runnable接口的实现类对象
        //调用 Threa类中的start方法，开启新的线程来执行run方法
        new Thread(run,"A").start();
        new Thread(run,"B").start();
        new Thread(run,"C").start();
    }
}