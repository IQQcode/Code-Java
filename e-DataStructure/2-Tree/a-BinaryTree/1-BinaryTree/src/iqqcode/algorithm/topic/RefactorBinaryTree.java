package iqqcode.algorithm.topic;

import java.util.HashMap;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-09 16:28
 * @Description:
 */
class RefactorBinaryTree {

    private HashMap<Integer, Integer> map;
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        if(preLen != inLen)  return null;
        this.preorder = preorder;

        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, preLen-1, 0, inLen-1);
    }

    /**
     * 根据前序遍历数组的 [preL, preR] 和 中序遍历数组的 [inL, inR] 重新组建二叉树
     *
     * @param preL 前序遍历数组的区间左端点
     * @param preR 前序遍历数组的区间右端点
     * @param inL  中序遍历数组的区间左端点
     * @param inR  中序遍历数组的区间右端点
     * @return     构建的新二叉树的根结点
     */
    private TreeNode buildTree(int preL, int preR, int inL, int inR) {
        //如果树为空，直接返回
        if(preL > preR || inL >inR)  return null;

        //前序遍历根节点位置
        int pivot = preorder[preL];
        //中序遍历根节点位置
        int inPivot = map.get(pivot);
        //当前子树的根节点
        TreeNode root = new TreeNode(pivot);

        root.left = buildTree(preL + 1, (inPivot - inL) + preL, inL, inPivot - 1);
        root.right = buildTree(preL + (inPivot - inL)+1, preR, inPivot+1, inR);
        return root;
    }
}
