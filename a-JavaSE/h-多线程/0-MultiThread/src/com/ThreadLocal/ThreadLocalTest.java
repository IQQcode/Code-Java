package com.ThreadLocal;


/**
 * @Author: Mr.Q
 * @Date: 2019-07-26 10:51
 * @Description:
 */

public class ThreadLocalTest {
    private static String common;
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        // main Thread
        common = "main-->Common";
        threadLocal.set("main-->ThreadLoacalCommon");
        //The child Thread
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                common = "thread-->Common";
                threadLocal.set("thread-->ThreadLoacalCommon");
            }
        });
        thread.start();
        thread.join();
        System.out.println(common);
        System.out.println(threadLocal.get());
    }
}
