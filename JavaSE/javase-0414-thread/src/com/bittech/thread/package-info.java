/**
 * Author: secondriver
 * Created: 2019/4/14
 */
package com.bittech.thread;

/*
Java的线程创建方式：
0.
    0.1 线程的启动时通过start方法
    0.2 如果调用run方法，跟普通的对象调用方法没有区别，跟线程没关系
    0.3 线程start方法只能调用一次，否则如果线程已经启动，再次调用会抛出异常 IllegalThreadStateException
    
1. 继承Thread类，覆写run方法
2.
   定义子类实现Runnable接口，通过Thread(Runnable target) 构造实例化Thread对象    --> 业务返回值void
   
   定义子类实现Callable接口，通过FutureTask 和 Thread(Runnable target) 构造实例化Thread对象， FutureTask的get方法获取结果        -->  业务有返回值（V）


  继承Thread                     vs  实现Runnable/Callable
  单继承，不能再次继承其它类         多继承
  线程的创建调度跟业务耦合          业务独立，可以复用（共享）

3. 线程池，线程工厂

线程的方法：
1. 通过Thread.currentThread()获取执行当前代码的线程
2. Java的main方法，程序入口，它也在线程中执行， 线程名：main
3. 线程是Java应用程序执行的最小单元
4. 创建线程时，如果不指定线程名  Thread-index (0,1,2,...)
   创建线程时通过构造方法，或者setName设置线程名称

5. sleep 休眠，暂停线程，交出CPU，不释放锁（资源）
6. yield 让步，暂定线程，交出CPU（时机不确定），不释放锁，CPU时间片段只能供相同优先级的线程使用，回到就绪
7. join 等待结束 在一个线程A中执行另外一个线程B的join方法，那么线程A阻塞，直到线程B执行完毕，线程A继续执行（回到就绪）
8. 线程停止
    8.1 标记位的方式
    8.2 stop方法，弃用
    8.3 interrupted
9. 线程优先级
    主方法（main线程）是一个中等优先级的线程 5
    线程的优先级具有继承性
    线程的优先级最大，越有可能先执行

10. 线程分类
    用户线程  main线程用户线程，用户创建的线程（Daemon false）
    守护线程  陪伴线程 当我们的JVM最后一个用户线程退出，守护线程（一直运行）自动退出

 */