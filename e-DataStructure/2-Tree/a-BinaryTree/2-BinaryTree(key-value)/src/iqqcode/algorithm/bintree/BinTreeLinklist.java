package iqqcode.algorithm.bintree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-16 09:23
 * @Description:二叉查找树---链表实现
 * @Solution:继承Comparable接口，对Key进行比较排序
 */
public class BinTreeLinklist<Key extends Comparable<Key>,Value> {
    //记录根节点
    private Node root; //默认root为null
    //记录树中元素个数
    private int N;

    //内部节点类
    private class Node {
        private Key key;  //键
        private Value value;  //值
        private Node left;  //左孩子
        private Node right;  //右孩子

        //初始化节点类
        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 获取树中元素个数
     * @return
     */
    public int size() {
        return N;
    }

    // 向树中添加元素(key-value)
    public void add(Key key, Value value) {
        root = add(root, key, value);
    }

    /**
     * 向指定的树中添加key-value,并返回添加元素后的新树
     *
     * @param node  给定需要添加元素的树的节点
     * @param key
     * @param value
     * @return 添加元素后的新树
     */
    private Node add(Node node, Key key, Value value) {
        //当前以node为根节点的树为空,插入的节点(node)作为数的根节点(root)
        if (node == null) {
            N++;
            return new Node(key, value, null, null);
        }
        //当前以node为根节点的树不为空,比较node节点的键与key的大小
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            //如果key大于node节点的键，则继续递归向下找node节点的右子树
            node.right = add(node.right, key, value);
        } else if (compare < 0) {
            //如果key小于node节点的键，则继续递归向下找node节点的左子树
            node.left = add(node.left, key, value);
        } else {
            //如果key等于于node节点的键，则替换node节点的值
            node.value = value;
        }
        return node;
    }

    /**
     * 查询树中指定key对应的value
     *
     * @param key
     * @return
     */
    public Value contains(Key key) {
        return contains(root, key);
    }

    /**
     * 从指定树中查找key对应的值
     *
     * @param node 给定需要添加元素的树的节点
     * @param key
     * @return
     */
    public Value contains(Node node, Key key) {
        //当前以node为根节点的树为空
        if (node == null) {
            return null;
        }
        //当前以node为根节点的树不为空
        //比较key和node节点的键的大小
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            //如果key大于node节点的键，则继续递归向下找node节点的右子树
            return contains(node.right, key);
        } else if (compare < 0) {
            //如果key小于node节点的键，则继续递归向下找node节点的左子树
            return contains(node.left, key);
        } else {
            //如果key等于于node节点的键，找到返回
            return node.value;
        }
    }

    //删除树中key对应的value
    public void remove(Key key) {
        remove(root, key);
    }

    /**
     * 删除指定树中key对应的value，并返回删除后的新树
     *
     * @param node 给定需要添加元素的树的节点
     * @param key
     * @return 删除后的新树
     */
    public Node remove(Node node, Key key) {
        //当前以node为根节点的树为空
        if (node == null) {
            return null;
        }

        //当前以node为根节点的树不为空，比较key和node节点的键的大小
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            //如果key大于node节点的键，则继续递归向下找node节点的右子树
            node.right = remove(node.right, key);
        } else if (compare < 0) {
            //如果key小于node节点的键，则继续递归向下找node节点的左子树
            node.left = remove(node.left, key);
        } else {
            // 如果key等于于node节点的键，则删除节点node

            //元素个数减一
            N--;

            //找到[要删除节点的]右子树中最小的节点(或者左子树中最大的节点)
            if (node.right == null) {
                //若要删除的节点的右子树为空，则直接返回其左子树
                return node.left;
            }

            if (node.left == null) {
                return node.right;
            }

            //寻找右子树最小节点
            Node minNode = node.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //删除右子树中最小节点
            Node n = node.right;
            //最小节点断开连接
            while (n.left != null) {
                //某个节点的下一个节点的下一个节点为空，则断开连接
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    //变换n节点
                    n = n.left;
                }
            }

            //让minNode节点补到原来待删除的node节点处
            minNode.left = node.left;
            minNode.right = node.right;
            node = minNode;
        }
        return node;
    }

    /**
     * 查找二叉树中最小键所在的节点
     *
     * @return
     */
    public Key getMin() {
        return getMin(root).key;
    }

    /**
     * 在指定树中寻找最校键所在的节点
     *
     * @param node
     * @return
     */
    private Node getMin(Node node) {
        if (node.left != null) {
            return getMin(node.left);
        } else {
            return node;
        }
    }

    /**
     * 查找二叉树中最大键所在的节点
     *
     * @return
     */
    public Key getMax() {
        return getMax(root).key;
    }

    private Node getMax(Node node) {
        if (node.right != null) {
            return getMin(node.right);
        } else {
            return node;
        }
    }

    /**
     * 获取整个树的最大深度
     * @return
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int max = 0;
        // 左子树的最大深度
        int leftMax = 0;
        // 右子树的最大深度
        int rightMax = 0;

        // 计算node结点左子树的最大深度
        if (node.left != null) {
            leftMax = maxDepth(node.left);
        }
        // 计算node结点右子树的最大深度
        if (node.right != null) {
            rightMax = maxDepth(node.right);
        }
        // 比较左子树最大深度和右子树最大深度，取较大值+1即可
        return leftMax > rightMax ? leftMax + 1 : rightMax + 1;
    }


    //============================== 遍历 ===============================


    /**
     * 前序遍历
     * 【总体思想】：首先需要另外创建一个空的队列，在判断二叉树不为空树的情况下,先将二叉树的根节点入队，
     * 然后在根节点出队的时候将它的左右孩子放到队列中，下一次它的左右孩子又是它左右子树的根节点，
     * 依次放到队列中，然后出队，直到队列为空。
     * <p>
     * 队列中存放的是key键，遍历是根据key获取到value
     *
     * @return
     */
    public Queue<Key> preOrder() {
        Queue<Key> keys = new LinkedList<>();
        preOrder(root, keys);
        return keys;
    }

    /**
     * 以当前节点作为根节点进行前序遍历
     *
     * @param node
     */
    private void preOrder(Node node, Queue<Key> keys) {
        if (node == null) {
            return;
        }
        //把node节点的key放到keys中
        keys.add(node.key);

        //递归遍历，把node节点的左子树的键放入队列
        if (node.left != null) {
            preOrder(node.left, keys);
        }

        //递归遍历，把node节点的右子树的键放入队列
        if (node.right != null) {
            preOrder(node.right, keys);
        }
    }

    /**
     * 中序遍历
     *
     * @return
     */
    public Queue<Key> inOrder() {
        Queue<Key> keys = new LinkedList<>();
        inOrder(root, keys);
        return keys;
    }

    private void inOrder(Node node, Queue<Key> keys) {
        if (node == null) {
            return;
        }

        //递归遍历，把node节点的左子树的键放入队列
        if (node.left != null) {
            inOrder(node.left, keys);
        }

        //把node节点的key放到keys中
        keys.add(node.key);

        //递归遍历，把node节点的右子树的键放入队列
        if (node.right != null) {
            inOrder(node.right, keys);
        }
    }

    /**
     * 后序遍历
     *
     * @return
     */
    public Queue<Key> postOrder() {
        Queue<Key> keys = new LinkedList<>();
        postOrder(root, keys);
        return keys;
    }

    private void postOrder(Node node, Queue<Key> keys) {
        if (node == null) {
            return;
        }

        //递归遍历，把node节点的左子树的键放入队列
        if (node.left != null) {
            postOrder(node.left, keys);
        }

        //递归遍历，把node节点的右子树的键放入队列
        if (node.right != null) {
            postOrder(node.right, keys);
        }

        //把node节点的key放到keys中
        keys.add(node.key);
    }

    /**
     * 层序遍历
     * 从上到下，自左向右获取树中所有的键
     * @Solution:
     * 1.创建队列，存储每一层的结点；
     * 2.循环从队列中弹出一个结点：
     *      2.1获取当前结点的key
     *      2.2如果当前结点的左子结点不为空，则把左子结点放入到队列nodes中
     *      2.3如果当前结点的右子结点不为空，则把右子结点放入到队列nodes中
     * @return
     */
    public Queue<Key> levelOrder() {
        // 定义两个队列，分别存储树中的键和树中的结点
        Queue<Key> keys = new LinkedList<>();  //存储节点的键
        Queue<Node> nodes = new LinkedList<>();  //存储节点

        //默认，往队列中放入根节点
        nodes.add(root);
        while (!nodes.isEmpty()) {
            // 从队列中弹出一个结点
            Node n = nodes.remove();
            //把key放入到keys中
            keys.add(n.key);
            // 判断当前结点还有没有左子结点，如果有，则放入到nodes中
            if (n.left != null) {
                nodes.add(n.left);
            }
            // 判断当前结点还有没有右子结点，如果有，则放入到nodes中
            if (n.right != null) {
                nodes.add(n.right);
            }
        }
        return keys;
    }
}
