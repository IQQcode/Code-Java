package heap;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-29 20:01
 * @Description:对象内存分配测试
 */
public class HeapInstanceTest2 {

    byte[] data = new byte[new Random().nextInt(1024 * 200)];

    public static void main(String[] args) {
        ArrayList<HeapInstanceTest2> list = new ArrayList<HeapInstanceTest2> ();
        while (true) {
            list.add(new HeapInstanceTest2());
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
