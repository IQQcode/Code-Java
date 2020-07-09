package iqqcode.algorithm.topic;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-08 19:12
 * @Description:翻转二叉树
 * Link: https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class FlipBinaryTree {
    /**
     * 前序遍历
     * @param root
     * @return
     */
    public Node invertTree(Node root) {
        if (root == null)   return  root;
        //TODO Exchange
        Node temp  = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
