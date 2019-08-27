package com.juc;


import java.util.concurrent.Exchanger;

/**
 * @Author: Mr.Q
 * @Date: 2019-08-12 16:08
 * @Description:
 */
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread boyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String boy = exchanger.exchange("我明白你会来，所以我等！\n");
                    System.out.println("The boy said : To the most beautiful you ↓ \n" + boy);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        boyThread.start();

        Thread girlThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String girl = exchanger.exchange("一个人心头上的微风，吹到另外一个人生活里去时，是偶然还是必然？\n" +
                            "人生的理想，是情感的节制恰到好处，还是情感的放肆无边无涯？\n" +
                            "生命的取与，是昨天的好，当前的好，还是明天的好？");
                    System.out.println("\nThe girl said : To the world who knows me the most ↓ \n" + girl);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        girlThread.start();
    }
}
