package iqqcode.jvm.MemoryOverflow;

/**
 * @Description:多线程下内存溢出异常
 * JVM参数 -Xss128k
 */

public class StackLeakByThread {
    public void dontStop() {
        while(true) {

        }
    }
    public void stackLeakByThread() {
        while(true) {
            //匿名内部类创建线程
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        StackLeakByThread test = new StackLeakByThread();
        test.stackLeakByThread();
    }
}

