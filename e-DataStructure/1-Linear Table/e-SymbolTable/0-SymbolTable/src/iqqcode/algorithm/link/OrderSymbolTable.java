package iqqcode.algorithm.link;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-14 09:22
 * @Description:有序符号表 key值有序
 * @Attention:头结点不存放数据
 */
public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    //记录首节点
    private Node head;
    //记录符号表中元素个数
    private int N;

    //内部节点类
    private class  Node {
        private Key key; //键
        private Value value; //值
        private Node next; //下一个节点

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    //初始化符号表
    public OrderSymbolTable() {
        this.head = new Node(null , null, null);
        N = 0;
    }

    /**
     * 记录符号表中键值对的个数
     * @return
     */
    public int size() {
        return this.N;
    }

    /**
     * 有序符号表中插入键值对(如果存在则替换)
     * 需要两个临时变量来完成插入指向的交换：
     *         - 每一次向后遍历得到的当前节点curr
     *         - 当前节点(curr)的上一个节点prev
     * @Attention:插入节点时：大于向后继续走，小于停下插入值
     */
    public void put(Key key, Value value) {
        Node curr = head.next; //从第一个存储数据的节点开始
        Node prev = head;
        //key.compareTo(curr.key) > 0 待插入节点大于当前节点(curr)，继续向后遍历
        while (curr != null && key.compareTo(curr.key) > 0) { //没有到达链表尾部
            //变换节点，继续遍历
            prev = curr;
            curr = curr.next;
        }

        //待插入节点等于于当前节点(curr)，替换即可
        if (curr != null && curr.key.compareTo(key) == 0) {
            curr.value = value;
            return;
        }

        //待插入节点小于当前节点(curr)，将待插入节点newNode插入到当前节点(curr)之前
        Node newNode = new Node(key, value, curr);
        //链表头部插入
        prev.next = newNode;
        //元素个数+1
        N++;
    }

    //删除符号表中键为key的键值值对
    public void delete(Key key) {
        //找到键为key的结点，把该结点从链表中删除
        Node node = head;
        while (node.next != null) {
            //判断node结点的下一个结点的键是否为key(从头结点开始，但是头结点不存放数据，头结点的next节点开始遍历)
            if (node.next.key.equals(key)) {
                // 如果是，就删除该结点
                node.next = node.next.next; //key节点指向为空
                N--;
                return;
            }
            //如果不是，继续寻找
            node = node.next;
        }
    }

    /**
     * 获取键为key的Value值
     * @param key
     * @return
     */
    public Value get(Key key) {
        Node node = head;
        while (node.next != null) {
            node = node.next; //从存储数据的节点开始找(head.next)
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }
}
