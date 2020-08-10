package gc.logs;

import java.util.ArrayList;

/**
 * @Author: iqqcode
 * @Date: 2020-08-08 12:20
 * @Description:-XX:PrintGCDetails 输出GC详细日志
 * -XX:+PrintGCDetails
 * -Xms60m -Xmx60m -XX:+PrintGCDetails -XX:+UseG1GC -Xloggc:./logs/_01PrintGCDetails.log
 */
public class _01PrintGCDetails {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            byte[] arr = new byte[1024 * 1024];
            list.add(arr);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
