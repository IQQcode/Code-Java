package top.iqqcode.methods04;

import top.iqqcode.domain.Coffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-24 09:09
 * @Description:
 */
public class CoffeeHub {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        Coffee coffee = factory.creatCoffee();
        coffee.addSugger();
        coffee.addMilk();
        return coffee;
    }
}
