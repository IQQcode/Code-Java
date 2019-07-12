package BinSearch_Tree;

import java.util.Queue;
import BinTree.BinTree;
import java.util.LinkedList;


public class BinSearchTree<E extends Comparable<E>> implements BinTree<E> {

    private class Node {
        E data;
        Node left;
        Node right;
        public Node(E data) {
            this.data = data;
        }
    }

    //根节点
    private Node root;

    //二叉树节点个数
    private int size;


    @Override
    public void add(E e) {
        root = add(root,e);
    }
    /**
     * 以当前node作为根节点，插入元素为e的节点
     * 返回插入后的树的根节点
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node,E e) {
        if (node == null) {
            Node newNode = new Node(e);
            size ++;
            return newNode;
        }
        // 判断此时e到底在左树还是右树插入
        if (e.compareTo(node.data) < 0) {
            node.left = add(node.left,e);
        }
        if (e.compareTo(node.data) > 0) {
            node.right = add(node.right,e);
        }
        return node;
    }

//    /**
//     * 以指定的node为根节点，插入指定元素e
//     * @param node
//     * @param e
//     */
//    private void add(Node node,E e) {
//        // 插入的值刚好是当前树根节点的值
//        if (node.data.compareTo(e) == 0) {
//            return;
//        }
//        // 找到插入位置，在左子树做插入
//        else if (e.compareTo(node.data) < 0 && node.left == null) {
//            Node newNode = new Node(e);
//            node.left = newNode;
//            size ++;
//        }
//        else if (e.compareTo(node.data) > 0 && node.right == null) {
//            Node newNode = new Node(e);
//            node.right = newNode;
//            size ++;
//        }
//        else if (e.compareTo(node.data) < 0) {
//            // 递归寻找左树插入位置
//            add(node.left,e);
//        }
//        else {
//            // 递归寻找右树插入位置
//            add(node.right,e);
//        }
//    }



    @Override
    public boolean contains(E e) {
        if (root == null) {
            return false;
        }
        // 以根节点开始递归的查找元素
        return contains(root,e);
    }

    private boolean contains(Node node,E e) {
        // 终止条件
        if (node == null) {
            return false;
        }
        if (node.data.equals(e)) {
            return true;
        }
        else if (e.compareTo(node.data) < 0) {
            return contains(node.left,e);
        }
        else {
            return contains(node.right,e);
        }
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 以当前节点作为根节点进行前序遍历
     * @param node
     */
    private void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }
    /**
     *以node为根节点进行中序遍历
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    @Override
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println(temp.data);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    @Override
    public E getMin() {
        if(root == null)
            throw new IllegalArgumentException("BST is Empty! ");
        Node minNode = getMinNode(root);
        return minNode.data;
    }
    private Node getMinNode(Node node) {
        if(node == null)
            return node;
        return getMinNode(node.left);
    }

    @Override
    public E getMax() {
        if(root == null)
            throw  new IllegalArgumentException("BST is Empty!");
        Node maxNode = getMaxNode(root);
        return maxNode.data;
    }

    private Node getMaxNode(Node node) {
        if(node == null)
            return node;
        return getMaxNode(node.right);
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
        return size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateTreeStruct(root,0,res);
        return res.toString();
    }
    private void generateTreeStruct(Node node,int depth,StringBuilder res) {
        if (node == null) {
            res.append("null"+"\n");
            return;
        }
        res.append(generateGang(depth)+node.data+"\n");
        generateTreeStruct(node.left,depth+1,res);
        generateTreeStruct(node.right,depth+1,res);
    }
    private String generateGang(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < depth;i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
