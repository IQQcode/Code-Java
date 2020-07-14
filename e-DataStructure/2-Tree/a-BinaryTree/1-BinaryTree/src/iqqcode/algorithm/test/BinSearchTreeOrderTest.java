package iqqcode.algorithm.test;

import iqqcode.algorithm.bintree.BinarySearchTree;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-17 14:41
 * @Description:BST遍历测试
 */

public class BinSearchTreeOrderTest {
    @Test
    public  void testPrev() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        //往树中添加数据
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(3);

        /**
         *                            5
         *                         /     \
         *                        2       7
         *                      /   \   /   \
         *                     1    4  6     8
         *                         /
         *                         3
         */

        System.out.println("二叉树中元素个数为： " + tree.size());

        System.out.println("[前序遍历]");
        //tree.preOrder();
        tree.preOrderNR();
    }

    @Test
    public void testIn() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        //往树中添加数据
        int[] arr = {5, 2, 7, 1, 4, 6, 8, 3};
        for (int i = 0; i < arr.length; i++) {
            //构建二分搜索树
            tree.add(arr[i]);
        }

        System.out.println("二叉树中元素个数为： " + tree.size());

        System.out.println("[中序遍历]");
        //tree.inOrder();
        tree.inOrderNR();
    }

    @Test
    public  void testPost() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        //往树中添加数据
        int[] arr = {5, 2, 7, 1, 4, 6, 8, 3};
        for (int i = 0; i < arr.length; i++) {
            //构建二分搜索树
            tree.add(arr[i]);
        }

        System.out.println("二叉树中元素个数为： " + tree.size());

        System.out.println("[后序遍历]");
        //tree.postOrder();
        //tree.postOrderNR_Stack();
        tree.postOrderNR();
    }

    @Test
    public  void testLevel() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        //往树中添加数据
        int[] arr = {5, 2, 7, 1, 4, 6, 8, 3};
        for (int i = 0; i < arr.length; i++) {
            //构建二分搜索树
            tree.add(arr[i]);
        }

        System.out.println("二叉树中元素个数为： " + tree.size());
        System.out.println("[层序遍历]");
        tree.levelOrder();
    }

    @Test
    public void testLevelRV() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        //往树中添加数据
        //int[] arr = {5, 2, 7, 1, 4, 6, 8, 3};
        int[] arr = {3,0,4,1,5,2};
        for (int i = 0; i < arr.length; i++) {
            //构建二分搜索树
            tree.add(arr[i]);
        }

        System.out.println("二叉树中元素个数为： " + tree.size());
        System.out.println("[层序遍历]");
        tree.levelOrderRV();
    }

}
