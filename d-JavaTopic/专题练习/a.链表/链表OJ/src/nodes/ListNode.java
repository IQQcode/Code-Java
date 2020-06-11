package nodes;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-07 11:18
 * @Description:节点API
 */
 public class ListNode {

     public int val;
     public ListNode next;

     ListNode() {}

     public ListNode(int val) {
         this.val = val;
     }

     public ListNode(int val, ListNode next) {
         this.val = val; this.next = next;
     }

    @Override
    public String toString() {
        ListNode prev = this;
        StringBuilder sb = new StringBuilder();
        while (prev != null) {
            sb.append(prev.val + " ");
            prev = prev.next;
        }
        return sb.toString();
    }

    public void add(ListNode head, int val) {
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        ListNode newNode = new ListNode(val, null);
        node.next = newNode;
    }
}