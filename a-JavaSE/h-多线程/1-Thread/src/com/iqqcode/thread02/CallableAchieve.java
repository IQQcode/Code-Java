package com.iqqcode.thread02;
import java.util.concurrent.*;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-26 11:59
 * @Description:实现多线程【三】--实现Callable接口
 */
class MyCallable implements Callable<String> {

    private Integer tickets = 20;

    @Override
    //线程需要执行的任务 call()
    public String call() throws  Exception {
        while(this.tickets > 0) {
            System.out.println("剩余票数为" + (this.tickets--));
        }
        return "票卖完了……";
    }
}
public class CallableAchieve {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable c1 = new MyCallable();
        ExecutorService service = Executors.newFixedThreadPool(3);
        //Future: 接收Callable接口的返回值
        //三个线程共享一份资源
        Future<String> thread1 = service.submit(c1); //Callable类的对象传入Thread中
        Future<String> thread2 = service.submit(c1);
        Future<String> thread3 = service.submit(c1);
        //获取返回结果，并抛出异常
        System.out.println(thread1.get());
        System.out.println(thread2.get());
        System.out.println(thread3.get());
        //关闭服务
        service.shutdown();
    }
}
