package com.linearlist.SequenceArray;


/**
 * @Author: Mr.Q
 * @Date: 2019-10-13 12:05
 * @Description:顺序表
 */
public interface ISequence {

    //在pos位置插入val
    boolean add(int pos ,Object data);

    //查找关键字key 找到返回key的下标，没有返回null
    int contains(Object data);

    //得到pos位置的值
    Object get(int index);

    //设置pos位置的值
    Object set(int index,Object newData);

    //删除第一次出现的关键字key
    Object remove(int index);

    //得到顺序表的长度
    int size();

    //数组扩容
    Object[] toArray();

    //清空顺序表,放置内存泄露
    void clear();
}
