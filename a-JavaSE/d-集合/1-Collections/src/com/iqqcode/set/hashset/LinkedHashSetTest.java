package com.iqqcode.set.hashset;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-24 23:56
 * @Description:
 * java.util.LinkedHashSet集合extends Hashset集合
 * LinkedHashset集合特点：
 * 底层是一个哈希表（数组+链表/红黑树）+链表：多一条链表（记录元素的存储顺序）保证元素有序
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        Set<Integer> set  = new HashSet<>();
        set.add(4);
        set.add(3);
        set.add(2);
        set.add(1);
        System.out.println(set);

        LinkedHashSet<Integer> linkSet = new LinkedHashSet<> ();
        linkSet.add(4);
        linkSet.add(3);
        linkSet.add(2);
        linkSet.add(1);
        System.out.println(linkSet);
    }
}
