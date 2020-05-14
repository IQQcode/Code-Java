package iqqcode.algorithm.link;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-14 09:22
 * @Description:无序符号表
 * @Attention:头结点不存放数据
 */
public class SymbolTable<Key , Value> {
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
    public SymbolTable() {
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

    //符号表中插入键值对
    public void put(Key key, Value value) {
        //符号表中已经存在了键为key的键值对时：那么只需要找到该结点，将 value覆盖即可
        //遍历链表，查找key是否存在
        Node node = head;
        while (node.next != null) { //没有到达链表尾部
            node = node.next;
            //判断node节点的键是否为key,如果是则替换覆盖value
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        //如果符号表中不存在键为key的键值：只需要创建新的结点，保存要插入的键值对
        Node newNode = new Node(key, value, null);
        //链表头部插入
        Node tempNode = head.next;
        newNode.next = tempNode;
        head.next = newNode;
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
