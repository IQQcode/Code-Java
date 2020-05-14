package com.topic.joseph;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-06 21:10
 * @Description:循环链表
 * @Solution:
 * 1.构建含有41个结点的单向循环链表，分别存储1~41的值，分别代表这41个人；
 * 2.使用计数器count，记录当前报数的值；
 * 3.遍历链表，每循环一次，count++；
 * 4.判断count的值，如果是3，则从链表中删除这个结点并打印结点的值，把count重置为0
 */
public class CircularList {
    /**
     * 约瑟夫环
     * @param n 围成环人的编号(从1开始到n)
     * @param ans 数到ans的那个人出列
     * @return 幸存人的编号
     */
    public static int joseph(int n, int ans) {
        if ( ans < 2) {
            return n;
        }
        //创建循环链表
        Node first = buildCircularList(n);

        //count计数器，模拟报数
        int count = 0;

        //遍历删除节点，模拟自杀
        //记录每次遍历(报数)拿到的节点
        Node<Integer> temp = first;
        //记录当前节点的上一个节点befo，为的是在删除(自杀)时，befo直接指向自杀节点的下一个节点，完成当前节点的删除
        Node<Integer> befo = null; //默认的首节点无上一个节点

        //如果当前环只剩最后一个节点时，结束循环(防止自环)
        while (temp != temp.next) {
            //模拟报数
            count++;
            //判断当前报数是不是ans
            if (count == ans) {
                //如果是ans，则把当前结点删除调用，打印当前结点;
                //重置count=0，让当前结点temp后移
                befo.next = temp.next; //befo直接指向自杀节点的下一个节点，完成当前节点的删除
                System.out.print(temp.data + " ");
                count = 0;
                temp = temp.next;
            }else {
                //如果不是ans，让befo变为当前结点，让当前结点后移
                befo = temp;
                temp = temp.next;
            }
        }
        return temp.data;
    }

    //节点类
    private static class Node<T> {
        //存储数据
        T data;
        //指向下一个节点
        Node next;
        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 构建循环链表,分别存储1~n的编号
     * @param n n人编号
     * @return
     */
    private static Node buildCircularList(int n) {
        //首节点构建
        Node<Integer> first = null;
        //记录新创建的节点的前一个节点prev
        Node<Integer> prev = null;
        for (int i = 1; i <= n; i++) {
            //如果是第一个节点
            if (i == 1) {
                //首节点放入编号1，指向为空(因为此时后面还没有节点，链表只有一个节点)
                first = new Node<> (i, null);
                prev = first;
                continue; //本次循环执行结束
            }

            //如果不是第一个节点,将产生的新节点链在prev后
            Node<Integer> node = new Node<> (i, null);
            prev.next = node;
            //链接之后，让prev指向当前链表的最新节点，继续创建下一个新节点
            prev = node;

            //如果是最后一个节点，则需要指向first，形成循环链表
            if (i == n) {
                prev.next = first;
            }
        }
        return first;
    }
}
