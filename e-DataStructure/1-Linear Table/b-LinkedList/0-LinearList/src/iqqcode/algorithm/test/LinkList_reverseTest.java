package iqqcode.algorithm.test;

import iqqcode.algorithm.list.LinkList;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-06 14:30
 * @Description:单链表反转测试
 */
public class LinkList_reverseTest {
    @Test
    public void testLinkList() {

        LinkList<String> sl = new LinkList<>();

        sl.add("1");
        sl.add("2");
        sl.add("3");
        sl.add("4");
        sl.add("5");

        for (Object o : sl) {
            System.out.print(o + " ");
        }
        System.out.println("\n反转之后为");
        sl.reverse();
        for (Object o : sl) {
            System.out.print(o + " ");
        }
    }
}
