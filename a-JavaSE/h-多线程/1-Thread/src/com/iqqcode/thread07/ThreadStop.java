package com.iqqcode.thread07;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-27 17:44
 * @Description:线程停止--设置标志位
 */
class TStop implements Runnable {
    //设置标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "执行 i = " + (i++));
        }
    }

    //转换标志位
    public void setFlag() {
        this.flag = false;
    }
}

public class ThreadStop {
    public static void main(String[] args) throws InterruptedException {
        TStop tp = new TStop();
        Thread thread = new Thread(tp,"线程A");
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("[main]->" + i);
            if (i == 900) {
                //thread.stop();
                tp.setFlag();
                Thread.sleep(100);
                System.err.println("线程A执结束！");
            }
        }
    }
}
