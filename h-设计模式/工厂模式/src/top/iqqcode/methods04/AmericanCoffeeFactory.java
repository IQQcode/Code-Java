package top.iqqcode.methods04;

import top.iqqcode.domain.AmericanCoffee;
import top.iqqcode.domain.Coffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-24 09:11
 * @Description:美式咖啡工厂对象(生产美式咖啡)
 */
public class AmericanCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee creatCoffee() {
        return new AmericanCoffee();
    }
}
