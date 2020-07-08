package iqqcode.algorithm.bintree;

import java.util.LinkedList ;
import java.util.Queue ;
import java.util.Stack ;

/**
 * 递归实现二分搜索树
 * 这里设计的树是不存储重复元素的, 重复添加元素只保存一个
 * @author 七夜雪
 *
 */
public class BSTree<E extends Comparable<E>> {

    // 根节点
    private Node root ;
    // 树容量
    private int size ;

    public BSTree() {
        this.root = null ;
        this.size = 0 ;
    }

    public boolean isEmpty() {
        return size == 0 ;
    }

    public int getSize(){
        return size;
    }

    /**
     * 向二分搜索树上添加节点
     * @param e
     */
    public void add(E e) {
        root = add(root, e) ;
    }

    /**
     * 向以node节点为根节点的树上添加节点e
     * 递归方法
     * @param node
     * @param e
     */
    private Node add(Node node, E e) {
        // 递归终止条件
        if (node == null) {
            size++ ;
            return new Node(e) ;
        }

        // 添加的元素小于当前元素, 向左递归
        if (node.e.compareTo(e) > 0) {
            node.left = add(node.left, e) ;
            // 添加的元素小于当前元素, 向右递归
        } else if (node.e.compareTo(e) < 0) {
            node.right = add(node.right, e) ;
        }

        return node ;
    }

    /**
     * 判断树中是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e) ;
    }

    /**
     * 判断树中是否包含元素e
     * 递归方法
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        // 递归终结条件
        if (node == null) {
            return false ;
        }

        if (node.e.compareTo(e) == 0) {
            return true;
        } else if (node.e.compareTo(e) > 0) {
            return contains(node.left, e) ;
        } else { // node.e < e
            return contains(node.right, e) ;
        }

    }

    /**
     * 前序遍历树
     */
    public void preOrder() {
        preOrder(root) ;
    }

    /**
     *
     * 前序遍历的递归方法, 深度优先
     * 前序遍历是指,先访问当前节点, 然后再访问左右子节点
     * @param node
     */
    private void preOrder(Node node) {
        // 递归终止条件
        if (node == null) {
            return ;
        }

        // 1. 前序遍历先访问当前节点
        System.out.println(node.e) ;
        // 2. 前序遍历访问左孩子
        preOrder(node.left) ;
        // 3. 前序遍历访问右孩子
        preOrder(node.right) ;
    }

    /**
     * 前序遍历的非递归方法, 深度优先
     * 这里使用栈进行辅助实现
     * 前序遍历是指,先访问当前节点, 然后再访问左右子节点
     */
    public void preOrderNR() {
        // 使用栈辅助实现前序遍历
        Stack<Node> stack = new Stack<>();
        /*
         * 前序遍历的过程就是先访问当前节点, 然后再访问左子树, 然后右子树
         * 所以使用栈实现时, 可以先将当前节点入栈, 当前节点出栈时,
         * 分别将当前节点的右孩子, 左孩子压入栈
         */
        // 首先将根节点压入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            // 前序遍历当前节点
            System.out.println(cur.e) ;
            // 由于栈是后入先出, 前序遍历是先左孩子, 再右孩子, 所以这里需要先将右孩子压入栈
            if (cur.right != null) {
                stack.push(cur.right);
            }

            if (cur.left != null) {
                stack.push(cur.left);
            }

        }

    }

    /**
     * 中序遍历树, 深度优先
     */
    public void inOrder() {
        inOrder(root) ;
    }

    /**
     *
     * 中序遍历的递归方法, 深度优先
     * 中序遍历指的是访问当前元素的顺序放在访问左右子节点之间
     * 中序遍历的结果是有序的
     * @param node
     */
    private void inOrder(Node node) {
        // 递归终止条件
        if (node == null) {
            return ;
        }

        // 1. 中序遍历访问左孩子
        inOrder(node.left) ;
        // 2. 中序遍历先访问当前节点
        System.out.println(node.e) ;
        // 3. 中序遍历访问右孩子
        inOrder(node.right) ;

    }

    /**
     * 后序遍历树, 深度优先
     */
    public void postOrder() {
        postOrder(root) ;
    }

    /**
     *
     * 后序遍历的递归方法, 深度优先
     * 后序遍历指的是访问当前元素的顺序放在访问左右子节点之后
     * @param node
     */
    private void postOrder(Node node) {
        // 递归终止条件
        if (node == null) {
            return ;
        }

        // 1. 后序遍历访问左孩子
        postOrder(node.left) ;
        // 2. 后序遍历访问右孩子
        postOrder(node.right) ;
        // 3. 后序遍历先访问当前节点
        System.out.println(node.e) ;
    }

    /**
     * 层序遍历, 从左到右一层一层遍历
     * 借助队列实现
     */
    public void levelOrder(){
        // LinkedList实现了Queue接口
        Queue<Node> queue = new LinkedList<>();
        /*
         * 遍历过程:
         * 1. 首先根节点入队
         * 2. 每次出队时, 都将当前节点的左右孩子先后入队
         * 3. 如果队列为空的话, 则表示层序遍历结束
         *      5
         *    /   \
         *   3    6
         *  / \    \
         * 2  4     8
         * 针对上面的二分搜索树, 详细描述一下层序遍历步骤
         * 1. 5入队, 队列元素 : head->[5]<-tail
         * 2. 5出队, 5的左子树3, 6入队, 由于队列是先入先出(FIFO), 所以先左后右, 队列元素 : head->[3, 6]<-tail
         * 3. 3出队, 2, 4入队, 队列元素  : head->[6, 2, 4]<-tail
         * 4. 6出队, 左孩子为空,所以8入队, 队列元素  : head->[2, 4, 8]<-tail
         * 5. 2,4,8依次出队, 由于这三个节点都是叶子节点, 无子节点, 所以这三个节点出队后队列为空, 层序遍历完成
         * 6. 按照出队的顺序演示的遍历结果为 : 5 3 6 2 4 8
         */
        queue.add(root);

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 查找树中最小元素
     * @return
     */
    public E minimum(){
        if (size == 0) {
            throw new IllegalArgumentException("BSTree is empty");
        }
        return minimum(root).e;
    }

    /**
     * 查找以node为根节点的最小元素, 递归方法
     * @param node
     * @return
     */
    private Node minimum(Node node){
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 查找树中最大元素
     * @return
     */
    public E maximum(){
        if (size == 0) {
            throw new IllegalArgumentException("BSTree is empty");
        }
        return maximum(root).e;
    }

    /**
     * 查找以node为根节点的最大元素, 递归方法
     * @param node
     * @return
     */
    private Node maximum(Node node){
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除二分搜索树中的最小值
     * @return
     */
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根节点的树的最小值
     * @param node
     * @return 返回删除后的新的二分搜索树的根
     */
    private Node removeMin(Node node){
        // 递归终止条件
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除二分搜索树中的最大值
     * @return
     */
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除以node为根节点的树的最大值
     * @param node
     * @return 返回删除后的新的二分搜索树的根
     */
    private Node removeMax(Node node){
        // 递归终止条件
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMin(node.right);
        return node;
    }

    /**
     * 删除指定元素e所在的节点
     * @param e
     */
    public void remove(E e){
        root = remove(root, e);
    }

    /**
     * 删除以node为根节点中的二分搜索树中
     * @param node
     * @param e
     * @return 返回删除后的新二分搜索树的根节点
     */
    private Node remove(Node node, E e){
        if (node == null) {
            return null;
        }

        // node.e > e
        if (node.e.compareTo(e) > 0) {
            node.left =remove(node.left, e);
            return node;
            // node.e < e
        } else if (node.e.compareTo(e) < 0) {
            node.right = remove(node.right, e);
            return node;
        } else { // e == node.e
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 查找待删除节点的后继节点
            // 用后继节点替换当前待删除节点

            // 查找后继节点, 从待删除节点的右子树,查找最小值
            Node successor = minimum(node.right);
            /*
             *  需要注意的是, 这里removeMin中进行了size--操作,
             *  但是实际上最小的元素变成了successor, 并没有删除
             *  所以按照逻辑的话, 这里应该有一个size++
             *  但是后面删除了元素之后,需要再进行一次size--, 所以这里就不对size进行操作了
             */
            successor.right = removeMin(node.right);
            successor.left = node.left;
            // 后继节点完成替换, 删除当前节点
            node.left = node.right = null;
            return successor;
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     * @param node 根节点
     * @param depth 深度
     * @param res 用于拼接字符串的StringBuilder
     * @return
     */
    private void generateString(Node node, int depth, StringBuilder res){
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth)).append(node.e + "\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }

    private StringBuilder generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res;
    }

    /**
     * 二分搜索树节点类
     * @author 七夜雪
     *
     */
    private class Node {
        public E	e ;
        // 左右子树
        public Node	left , right ;

        public Node(E e) {
            this.e = e ;
            this.left = null ;
            this.right = null ;
        }
    }
}