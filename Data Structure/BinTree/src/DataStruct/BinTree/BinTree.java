package DataStruct.BinTree;

public interface BinTree<E> {
    /**
     * 二叉树插入
     * @param e
     */
    void add(E e);

    /**
     * 二叉树中是否包含指定元素
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 取得二叉树节点个数
     * @return
     */
    int getSize();
}
