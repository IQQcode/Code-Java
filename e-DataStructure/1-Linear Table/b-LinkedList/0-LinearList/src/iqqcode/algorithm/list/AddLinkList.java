package iqqcode.algorithm.list;

import java.io.*;
import java.util.*;

/**
 * @Author: iqqcode
 * @Date: 2020-10-17 22:11
 * @Description:删除链表重复节点[无序-有序]
 */

public class AddLinkList {

    public static class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node listGenerator(int length, String[] numbers) {
        Node head = new Node(Integer.parseInt(numbers[0]));
        Node cur = head;
        for (int i = 1; i < length; i++) {
            cur.next = new Node(Integer.parseInt(numbers[i]));
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 删除无序链表重复元素 (保留一个重复)
     * HashSet-O(n)
     */
    public static void removeListI(Node head) {
        if (head == null) return;
        Node pre = head;
        Node node = head.next;
        Set<Integer> set = new HashSet<>();
        set.add(head.value);
        while (node != null) {
            if (set.contains(node.value)) {
                pre.next = node.next;
            } else {
                set.add(node.value);
                pre = node;
            }
            node = node.next;
        }
    }

    /**
     * 删除无序链表重复元素 (保留一个重复)
     * O(n^2)
     *
     * @param head
     */
    public static void removeListII(Node head) {
        if (head == null) return;
        Node pre = null;
        Node node = head;
        Node next = null;
        while (node != null) {
            pre = node;
            next = node.next;
            while (next != null) {
                if (node.value == next.value) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            node = node.next;
        }
    }


    /**
     * 删除有序链表重复元素 (保留一个重复)
     * O(n^2)
     *
     * @param head
     */
    public static void removeSortList(Node head) {
        if (head == null) return;
        Node pre = head;
        Node node = head.next;
        while (node != null) {
            if (pre.value == node.value) {
                pre.next = node.next;
            } else {
                pre = node;
            }
            node = node.next;
        }
    }

    /**
     * 删除有序链表重复元素 (不保留重复元素)
     * 先用end和end.next元素比较，
     * - 如果相等，则left移动。之后循环判断left和right两个指针是否指向同一个元素。如果相等，则说明没有相同的元素。哨兵cur向后移动。反之，则说明存在相同的元素，哨兵则将当前next指针指向right.next,将重复元素都删除
     *
     * @param head
     */
    public static Node removeNoRepeat(Node head) {
        if (head == null) return head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node node = dummy;
        while (node != null && node.next != null) {
            Node nextNode = node.next.next;
            while (nextNode != null && nextNode.value == node.next.value) {
                nextNode = nextNode.next;
            }
            if (node.next.next == nextNode) {
                node = node.next;
            } else {
                node.next = nextNode;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //int n = Integer.parseInt(bufferedReader.readLine());
        //String[] numbers = bufferedReader.readLine().split(" ");

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] numbers = in.nextLine().split(" ");
        Node head = listGenerator(n, numbers);
        //removeListI(head);
        //removeListII(head);
        removeSortList(head);
        printList(head);
    }
}
