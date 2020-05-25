package com.ObjectWaitNotify;


/**
 * @Author: Mr.Q
 * @Date: 2019-07-26 11:19
 * @Description:
 */

public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        synchronized (obj) {
            System.out.println("wait开始...");
            obj.wait(2000);
            System.out.println("wait结束...");
        }
    }
}
