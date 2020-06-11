package iqqcode;

import nodes.ListNode;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-07 11:23
 * @Description:测试类
 */
public class MergeTest {
    @Test
    public void test() {
        MergeTwoLists mtl = new MergeTwoLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println("常规法: " + mtl.mergeTwoLists(l1,l2));
    }

    @Test
    public void test1() {
        MergTwoLists_Recursive mtl = new MergTwoLists_Recursive();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println("递归法: " + mtl.mergeTwoLists(l1,l2));
    }
}
