package DataStruct.Queue;

public interface Queue<E> {

    /**
     * 元素⼊入队列列
     * @param e 要插⼊入的元素
     */
    void inQueue(E e);


    /**
     * 返回队⾸首元素并且出队
     * @throws NullPointerException 队列列为空
     * @return 队⾸首元素
     */
    E outQueue();


    /**
     * 返回队⾸首元素但不不出队
     * @throws NullPointerException 队列列为空
     * @return 队⾸首元素
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