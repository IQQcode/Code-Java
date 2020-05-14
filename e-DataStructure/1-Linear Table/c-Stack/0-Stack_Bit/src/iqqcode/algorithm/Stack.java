package iqqcode.algorithm;

public interface Stack<T> {
    /**
     * 入栈
     * @param t
     * @return
     */
    boolean push(T t);

    /**
     * 出栈
     * @return
     */
    T pop();

    /**
     * 返回栈顶元素(不出栈)
     * @return
     */
    T peek();

    /**
     * 当前栈顶元素个数
     * @return
     */
    int getSize();

    /**
     * 当前栈是否为空
     * @return
     */
    boolean isEmpty();
}
