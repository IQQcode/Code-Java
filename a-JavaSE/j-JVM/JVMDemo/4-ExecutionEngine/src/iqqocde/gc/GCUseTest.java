package iqqocde.gc;

import java.util.ArrayList;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-05 15:00
 * @Description:查看垃圾回收器
 *
 * -XX:+PrintCommandLineFlags
 */
public class GCUseTest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        while (true) {
            byte[] arr = new byte[100];
            list.add(arr);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
