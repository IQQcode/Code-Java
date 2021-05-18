package top.iqqcode.basic01;

import top.iqqcode.domain.AmericanCoffee;
import top.iqqcode.domain.Coffee;
import top.iqqcode.domain.LatteCoffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-23 15:44
 * @Description:咖啡店
 */
public class CoffeeHub {
    public Coffee orderCoffee(String type) {
        // 声明Coffee类型，根据不同类型创建不同Coffee对象
        Coffee coffee = null;
        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("没有所选开飞的类型！");
        }
        // 加配料
        coffee.addSugger();
        coffee.addMilk();
        return coffee;
    }
}
