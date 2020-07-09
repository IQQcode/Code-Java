package iqqcode.algorithm.topic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-08 19:05
 * @Description:判断二分搜索树是否为完全二叉树
 */
public class CompleteBinTree<E> {

    private Node root;

    public boolean isCompleteBinTree() {
        if(root == null)   return false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            //TODO
            //要求是叶子节点，但是此时不是叶子节点
            if (leaf && !isLeaf(node))  return false;

            if (node.left != null) {
                queue.add(node.left);
            } else if (node.right != null) {
                //node.left == null && node.right != null
                return false;
            }

            if (node.right != null) {
                queue.add(node.right);
            } else {
                // node节点之后的节点均为叶子节点
                // node.left == null && node.right == null
                // node.left != null && node.right == null
                leaf = true;
            }
        }
        return true;
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
}
