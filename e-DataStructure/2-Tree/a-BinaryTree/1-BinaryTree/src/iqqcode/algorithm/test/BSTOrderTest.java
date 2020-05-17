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

        System.out.println("[中序遍历]");
        tree.inOrder();
    }
}
