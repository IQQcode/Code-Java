package com.bittech.object;

/**
 * Author: secondriver
 * Created: 2019/4/21
 */
public class TestObject {
    
    
    public static void main(String[] args) {
        Object object = new Object();
        synchronized(object) {
            try {
                System.out.println("wait 开始");
                object.wait();
                System.out.println("wait 结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
