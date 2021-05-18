package top.iqqcode.domain;

/**
 * @Author: iqqcode
 * @Date: 2020-12-23 15:39
 * @Description:
 */
public abstract class Coffee {
    public abstract String getName();

    public void addSugger() {
        System.out.println("加糖");
    }

    public void addMilk() {
        System.out.println("加奶");
    }

}
