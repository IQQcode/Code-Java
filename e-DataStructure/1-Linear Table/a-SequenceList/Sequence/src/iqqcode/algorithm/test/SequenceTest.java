package iqqcode.algorithm.test;

import iqqcode.algorithm.SequenceList;
import org.junit.Test;


/**
 * @Author: Mr.Q
 * @Date: 2020-06-02 21:22
 * @Description:测试类
 */
public class SequenceTest {
    @Test
    public void test() {
        SequenceList<String> sl = new SequenceList<> (3);
        sl.add("张三");
        sl.add("李四");
        sl.add("王五");
        sl.add("田七");
        sl.add(2,"赵六");
        sl.remove(4);
        for (Object o : sl) {
            System.out.println(o);
        }
        System.out.println("get---4  " + sl.get(4));
    }
}
