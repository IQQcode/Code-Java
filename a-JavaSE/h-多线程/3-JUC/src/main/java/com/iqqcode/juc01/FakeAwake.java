package com.iqqcode.juc01;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-06 09:25
 * @Description:虚假唤醒验证1
 */
class ResData {
    private int number = 0;

    public synchronized void increase() throws InterruptedException {
        if(number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + " -> " + number);
        this.notifyAll();
    }

    public synchronized void decrease() throws InterruptedException {
        if(number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + " -->> " + number);
        this.notifyAll();
    }
}

public class FakeAwake {
    public static void main(String[] args) {
        ResData data = new ResData();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程D").start();
    }
}
