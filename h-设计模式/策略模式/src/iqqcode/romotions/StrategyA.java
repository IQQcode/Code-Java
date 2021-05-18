package iqqcode.romotions;

/**
 * @Author: iqqcode
 * @Date: 2020-12-22 10:57
 * @Description:具体策略类，封装算法
 * @function:实现促销接口，负责展示该促销活动的内容
 */
public class StrategyA implements Strategy {
    @Override
    public void show() {
        System.out.println("买一送一");
    }
}
