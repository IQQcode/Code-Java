一、进程与线程：

进程：操作系统中一个程序的执行周期为一个进程

线程：一个程序同时执行多个任务，一个任务称之为线程；

进程于线程的区别：

     1.每个进程都有自己的一整套变量，而线程则数据共享；
       进程是 操作系统中资源分配 的最小单位
       线程是 OS中任务调度的基本单位

     2.启动、撤销一个进程的开销要比线程大得多

     3.没有线进程就没有线程，进程结束，线程终止！

高并发：访问线程量非常非常高(CPU占用率高99.9%)


二、java实现多线程

                a. 继承Thread{ } 类；
                b.Runnable接口实现；
                c.Callable实现多线程<return - >;

-*** < run()方法只能由JVM调用，用户调用和普通方法无区别>
     JVM调用start0()方法进行资源的分配与系统调度，准备好资源启动线程后回调run()方法
     来执行线程的具体任务


    Runnable对象实例化：

    I.Thread类提供的构造方法来接收Runnable对象

       Thread类提供的Construct method:
              public Thread(Runnable target)

     MyThread mt = new MyThread();
     new Thread(mt).start();

    II.匿名内部类：
                     new Thread(new Runnable(){
                     	@Override
                     	public void run() {

                     	}
                     }).start();

    III.Lambda表达式：

         Runnable runnable = () -> System.out.println("Lambda表达式");
         new Thread(runnable).start();