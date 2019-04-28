package www.Study;

import java.util.List;
import java.util.ArrayList;


public class TestOOMError {
    static class OOMObject{

    }
    //JVM 程序启动时通过JVM 参数指定最大最小容量
    //-Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true) {
            //循环一次，在JVM上创建一个对象
            list.add(new OOMObject());
        }
    }
}
