package iqqcode.algorithm.topic;

/**
 * @Author: Mr.Q
 * @Date: 2020-07-09 10:41
 * @Description:
 */
//内部节点类,直接存放数据
public class Node {
    int data;
    Node left;   //左孩子
    Node right;  //右孩子
    Node parent; //父节点

    //初始化节点类
    private Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    private Node(int data, Node parent) {
        this.data = data;
        this.parent = parent;
    }
}
