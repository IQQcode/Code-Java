package top.iqqcode.static03;

import top.iqqcode.domain.Coffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-23 16:06
 * @Description:静态工厂模式的-咖啡店
 * 通过工厂来获取咖啡
 */
public class CoffeeHub {
    public Coffee orderCoffee(String type) {
        Coffee coffee = StaticFactory.createCoffee(type);
        // 咖啡店二次加工
        coffee.addMilk();
        coffee.addSugger();

        return coffee;
    }
}
