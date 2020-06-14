package iqqcode.jmm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-12 17:19
 * @Description:volatile保证有序性测试
 * link: https://www.jianshu.com/p/068ca23c38ba
 */
public class VolatileSeriaTest {

    private static volatile int a = 0, b = 0; //此处a,b变量是否添加volatile来修饰

    public static void main(String[] args) throws InterruptedException {
        Set<String> set = new HashSet<>();
        Map<String,Integer> map = new HashMap<>();

        for (int i = 0; i < 1000000; i++) {
            a = 0;
            b = 0;
            map.clear();

            Thread one = new Thread(() -> {
                b = 1;
                int x = a;
                map.put("x", x);
            });

            Thread two = new Thread(() -> {
                a = 1;
                int y = b;
                map.put("y", y);
            });

            one.start();
            two.start();

            one.join();
            two.join();

            set.add("x=" + map.get("x") + "," + "y=" + map.get("y"));
            System.out.println(set + " --> i = " + i);
        }
    }
}

