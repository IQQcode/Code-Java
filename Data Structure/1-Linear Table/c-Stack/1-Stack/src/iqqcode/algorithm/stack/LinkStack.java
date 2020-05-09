package iqqcode.algorithm.stack;

import java.util.Iterator;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-09 13:48
 * @Description:基于链表--栈
 */
public class LinkStack<T> implements Iterable<T> {

    //记录头结点
    private Node head;
    //占中元素个数
    private int N;

    private class Node {
        T data;
        Node next;
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkStack() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 当前栈中元素个数
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 压栈
     * @param data
     */
    public void push(T data) {
        //找到头结点(head)指向的节点ans
        Node ans = head.next;
        //创建新节点node
        Node node = new Node(data, null);
        //让头结点指向新节点
        head.next = node;
        //让新节点node指向原来的节点ans
        node.next = ans;
        //元素个数加一
        N++;
    }

    /**
     * 弹栈
     * @return
     */
    public T pop() {
        if (isEmpty()) {
            System.err.println("当前栈表为空！");
        }
        //找到头结点指向的节点ans
        Node ans = head.next;
        //让头结点指向ans的下一个节点(让ans指向为空)
        head.next = ans.next;
        //元素个数减一
        N--;
        return ans.data;
    }

    /**
     * 栈顶元素
     * @return
     */
    public T peek() {
        if (isEmpty()) {
            System.err.println("当前栈表为空！");
        }
        return head.next.data;
    }

    /**
     * 提供遍历方式
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

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
