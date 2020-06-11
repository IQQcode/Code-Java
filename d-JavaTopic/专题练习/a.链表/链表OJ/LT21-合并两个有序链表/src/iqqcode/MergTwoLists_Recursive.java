package iqqcode;

import nodes.ListNode;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-07 11:17
 * @Description:递归解法
 */
public class MergTwoLists_Recursive {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
