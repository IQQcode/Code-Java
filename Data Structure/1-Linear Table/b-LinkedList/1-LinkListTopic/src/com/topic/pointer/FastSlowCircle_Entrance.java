package com.topic.pointer;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-06 19:21
 * @Description:有环链表入口问题
 * @Solution: 当快慢指针相遇时，可以判断到链表中有环，这时重新设定一个新指针temp指向链表的起点
 * 且步长与慢指针一样，则慢指针与新指针temp相遇的地方就是环的入口。
 */
public class FastSlowCircle_Entrance {

    /**
     * 查找有环的链表的入口节点
     * @param first 链表首结点
     * @return 环的入口节点
     */
    public static Node getEntrance(Node<String> first) {
        //定义快慢指针
        Node<String> fast = first;
        Node<String> slow = first;
        //临时指针
        Node<String> temp = null;

        //遍历链表，先找到环。快慢指针相遇时，临时指针temp指向首元素，继续遍历
        //直到慢指针和temp相遇，相遇时所指向的节点就是环的入口
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //判断快慢指针是否相遇
            if (slow.equals(fast)) {
                temp = first;
                //结束本次循环 ，继续下次循环
                continue;
            }

            //临时指针temp变换
            //快慢指针相遇前temp不动
            if (temp != null) {
                temp = temp.next;
                //判断慢指针和temp是否相遇
                if (temp.equals(slow)) {
                    break;
                }
            }
        }
        return temp;
    }


    //结点类
    private static class Node<T> {
        //存储数据
        T data;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.data = item;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        Node<String> first = new Node<>("1", null);
        Node<String> second = new Node<>("2", null);
        Node<String> third = new Node<>("3", null);
        Node<String> fourth = new Node<>("4", null);
        Node<String> fifth = new Node<>("5", null);
        Node<String> six = new Node<>("6", null);
        Node<String> seven = new Node<>("7", null);
        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        //产生环
        seven.next = third;

        //判断链表是否有环
        Node<String> entrance = getEntrance(first);
        System.out.println("链表中环的入口节点元素为 ：" + entrance.data);
    }
}
