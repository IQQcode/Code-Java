package bitlearn.ds;

/**
 * 线性表规范
 *
 * 上⾯面程序采⽤用数组⽅方式实现了了⼀一个顺序线性表，
 * 可以向线性表中添加，删除，查找元素等操作

 */
public interface Sequence {
    /**
     * 向线性表中添加元素
     * @param data 要存储的元素
     */
    void  add(Object data);


    /**
     * 线性表中要删除的元素
     * @param index 要删除的下标元素
     * @return 是否删除成功
     */
    boolean remove(int index);


    /**
     * 在线性表中查找指定索引的元素
     * @param index 要查找的索引
     * @return
     */
    Object get(int index);


    /**
     * 判断线性表中是否有指定元素
     * @param data 要查找的元素内容
     * @return
     */
    boolean contains(Object data);


    /**
     * 修改线性表中指定索引的内容
     * @param index 要修改元素的下标
     * @param newData 修改后的内容
     * @return
     */
    Object set(int index,Object newData);


    /**
     * 返回当前线性表元素个数
     * @return
     */
    int size();


    /**
     * 直接清空线性表内容
     */
    void clear();
}



