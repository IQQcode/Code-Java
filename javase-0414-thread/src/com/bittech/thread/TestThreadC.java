package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/14
 */
public class TestThreadC {
    
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }).start();
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable run执行");
            }
        }).start();
    }
}
