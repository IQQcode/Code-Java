package top.iqqcode.methods04;

import top.iqqcode.domain.Coffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-24 09:16
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        CoffeeHub coffeeHub = new CoffeeHub();
        CoffeeFactory factory = new AmericanCoffeeFactory();
        coffeeHub.setFactory(factory);
        // 点咖啡
        Coffee coffee = coffeeHub.orderCoffee();
        System.out.println(coffee.getName());
    }
}
