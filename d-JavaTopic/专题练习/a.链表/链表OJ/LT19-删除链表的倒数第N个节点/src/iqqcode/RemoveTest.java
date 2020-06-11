package iqqcode;

import nodes.ListNode;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-07 11:23
 * @Description:测试类
 */
public class RemoveTest {
    @Test
    public void test() {
        RemoveNthFromEnd_I mtl = new RemoveNthFromEnd_I();
        ListNode list = new ListNode(1);
        list.add(list,2);
        list.add(list,3);
        list.add(list,4);
        list.add(list,5);
        System.out.println("常规法: " + mtl.removeNthFromEnd(list,2));
    }
}
