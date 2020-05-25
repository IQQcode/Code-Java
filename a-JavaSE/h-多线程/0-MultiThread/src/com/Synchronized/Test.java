package com.Synchronized;


/**
 * @Author: Mr.Q
 * @Date: 2019-07-26 19:10
 * @Description:
 */


/*

public class Test{
    private static Object object = new Object();
    public static void main(String[] args) {
        synchronized (object) {
            System.out.println("hello world");
        }
    }
}
*/




public class Test {
    private static Object object = new Object();
    public static synchronized void main(String[] args) {
        System.out.println("hello world");
    }
}
