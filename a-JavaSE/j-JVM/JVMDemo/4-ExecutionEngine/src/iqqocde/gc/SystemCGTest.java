package iqqocde.gc;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-25 10:57
 * @Description:System.gc()调用测试
 */
public class SystemCGTest {
    public static void main(String[] args) {
        new SystemCGTest();
        // 提醒JVM的垃级回收器执行gc，但是不确定是否马上执行gc
        System.gc();

        // 调用finalize(),强制GC立即进行垃圾回收
        System.runFinalization();
    }

    @Override
    protected void finalize() {
        System.out.println("重写finalize方法，对象自我拯救...");
    }
}