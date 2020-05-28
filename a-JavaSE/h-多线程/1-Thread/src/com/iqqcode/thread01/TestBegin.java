package com.iqqcode.thread01;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-25 16:58
 * @Description:多线程开始喽！
 */
class BeginThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run -> " + i);
        }
    }
}

public class TestBegin {
    public static void main(String[] args) {
        BeginThread bt = new BeginThread();
        bt.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main -->> " + i);
        }
    }
}
