package iqqcode.algorithm.queue;

import java.util.Iterator;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-10 15:06
 * @Description:队列--数组实现
 */
public class ArrayQueue<T> implements Iterable{
    private Object[] elements;
    //队头索引下标
    private int head;
    //队尾索引下标
    private int tail;
    //队列中的元素个数
    private int N;
    //队列容量
    private int maxsize;

    //数组初始化
    public ArrayQueue(int maxsize) {
        elements = new Object[maxsize];
        this.maxsize = maxsize;
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
     * 区别于栈的扩容
     * 入队操作: 随着不断地出队入队，数组中剩余的数据需要不断搬移
     * 防止数组中还有空闲空间，无法继续往队列列中添加数据
     * @param t 入队数据
     */
    public boolean enQueue(T t) {
        //队列已满，需要扩容
        if (tail == maxsize) {
            // tail == capacity && head == 0 表示队列列已满
            if (head == 0) {
                System.err.println("队列列已满");
                throw new ArrayIndexOutOfBoundsException();
            }else {
                // 数据搬移
                for (int i = head; i < tail; i++) {
                    elements[i - head] = elements[i];
                }
                // 数据搬移后更更新两个指针位置
                tail -= head;
                head = 0;
            }
        }
        elements[tail++] = t;
        N++;
        return true;
    }

    /**
     * 出队: 每次取出的都是头结点指向的节点(头结点的下一个节点)
     * @return 出队元素
     */
    public T outQueue() {
        if (head == tail) {
            System.err.println("当前队列为空！");
            throw new NullPointerException();
        }
        N--;
        return (T) elements[head++];
    }

    /**
     * 当前队首元素
     * @return
     */
    public T peek() {
        if (head == tail) {
            System.err.println("当前队列为空！");
            throw new NullPointerException();
        }
        return (T) elements[head];
    }

    /**
     * 当前队尾元素
     * @return
     */
    public T end() {
        if (head == tail) {
            System.err.println("当前队列为空！");
            throw new NullPointerException();
        }
        return (T) elements[tail-1];
    }

    /**
     * 提供遍历方式
     * @return
     */
    @Override
    public Iterator<Object> iterator() {
        return new Iterator () {

            private int current;

            @Override
            public boolean hasNext() {
                return current < N;
            }

            @Override
            public Object next() {
                return elements[current++];
            }
        };
    }
}
