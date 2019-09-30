package BinTree.BinSearchTreeMethod;

import BinTree.BinTreeInterface.BinTree;

/**
 * @Author: Mr.Q
 * @Date: 2019-09-29 17:18
 * @Description:
 */
public class addMethodBasic<E extends Comparable> implements BinTree<E> {

    private class Node {
        E data; //存放当前节点元素
        Node left; //左子树
        Node right; //右子树
        public Node(E data) {
            this.data = data;
        }
    }

    //根节点
    private Node root;

    //二叉树节点个数
    private int size;
    /**
     * 以指定的node为根节点，插入元素e
     * @param node
     * @param e
     */
    private void add(Node node,E e) {
        // 插入的值刚好是当前树根节点的值
        if (node.data.compareTo(e) == 0) {
            return;
        }
        // 找到插入位置，在左子树做插入
        else if (e.compareTo(node.data) < 0 && node.left == null) {
            Node newNode = new Node(e);
            node.left = newNode;
            size ++;
        }
        else if (e.compareTo(node.data) > 0 && node.right == null) {
            Node newNode = new Node(e);
            node.right = newNode;
            size ++;
        }
        else if (e.compareTo(node.data) < 0) {
            // 递归寻找左树插入位置
            add(node.left,e);
        }
        else {
            // 递归寻找右树插入位置
            add(node.right,e);
        }
    }

    @Override
    public void preOrder() { }

    @Override
    public void inOrder() { }

    @Override
    public void postOrder() { }

    @Override
    public void levelOrder() { }

    @Override
    public void add(E e) { }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public E getMin() {
        return null;
    }

    @Override
    public E getMax() {
        return null;
    }

    @Override
    public E removeMin() {
        return null;
    }

    @Override
    public E removeMax() {
        return null;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }


}
