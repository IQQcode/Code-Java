package top.iqqcode.simple02;

import top.iqqcode.domain.Coffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-23 16:06
 * @Description:简单工厂模式的-咖啡店
 * 通果工厂来获取咖啡
 */
public class CoffeeHub {
    public Coffee orderCoffee(String type) {
        SimpleFactory simpleFactory = new SimpleFactory();

        /*工厂生产咖啡*/
        // 此处为解耦合，咖啡店和具体咖啡产品的依赖
        // Coffee coffee = hub.orderCoffee("latte");
        Coffee coffee = simpleFactory.createCoffee(type);

        // 咖啡店二次加工
        coffee.addMilk();
        coffee.addSugger();

        return coffee;
    }
}
