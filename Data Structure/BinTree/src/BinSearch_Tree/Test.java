package BinSearch_Tree;

import BinTree.BinTree;



public class Test {
    public static void main(String[] args) {
        BinTree<Integer> binTree = new BinSearchTree<>();
        int[] num = new int[] {28,16,13,22,30,29,42};
        for (int i = 0;i < num.length;i++) {
            binTree.add(num[i]);
        }
        binTree.levelOrder();
        System.out.println("节点个数为：" + binTree.size());
    }
}
