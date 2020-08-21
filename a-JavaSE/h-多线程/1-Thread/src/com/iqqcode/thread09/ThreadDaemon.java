package com.iqqcode.thread09;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-28 09:58
 * @Description:守护线程
 */
class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("God Bless you!");
        }
    }
}

class Person implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Live happily...");
        }
        System.err.println("--> 撒由那拉！！！");
    }
}

public class ThreadDaemon {
    public static void main(String[] args) throws InterruptedException {
        God god = new God();
        Person per = new Person();
        Thread thread = new Thread(god);
        //设置上帝为守护线程
        thread.setDaemon(true);
        thread.start();
        //启动用户线程
        new Thread(per).start();
    }
}
