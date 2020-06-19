package iqqcode.algorithm.queue;

import java.util.Iterator;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-10 12:04
 * @Description:队列--链表实现
 */
public class LinkQueue<T> implements Iterable<T>{
    //当前队列头结点
    private Node head;
    //当前队列的尾节点，用于元素的入队操作
    private Node tail;
    //队列中的元素个数
    private int N;

    //存放数据的内部节点
    private class Node {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkQueue() {
        this.head = new Node(null, null);
        this.tail = null;
        N = 0;
    }

    /**
     * 对列是否为空
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 队列中的元素个数
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 入队操作: 让当前入队的元素变为链表新尾结点
     * @param t 入队数据
     */
    public void enQueue(T t) {
        //当前位尾结点为null,直接添加
        if (tail == null) {
            tail = new Node(t, null);
            head.next = tail;
        } else {
            //当前尾结点不为null,将新节点链到尾结点上，更新尾结点为新插入的节点
            Node oldTail = tail; //记录旧的尾结点
            tail = new Node(t, null);
            oldTail.next = tail;
        }
        N++;
    }

    /**
     * 出队: 每次取出的都是头结点指向的节点(头结点的下一个节点)
     * @return 出队元素
     */
    public T outQueue() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        //因为出队列是在删除元素，因此如果队列中的元素被删除完了，需要重置tail
        if (isEmpty()) {
            tail = null;
        }
        return oldFirst.data;
    }

    /**
     * 当前队首元素
     * @return
     */
    public T peek() {
        if (isEmpty()) {
            System.err.println("当前队列为空！");
            return null;
        }
        return head.next.data;
    }

    /**
     * 当前队尾元素
     * @return
     */
    public T end() {
        if (isEmpty()) {
            System.err.println("当前队列为空！");
            return null;
        }
        return tail.data;
    }

    /**
     * 迭代遍历
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
