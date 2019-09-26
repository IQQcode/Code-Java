package BinTreeInterface;

/**
 * BinTree
 *
 * @blame Android Team
 */
public interface BinTree<E> {
    /**
     * @description:前序遍历
     */
    void preOrder();

    /**
     * @description:中序遍历
     */
    void inOrder();

    /**
     * @description:后序遍历
     */
    void postOrder();

    /**
     * @description:层序遍历
     */
    void levelOrder();

    /**
     * 添加元素
     * @param e
     */
    void add(E e);

    /**
     * 是否包含元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 取得最小值
     * @return
     */
    E getMin();

    /**
     * 取得最大值
     * @return
     */
    E getMax();

    /**
     * 移除最小值
     * @return
     */
    E removeMin();

    /**
     * 移除最大值
     * @return
     */
    E removeMax();

    /**
     * 移除二叉树中指定值的节点
     * @param e
     * @return
     */
    boolean remove(E e);

    /**
     * 节点个数
     * @return
     */
    int size();
}
