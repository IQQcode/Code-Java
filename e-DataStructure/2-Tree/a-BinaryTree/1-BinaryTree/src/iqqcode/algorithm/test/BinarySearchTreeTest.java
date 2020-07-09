package iqqcode.algorithm.test;

import iqqcode.algorithm.bintree.BinarySearchTree;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-17 14:41
 * @Description:
 */
public class BinarySearchTreeTest {
    @Test
    public  void testBinTreeLink() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        //构建二分搜索树, 往树中添加数据
        int[] arr = {9, 4, 10, 2, 7, 12, 1, 3, 6, 8, 11, 5};
        for (int i = 0; i < arr.length; i++) {
            //构建二分搜索树
            tree.add(arr[i]);
        }

        /**
         *                              9
         *                           /     \
         *                          4        10
         *                       /    \        \
         *                     2       7 (n)    12
         *                    /  \   /   \     /  \
         *                   1   3  6     8   11  null
         *                         / \
         *                        5  null
         *                      /
         *                     null
         */

        System.out.println("二叉树中元素个数为： " + tree.size());

        System.out.println("是否包含元素4?  ---" + tree.contains(4));

        System.out.println("二叉树中[最小的元素]为：" + tree.getMin());
        System.out.println("二叉树中[最大的元素]为：" + tree.getMax());


        System.out.println("二叉树的最大深度为：" + tree.maxDepth());
        System.out.println("二叉树的最大深度为(loop)：" + tree.maxDepth_loop());

        //删除节点
        tree.remove(9);
        System.out.println("删除节点后，是否包含元素?  ---" + tree.contains(9));
        //删除最小节点
        System.out.println("删除最小节点" + tree.removeMin());
        //删除最大节点
        System.out.println("删除最大节点" + tree.removeMax());
        System.out.println("删除后元素个数为： " + tree.size());

        System.out.println("**************************************************");
        tree.inOrder();
    }
}
