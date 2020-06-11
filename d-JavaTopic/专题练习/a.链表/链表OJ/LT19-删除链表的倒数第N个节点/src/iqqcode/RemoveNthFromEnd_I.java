package iqqcode;

import nodes.ListNode;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-07 12:12
 * @Description:【解法一】两次遍历
 * @Link: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthFromEnd_I {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //添加一个哑结点作为辅助，该结点位于列表头部
        //哑结点用来简化某些极端情况，例如列表中只含有一个结点，或需要删除列表的头部
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //设置一个指向哑结点的指针，并移动它遍历列表
        ListNode node = head;
        int listLength = 0; //链表长度
        while(node != null) {
            node = node.next;
            listLength++;
        }
        node = dummy;
        //找到要删除节点的前一个节点
        for (int i = 0; i < listLength - n; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return dummy.next;
    }
}
