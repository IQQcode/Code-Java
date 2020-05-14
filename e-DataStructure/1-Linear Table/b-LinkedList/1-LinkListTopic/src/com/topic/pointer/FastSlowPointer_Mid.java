package com.topic.pointer;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-06 16:04
 * @Description:快慢指针问题求解
 * @Topic1:求链表中间值
 * @Solution: 快指针(步长是慢指针的一半)到达终点，慢指针到达中间位置
 */
public class FastSlowPointer_Mid {

    /**
     * @param first 链表的首结点
     * @return 链表的中间结点的值
     */
    public static String getMid(Node<String> first) {
        //定义两个指针
        Node<String> fast = first;
        Node<String> slow = first;
        //使用两个指针遍历链表：当快指针指向的结点没有下一个结点时：就可以结束慢指针，慢指针指向的结点就是中间值
        while (fast != null && fast.next != null) {
            //变化fast和slow的值,fast的步长是slow的两倍
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
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
        Node<String> first = new Node<>("aa", null);
        Node<String> second = new Node<>("bb", null);
        Node<String> third = new Node<>("cc", null);
        Node<String> fourth = new Node<>("dd", null);
        Node<String> fifth = new Node<>("ee", null);
        Node<String> six = new Node<>("ff", null);
        Node<String> seven = new Node<>("gg", null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;

        //查找中间值
        String mid = getMid(first);
        System.out.println("链表的中间值为：" + mid);
    }
}
