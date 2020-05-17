package iqqcode.algorithm.test;

import iqqcode.algorithm.bintree.BinarySearchTree;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-17 14:41
 * @Description:
 */
public class BSTTest {
    @Test
    public  void testBinTreeLink() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        //构建二分搜索树
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(3);
        System.out.println("二叉树中元素个数为： " + tree.size());

        System.out.println("是否包含元素4 ?  " + tree.contains(4));

        System.out.println("二叉树中[最小的元素]为：" + tree.getMin());
        System.out.println("二叉树中[最大的元素]为：" + tree.getMax());
        System.out.println("二叉树的最大深度为：" + tree.maxDepth());

        //删除节点
        tree.remove(3);
        System.out.println(tree.contains(3));
        //删除最小节点
        tree.removeMin();
        //删除最大节点
        tree.removeMax();
        System.out.println("删除后元素个数为： " + tree.size());
        tree.inOrder();
    }
}
