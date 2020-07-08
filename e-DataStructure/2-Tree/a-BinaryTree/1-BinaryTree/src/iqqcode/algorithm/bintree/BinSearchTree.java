package iqqcode.algorithm.bintree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-07 22:10
 * @Description:
 */
public class BinSearchTree<E extends Comparable<E>> {

    private class Node {
        private E data;
        private Node left;
        private Node right;
        public Node(E data) {
            this.data = data;
        }
    }


    private Node root;

    private int size;

    public void add(E e) {
        if (root == null) {
            Node node = new Node(e);
            root = node;
            size ++;
        }
        add(root,e);
    }

    private void add(Node root,E e) {
        if (e.equals(root.data)) {
            return;
        }else if (e.compareTo(root.data) < 0 && root.left == null) {
            Node node = new Node(e);
            root.left = node;
            size ++;
        }else if (e.compareTo(root.data) > 0 && root.right == null) {
            Node node = new Node(e);
            root.right = node;
            size ++;
        }

        if (e.compareTo(root.data) < 0) {
            add(root.left,e);
        }

        if (e.compareTo(root.data) > 0) {
            add(root.right,e);
        }
    }


    public int getSize() {
        return size;
    }


    public boolean contains(E e) {
        return contains(root,e);
    }
    private boolean contains(Node root,E e) {

        if (root == null) {
            return false;
        }

        if (e.equals(root.data)) {
            return true;
        } else if (e.compareTo(root.data) < 0) {
            return contains(root.left,e);
        } else {
            return contains(root.right,e);
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {

        if (node == null) {
            return;
        }

        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.data);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }


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

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public E getMin() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty!");
        }
        return getMinNode(root).data;
    }

    private Node getMinNode(Node node) {
        if (node.left == null) {
            return node;
        }
        return getMinNode(node.left);
    }


    public E getMax() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty!");
        }
        return getMaxNode(root).data;
    }

    private Node getMaxNode(Node node) {

        if (node.right == null) {
            return node;
        }
        return getMinNode(node.right);
    }


    public E removeMin() {
        E result = getMin();
        root = removeMinNode(root);
        return result;
    }

    private Node removeMinNode(Node node) {
        if (node.left == null) {
            Node rightTree = node.right;
            node.right = null;
            size --;
            return rightTree;
        }
        node.left = removeMinNode(node.left);
        return node;
    }



    public E removeMax(){
        E ret = getMax();
        root = removeMax(root);
        return ret;
    }


    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void removeNode(E e) {
        root = removeNode(root,e);
    }

    private Node removeNode(Node node,E e) {
        if (node == null) {
            return null;
        } else if (e.compareTo(node.data) < 0) {
            node.left = removeNode(node.left,e);
            return node;
        } else if (e.compareTo(node.data) > 0) {
            node.right = removeNode(node.right,e);
            return node;
        } else {
            if (node.left == null) {
                Node rightTree = node.right;
                node.right = null;
                size --;
                return rightTree;
            }

            if (node.right == null) {
                Node leftTree = node.left;
                node.left = null;
                size --;
                return leftTree;
            } else {
                Node successor = getMinNode(node.right);
                successor.right = removeMinNode(node.right);
                successor.left = node.left;
                node.left = node.right = null;
                return successor;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node,int depth,StringBuilder res) {
        if (node == null) {
            res.append(generateDepth(0)+"null\n");
            return;
        }
        res.append(generateDepth(depth)+node.data+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }

    private String generateDepth(int depth) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < depth;i++) {
            sb.append("--");
        }
        return sb.toString();
    }
}