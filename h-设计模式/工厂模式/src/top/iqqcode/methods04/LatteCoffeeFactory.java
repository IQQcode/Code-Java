package top.iqqcode.methods04;

import top.iqqcode.domain.Coffee;
import top.iqqcode.domain.LatteCoffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-24 09:12
 * @Description:拿铁咖啡工厂对象(生产拿铁咖啡)
 */
public class LatteCoffeeFactory implements CoffeeFactory{
    @Override
    public Coffee creatCoffee() {
        return new LatteCoffee();
    }
}
