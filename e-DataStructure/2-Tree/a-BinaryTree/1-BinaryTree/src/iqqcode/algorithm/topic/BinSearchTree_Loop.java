package iqqcode.algorithm.topic;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-17 12:44
 * @Description:二分搜索树--节点类无编号
 */
public class BinSearchTree_Loop<E extends Comparable<E>> {
    //记录根节点,默认root为null
    public Node root;
    //记录树中元素个数
    public int N;

    /****************************  前驱结点和后继节点    *****************************/

    /**
     *                                       9
     *                                  /        \
     *                                 4           15
     *                              /    \        /
     *                             2      7      11
     *                           /  \    /  \   /  \
     *                          1   3   6    8 10  13
     *                                            /  \
     *                                           12  null
     *
     * 【前驱结点】: 中序遍历时的前一个节点
     *
     *             predecessor = node.left.right.right ...[节点9]
     *             终止条件: right == null
     *
     *             特殊情况: node.left == null && node.parent != null [节点10]
     *             predecessor = node.parent.parent.parent ...
     *             终止条件: node在parent的右子树中
     *
     *             node.left == null && node.parent == null[节点1]
     *             --无前驱结点
     *
     * 【后继节点】: 中序遍历时的后一个节点
     */

    /**
     * 前驱结点
     * @param node
     * @return
     */
    public Node predecessor(Node node) {
        if (node == null)   return null;

        Node res = node.left;
        //前驱结点在左子树中(不断向右找)
        if (res != null) {
            while (res.right != null) {
                res =  res.right;
            }
            return  res;
        } else {
            //左子树为空，前驱结点在根节点或者右子树中
            //node节点为父节点的左子树, 就一直向上。从父节点、祖父节点中寻找前驱结点
            while (res.parent != null && node == node.parent.left) {
                node = node.parent;
            }
            //[情况1] node.parent == null
            //[情况2] node == node.parent.right (node为父节点右子节点)
            return node.parent;
        }
    }

    public Node successor(Node node) {
        if (node == null)   return null;

        Node res = node.right;
        //后继结点在右子树中(不断向左找)
        if (res != null) {
            while (res.left != null) {
                res =  res.left;
            }
            return  res;
        } else {
            //左子树为空，前驱结点在根节点或者右子树中
            //node节点为父节点的左子树, 就一直向上。从父节点、祖父节点中寻找前驱结点
            while (res.parent != null && node == node.parent.right) {
                node = node.parent;
            }
            //[情况1] node.parent == null
            //[情况2] node == node.parent.right (node为父节点右子节点)
            return node.parent;
        }
    }
}