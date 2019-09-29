package BinTree.BinSearchTree;

import java.util.Queue;
import BinTree.BinTreeInterface.BinTree;
import java.util.LinkedList;

/**
 * @Comparable<E> 指定了泛型上限
 */
public class BinSearchTree<E extends Comparable> implements BinTree<E> {
    /**
     * 内部类定义节点
     * @Description: 二叉树的节点
     */
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
     * 以当前node节点作为根节点,插入新元素e
     * @param e
     */
    @Override
    public void add(E e) {
        root = add(root,e);
    }

    /**
     * 以当前node节点作为根节点,插入新元素e
     * 返回插入后新树的根节点
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
        //如果插入的是重复元素,直接 return
        return node;
    }

    /**
     * 是否包含某一元素
     * @param e
     * @return
     */
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
        // 根节点的值恰好为要找的值
        if (node.data.equals(e)) {
            return true;
        }
        // 左子树递归
        else if (e.compareTo(node.data) < 0) {
            return contains(node.left,e);
        }
        // 右子树递归
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
        if (node == null) {
            return;
        }
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
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    @Override
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println(temp.data);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    @Override
    public E getMin() {
        if(root == null) {
            throw new IllegalArgumentException("BST is Empty! ");
        }
        Node minNode = getMinNode(root);
        return minNode.data;
    }
    private Node getMinNode(Node node) {
        if(node == null) {
            return node;
        }
        return getMinNode(node.left);
    }

    @Override
    public E getMax() {
        if(root == null) {
            throw  new IllegalArgumentException("BST is Empty!");
        }
        Node maxNode = getMaxNode(root);
        return maxNode.data;
    }

    private Node getMaxNode(Node node) {
        if(node == null) {
            return node;
        }
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

    /**
     * 前序遍历层级输出,覆写 toString()
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateTreeStruct(root,0,res);
        return res.toString();
    }

    /**
     * 前序遍历层级输出
     * @param node 开始遍历的节点
     * @param depth 层数
     * @param res 输出方式
     */
    private void generateTreeStruct(Node node,int depth,StringBuilder res) {
        if (node == null) {
            res.append("null"+"\n");
            return;
        }
        //访问当前节点
        res.append(generateLayers(depth) + node.data + "\n");
        //递归访问左子树
        generateTreeStruct(node.left,depth + 1,res);
        //递归访问右子树
        generateTreeStruct(node.right,depth + 1,res);
    }

    /**
     * 根据传入的层数输出‘--’
     * @param depth
     * @return
     */
    private String generateLayers(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < depth;i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}
