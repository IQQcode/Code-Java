package heap;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-28 18:12
 * @Description:堆空间分析工具Java-VisualVM测试
 * 参数设置:
 *          -Xms 10m
 *          -Xmx 10m
 */
public class HeapDemo1 {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end!!!");
    }
}
