package iqqcode.algorithm.test;

import iqqcode.algorithm.bintree.BinSearchTree;
import org.junit.Test;

public class TestBinTree {
    @Test
    public  void testBinTreeLink() {
        BinSearchTree<Integer> tree = new BinSearchTree<>();
        tree.add(9);
        tree.add(4);
        tree.add(10);
        tree.add(2);
        tree.add(7);
        tree.add(12);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(8);
        tree.add(11);
        tree.add(5);
        System.out.println("二叉树中元素个数为： " + tree.getSize());

        System.out.println("是否包含元素4?  ---" + tree.contains(4));

        System.out.println("二叉树中[最小的元素]为：" + tree.getMin());
        System.out.println("二叉树中[最大的元素]为：" + tree.getMax());
        //System.out.println("二叉树的最大深度为：" + tree.maxDepth());

        //删除节点
        tree.removeNode(4);
        System.out.println("删除节点4后，是否包含元素?  ---" + tree.contains(4));
        //删除最小节点
        System.out.println("删除最小节点" + tree.removeMin());
        //删除最大节点
        System.out.println("删除最大节点" + tree.removeMax());
        System.out.println("删除后元素个数为： " + tree.getSize());
        tree.inOrder();
    }
}
