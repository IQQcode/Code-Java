package DataStruct.Queue;

public interface Queue<E> {

    /**
     * 元素⼊队列
     * @param e 要插入的元素
     */
    void inQueue(E e);


    /**
     * 返回队首元素并且出队
     * @throws NullPointerException 队列为空
     * @return 队⾸元素
     */
    E outQueue();


    /**
     * 返回队⾸元素但不不出队
     * @throws NullPointerException 队列为空
     * @return 队首元素
     */
    E peek();

    /**
     * 当前队列的长度
     * @return
     */
    int getSize();

    /**
     *判空
     * @return
     */
    boolean isEmpty();
}