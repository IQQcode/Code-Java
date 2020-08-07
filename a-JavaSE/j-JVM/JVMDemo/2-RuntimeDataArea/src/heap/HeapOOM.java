package heap;

import java.util.ArrayList;

/**
 * @Author: Mr.Q
 * @Date: 2020-08-05 11:58
 * @Description:堆空间OOM测试,dump快照分析
 *
 * -Xms8m
 * -Xmx8m
 * -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    byte[] bufffer = new byte[1 * 1024 * 1024]; //1MB

    public static void main(String[] args) {
        ArrayList<HeapOOM> list = new ArrayList<HeapOOM> ();
        int count = 0;
        try {
            while(true) {
                list.add(new HeapOOM());
                count++;
            }
        } catch (Throwable t) {
            System.out.println("count = " + count);
            t.printStackTrace();
        }
    }
}
