package BinTree.BinSearchTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: Mr.Q
 * @Date: 2019-09-30 23:28
 * @Description:
 */
public class BinSearchTreeLoop {

    //二叉树节点
    private static class Node {
        int data = 0;
        Node leftChild = null;
        Node rightChild = null;

        Node(int data) {
            this.data = data;
        }
    }

    /**
     * 二叉树输入序列
     * @param inputList
     * @return
     */
    public static Node createBinaryTree(LinkedList<Integer> inputList) {
        Node node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new Node(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 前序遍历_循环
     * @param node
     */
    public static void preOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        Node treeNode = node;
        while(treeNode != null || stack.isEmpty()) {
            //访问左子树
            while(treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild; //指针
            }
            if(!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }

    }

    /**
     * 中序遍历
     * @param node
     */
    public static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.leftChild);
        System.out.println(node.data);
        inOrder(node.rightChild);
    }

    /**
     * 后序遍历
     * @param node
     */
    public static void postOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.leftChild);
        inOrder(node.rightChild);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>
                (Arrays.asList(new Integer[]{6, 4, 8, 3, 2, 5, 7, 9}));
        Node treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历: ");
        preOrder(treeNode);
        System.out.println("中序遍历: ");
        inOrder(treeNode);
        System.out.println("后序遍历: ");
        postOrder(treeNode);
    }
}
