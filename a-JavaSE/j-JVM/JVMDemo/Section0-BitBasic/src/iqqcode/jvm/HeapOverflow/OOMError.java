package iqqcode.jvm.HeapOverflow;

import java.util.List;
import java.util.ArrayList;

/**
 * @JVM参数 -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 * @Description:堆溢出
 */
public class OOMError {

    static class OOMObject{ }

    //JVM 程序启动时通过JVM参数指定最大最小容量
    //-Xmx20m -Xms20m
    //-XX:+HeapDumpOnOutOfMemoryError 记录堆异常信息
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true) {
            //循环一次，在JVM上创建一个对象
            list.add(new OOMObject());
        }
    }
}
