package OJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution1 {
    List<Integer> list = new ArrayList<>();
    /**
     * 根据指定的根节点root，返回其前序遍历结果
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}
