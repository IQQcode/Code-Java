package BinTree.BinSearchTree;

import BinTree.BinTreeInterface.BinTree;


public class TestMain {
    public static void main(String[] args) {
        BinTree<Integer> binTree = new BinSearchTree<>();
        int[] num = new int[] {6, 4, 8, 3, 2, 5, 7, 9};
        for (int i = 0;i < num.length;i++) {
            binTree.add(num[i]);
        }
        binTree.levelOrder();
        System.out.println("节点个数为：" + binTree.size());
        System.out.println("Binary Tree是否包含 9 ? " + binTree.contains(9));

        //System.out.println(); //Test Add()
        System.out.println(binTree);
    }
}
