package iqqcode.algorithm;

import java.util.Iterator;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-13 12:47
 * @Description:链表--单链表
 */
public class LinkList<T> implements Iterable<T> {

    //链表头结点
    private Node head;
    //记录链表的长度
    private int N;

    //结点类
    private class Node {
        //存储数据
        T data;
        //下一个结点data
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    //初始化单链表
    public LinkList() {
        //初始化头结点，链表为空，无指向
        this.head = new Node(null,null);
        //初始化元素个数
        this.N=0;
    }

    //清空链表
    public void clear() {
        //头结点无指向，链表长度为0
        head.next = null;
        this.N = 0;
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
     * 读取并返回链表中的第index个元素的值
     * @param index
     * @return
     */
    public T get(int index) {
        //通过循环,从头结点开始往后找，依次找index次，就可以找到对应的元素
        //node来记录第一个存储数据的节点
        Node node = head.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        //返回index节点处的数据域
        return node.data;
    }

    /**
     * 往链表中添加一个元素(尾插)
     * @param t
     */
    public void insert(T t) {
        //找到当前最后一个结点
        Node node = head; //从头结点开始往后找
        //创建新结点，保存元素t
        while (node.next != null) {
            //循环结束，node记录的是尾结点
            node = node.next;
        }
        //让当前最后一个结点指向新结点
        Node newNode = new Node(t, null);
        node.next = newNode;
        //元素的个数+1
        N++;
    }

    /**
     * 在链表的第index个元素之前插入一个值为t的数据元素
     * @param index
     * @param index
     */
    public void insert(int index,T t) {
        //找到index位置前一个结点
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //找到index位置的结点
        Node curr = prev.next;
        //创建新结点，并且新结点需要指向原来index位置的结点
        Node newNode = new Node(t, curr);
        //原来index位置的前一个节点指向新结点即可
        prev.next = newNode;
        //元素的个数+1
        N++;
    }

    /**
     * 删除并返回链表中第index个数据元素
     * @param index
     * @return
     */
    public T remove(int index) {
        //找到index位置的前一个节点
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //要找到index位置的结点
        Node curr = prev.next;
        //找到index位置的下一个结点
        Node nextNode = curr.next;
        //前一个结点指向下一个结点
        prev.next = nextNode;
        //元素个数-1
        N--;
        return curr.data;
    }

    /**
     * 返回链表中首次出现的指定的数据元素的位序号，若不存在，则返回-1
     * @param t
     * @return
     */
    public int indexOf(T t) {
        //从头结点开始到尾结点前一个节点，依次找到每一个结点，取出data，和t比较，如果相同，就找到了
        Node node = head;
        for (int i = 0; node.next != null; i++) {
            node = node.next;
            if (node.data.equals(t)) {
                return i;
            }
        }
        return - 1;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node node = head;
            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public Object next() {
                node = node.next;
                return node.data;
            }
        };
    }

    /*private class LIterator implements Iterator {
        private Node node;
        private LIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.data;
        }
    }*/
}
