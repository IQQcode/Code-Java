package iqqcode.algorithm.test;

import iqqcode.algorithm.bintree.BinarySearchTreeDemo;
import org.junit.Test ;


public class BSTDemoTest {
    static int[] nums = {9,4,10,2,7,12,1,3,6,8,11,5};
    static BinarySearchTreeDemo<Integer> bsTree;

    static {
        bsTree = new BinarySearchTreeDemo<>();
        for (int i = 0; i < nums.length; i++) {
            bsTree.add(nums[i]);
        }
    }

    @Test
    public void testOrder() {


        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

        System.out.println(bsTree);

        // 前序遍历, 5->3->2->4->6->8
        bsTree.preOrder();
        System.out.println("-------------------------------------------------");
        // 前序遍历非递归, 5->3->2->4->6->8
        bsTree.preOrderNR();
        // 中序遍历, 2->3->4->5->6->8
        bsTree.inOrder();
        System.out.println("-------------------------------------------------");
        // 后序遍历, 2->4->3->8->6->5
        bsTree.postOrder();

    }

    /**
     * 测试二分搜索树删除
     */
    @Test
    public void testRemove() {
        /*for (int i : nums) {
            System.out.println("------------------------" + i + "-------------------------");
            bsTree.remove(i);
            bsTree.inOrder();
        }*/
        bsTree.inOrder();
        System.out.println("----------------------------------");
        System.out.println("*******" + bsTree.getSize());

        System.out.println("//////////" + bsTree.minimum());
        System.out.println("//////////" + bsTree.maximum());
        System.out.println("----------------------------------");

        bsTree.remove(4);
        bsTree.removeMin();
        bsTree.removeMax();

        System.out.println("----------------------------------");

        System.out.println("*******" + bsTree.getSize());
        System.out.println("//////////" + bsTree.minimum());
        System.out.println("//////////" + bsTree.maximum());

        // 中序遍历, 2->3->4->5->6->8
        bsTree.inOrder();
    }
}