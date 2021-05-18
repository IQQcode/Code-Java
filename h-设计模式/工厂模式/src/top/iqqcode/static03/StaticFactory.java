package top.iqqcode.static03;

import top.iqqcode.domain.AmericanCoffee;
import top.iqqcode.domain.Coffee;
import top.iqqcode.domain.LatteCoffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-23 16:05
 * @Description:静态工厂模式,用来生产咖啡
 */
public class StaticFactory {
    /**
     * 静态方法，通果类名直接调用工厂方法
     * @param type
     * @return
     */
    public static Coffee createCoffee(String type) {
        // 声明Coffee类型，根据不同类型创建不同Coffee对象
        Coffee coffee = null;
        if("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("没有所选开飞的类型！");
        }
        return coffee;
    }
}
