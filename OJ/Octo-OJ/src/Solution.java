import java.util.*;
import java.io.*;

/**
 * @Author: iqqcode
 * @Date: 2020-10-17 22:11
 * @Description:计数排序
 */

public class Solution {

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

    // HashSet-O(n), 删除无序链表重复元素
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

    //O(n^2), 删除无序链表重复元素
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


    //O(n^2), 删除有序链表重复元素
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
