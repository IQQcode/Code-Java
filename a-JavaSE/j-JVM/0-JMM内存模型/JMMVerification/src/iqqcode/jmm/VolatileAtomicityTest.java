package iqqcode.jmm;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-11 11:04
 * @Description:volatile不保证原子性测试
 */
public class VolatileAtomicityTest {

    public static volatile int num = 0;

    public static void increase() {
        num++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(num); // num <= 1000 * 10
    }
}
