package iqqcode.Study.GCRoots;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Mr.Q
 * @Date: 2019-09-05 19:37
 * @Description:finalize()对象的自我拯救
 *
 */

public class FinalizeTest {
    private static FinalizeTest test;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize method execute!");
        test = this; //test等于当前调用finalize()的对象
    }

    public static void main(String[] args) throws InterruptedException {
        test = new FinalizeTest();
        test = null; //此时test对象没有被强引用指向，无引用指向
        //JVM检查 是否覆写且调用过finalize()
        //对象在此调用过程中与`GC Roots`有路可走，此对象不再被回收
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        if(test == null) {
            System.out.println("Now I'm dead...");
        }else {
            System.out.println("I'm Alive!");
        }

        test = null;//此时无引用指向,可以被垃圾回收
        //JVM检查 覆写且调用过finalize()
        //不再调用finalize(),判断对象死亡
        //finalize() 对象的一次自我拯救机会
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        if(test == null) {
            System.out.println("Now I'm dead...");
        }else {
            System.out.println("I'm Alive!");
        }
        //TODO
    }
}
