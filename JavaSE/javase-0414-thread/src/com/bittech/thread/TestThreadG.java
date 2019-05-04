package com.bittech.thread;

/**
 * Author: secondriver
 * Created: 2019/4/14
 */
public class TestThreadG {
    
    public static void main(String[] args) {
        MyThreadStop threadStop = new MyThreadStop();
        threadStop.setName("Thread-Stop");
        threadStop.start();
        
        try {
            Thread.sleep(5000);
//            threadStop.setFlag(false);
//            threadStop.stop();
            threadStop.interrupt();
            System.out.println("main方法执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}

class MyThreadStop extends Thread {
    
    private boolean flag = true;
    
    @Override
    public void run() {
        int i = 0;
        while (flag) {
            try {
                Thread.sleep(1000);
                boolean status = Thread.currentThread().isInterrupted();
                if (status) {
                    System.out.println("非阻塞情况,线程的中断状态：" + status);
                    break;
                }
                System.out.println(Thread.currentThread().getName() + " 执行  i = " + (i++));
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().isInterrupted());//false
                //nothing
                //退出循环
                break;
            }
        }
    }
    
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
