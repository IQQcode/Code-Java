package iqqcode.algorithm.list;

import java.util.Iterator;

/**
 * @Author: Mr.Q
 * @Date: 2019-10-13 12:47
 * @Description:单向链表
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
        this.N = 0;
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
     * 读取并返回链表中的第index个元素的值(注意初始节点不是头结点)
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
    public void add(T t) {
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
     * 在链表的第index个元素之前插入一个值为t的数据元素(尾插)
     * @param index
     * @param t
     */
    public void add(int index,T t) {
        //找到index位置前一个结点
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //找到index位置的结点
        Node curr = prev.next;
        //创建新结点，并且新结点需要指向原来index位置的结点
        Node newNode = new Node(t, curr);
        //原来index位置的前一个节点指向新结点即可(即在index前一个位置和index之间插入了新节点)
        prev.next = newNode;
        //元素的个数+1
        N++;
    }

    /**
     * 链表头插法
     * @param t
     */
    public void insert(T t) {
        //1.构造新节点
        Node node = new Node(t,null);
        //2.新节点指向头结点之后的节点
        node.next = head.next;
        //3.头结点指向新节点
        head.next = node;
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

    //反转单链表
    public void reverse() {
        //判断当前链表是否为空链表，如不是则反转链表
        if (isEmpty()) {
            return;
        }
        //头结点无元素，从有元素的节点开始
        reverse(head.next);
    }

    /**
     * 反转指定节点，并返回反转后的结果
     * @param curr 反转的指定节点
     * @return 反转后的节点
     */
    private Node reverse(Node curr) {
        //出口为要反转的节点是链表的最后一个节点
        if (curr.next == null) {
            //首节点的下一个节点是最后一个节点
            head.next = curr;
            return curr;
        }
        //如果此时curr不是最后一个节点
        //递归反转当前节点(curr)的下一个节点prev,反转之后prev成为curr的上一个节点
        //返回值就是链表反转后，当前节点(curr)的上一个节点(prev)
        Node prev = reverse(curr.next);
        //让返回节点的下一个节点变为当前节点，即让prev指向curr
        prev.next = curr;
        //断开当前节点curr对prev的指向(防止成环)
        curr.next = null;
        return curr;
    }

    /**
     * 实例化Iterator对象，Iterator是接口，用内部类来实例化
     * @return
     */
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
                //指向第一个存储数据的节点
                node = node.next;
                return node.data;
            }
        };
    }
}
