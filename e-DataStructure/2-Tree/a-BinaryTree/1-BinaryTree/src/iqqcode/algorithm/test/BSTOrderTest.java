package iqqcode.algorithm.test;

import iqqcode.algorithm.bintree.BinarySearchTree;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-17 14:41
 * @Description:BST遍历测试
 */
public class BSTOrderTest {
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
        System.out.println("二叉树中元素个数为： " + tree.size());

        System.out.println("[前序遍历]");
        tree.preOrder();
    }

    @Test
    public  void testIn() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        //往树中添加数据
        int[] arr = {9, 4, 10, 2, 7, 12, 1, 3, 6, 8, 11, 5};
        for (int i = 0; i < arr.length; i++) {
            //构建二分搜索树
            tree.add(arr[i]);
        }

        System.out.println("二叉树中元素个数为： " + tree.size());

        System.out.println("[中序遍历]");
        tree.inOrder();
    }

    @Test
    public  void testPost() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        //往树中添加数据
        int[] arr = {9, 4, 10, 2, 7, 12, 1, 3, 6, 8, 11, 5};
        for (int i = 0; i < arr.length; i++) {
            //构建二分搜索树
            tree.add(arr[i]);
        }

        System.out.println("二叉树中元素个数为： " + tree.size());

        System.out.println("[后序遍历]");
        tree.postOrder();
    }

    @Test
    public  void testLevel() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        //往树中添加数据
        int[] arr = {9, 4, 10, 2, 7, 12, 1, 3, 6, 8, 11, 5};
        for (int i = 0; i < arr.length; i++) {
            //构建二分搜索树
            tree.add(arr[i]);
        }

        System.out.println("二叉树中元素个数为： " + tree.size());
        System.out.println("[层序遍历]");
        tree.levelOrder();
    }
}
