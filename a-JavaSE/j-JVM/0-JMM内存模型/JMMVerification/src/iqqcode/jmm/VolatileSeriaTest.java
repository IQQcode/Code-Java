package iqqcode.jmm;

import	java.util.HashMap;
import	java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-11 11:30
 * @Description:volatile保证有序性测试
 */
public class VolatileSeriaTest {

    static int x = 0, y = 0;  //此处x,y变量是否添加volatile来修饰

    public static void main(String[] args) throws InterruptedException {
        Set<String> set = new HashSet<> ();
        Map<String,Integer> map = new HashMap<> ();

        for (int i = 0; i < 1000000; i++) {
            x = 0;
            y = 0;
            map.clear();

            Thread one = new Thread(() -> {
                int a = y;
                x = 1;
                map.put("a", a);
            });

            Thread two = new Thread(() -> {
                int b = x;
                y = 1;
                map.put("b", b);
            });

            one.start();
            two.start();

            one.join();
            two.join();

            set.add("a=" + map.get("a") + "," + "b=" + map.get("b"));
            System.out.println(set + " --> i = " + i);
        }
    }
}
