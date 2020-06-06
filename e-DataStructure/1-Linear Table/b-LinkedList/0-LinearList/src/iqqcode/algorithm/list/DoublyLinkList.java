package iqqcode.algorithm.list;

import java.util.Iterator;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-06 08:22
 * @Description:双向链表
 * @Solution:头结点不存放元素
 */
public class DoublyLinkList<T> implements Iterable<T>{

    //链表头结点
    private Node head;
    //链表尾结点
    private Node tail;
    //记录链表的长度
    private int N;

    //结点类
    private class Node {
        //存储数据
        T data;
        //指向上一个节点
        Node prev;
        //指向下一个结点
        Node next;

        public Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 初始化单链表
     */
    public DoublyLinkList() {
        //链表入口，无前驱，无后继，无数据
        this.head = new Node(null, null, null);
        this.tail = null;
        N = 0;
    }

    //清空链表
    public void clear() {
        this.head.next = null;
        this.tail = null;
        N = 0;
    }

    /**
     * 判断链表是否为空，是返回true，否返回false
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取链表中元素的个数
     * @return
     */
    public int length() {
        return N;
    }

    /**
     * 获取链表的第一个元素
     * @return
     */
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        //找到头结点的下一个节点的数据域
        return head.next.data;
    }

    /**
     * 获取链表的最后一个元素
     * @return
     */
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.data;
    }

    /**
     * 读取并返回链表中的第index个元素的值(注意初始节点不是头结点)
     * @param index
     * @return
     */
    public T get(int index) {
        Node node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    /**
     * 往链表中添加一个元素(尾插)
     * @param t
     */
    public void add(T t) {
        //如果链表为空
        if (isEmpty()) {
            //创建新节点
            Node newNode = new Node(t, head, null);
            //让新节点成为尾结点
            tail = newNode;
            //让头结点指向尾结点
            head.next = tail;
        } else { //如果链表不为空
            //记录之前的尾结点
            Node oldTail = tail;
            //创建新节点
            Node newNode = new Node(t, oldTail, null);
            //让当前的尾结点指向新节点
            oldTail.next = newNode;
            //让新节点成为尾结点
            tail = newNode;
        }
        //元素个数加一
        N++;
    }

    /**
     * 在链表的第index个元素之前插入一个值为t的数据元素
     * @param index
     */
    public void add(int index,T t) {
        //找到index位置的前一个节点befo
        Node befo = head;
        for (int i = 0; i < index; i++) {
            befo = befo.next;
        }
        //找到index位置的节点
        Node curr = befo.next;
        //创建新节点
        Node newNode = new Node(t, befo, curr);
        //插入的新节点newNode位于befo与index之间
        befo.next = newNode;
        curr.prev = newNode;
        //元素个数加一
        N++;
    }

    /**
     * 删除并返回链表中第index个数据元素
     * @param index
     * @return
     */
    public T remove(int index) {
        //找到index位置的前一个节点befo
        Node befo = head;
        for (int i = 0; i < index; i++) {
            befo = befo.next;
        }
        //找到index位置的节点curr
        Node curr = befo.next;
        //找到index位置的后一个节点last
        Node last = curr.next;
        //让curr无指向，让befo指向last,last指向befo
        befo.next = last;
        last.prev = befo;
        //元素个数减一
        N--;
        return curr.data;
    }

    /**
     * 返回链表中首次出现的指定的数据元素的位序号，若不存在，则返回-1
     * @param t
     * @return
     */
    public int indexOf(T t) {
        Node node = head;
        for (int i = 0; node.next != null; i++) {
            node = node.next;
            if (node.data.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 实例化Iterator对象，Iterator是接口，用内部类来实例化
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T> () {

            private Node node = head;

            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public T next() {
                node = node.next;
                return node.data;
            }
        };
    }
}
