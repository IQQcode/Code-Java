package BinTree.DemoBinTree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: Mr.Q
 * @Date: 2019-09-26 23:35
 * @Description:
 */

public class DemoTree {

    /**
     * 二叉树节点
     */
    private static class TreeNode {
        int data = 0;
        TreeNode leftChild = null;
        TreeNode rightChild = null;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 二叉树输入序列
     *
     * @param inputList
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 前序遍历
     * @param node
     */
    public static void preOrderTraveral(TreeNode node) {
        if(node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 中序遍历
     * @param node
     */
    public static void inOrderTraveral(TreeNode node) {
        if(node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void postOrderTraveral(TreeNode node) {
        if(node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        inOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>
                (Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历: ");
        preOrderTraveral(treeNode);
        System.out.println("中序遍历: ");
        inOrderTraveral(treeNode);
        System.out.println("后序遍历: ");
        postOrderTraveral(treeNode);
    }
}
