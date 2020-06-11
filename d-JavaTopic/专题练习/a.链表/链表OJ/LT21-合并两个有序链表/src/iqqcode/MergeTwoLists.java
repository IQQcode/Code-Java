package iqqcode;

import nodes.ListNode;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-07 11:13
 * @Description:将两个升序链表合并为一个新的升序链表并返回
 * 新链表是通过拼接给定的两个链表的所有节点组成的
 * @Link: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //首先设定一个哨兵节点prehead ，可以在最后返回合并后的链表
        ListNode prehead = new ListNode(-1);
        //维护一个prev指针来指向当前元素，调整它的next指针来合并新链表
        ListNode prev = prehead;
        //当两个链表都不为空时
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            }else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //若其中有一个为空，将不为空的直接加入到新链表中
        if (l1 != null)    prev.next = l1;
        if (l2 != null)    prev.next = l2;

        return prehead.next;
    }
}
