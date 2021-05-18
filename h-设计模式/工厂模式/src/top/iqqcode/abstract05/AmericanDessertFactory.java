package top.iqqcode.abstract05;

import top.iqqcode.domain.AmericanCoffee;
import top.iqqcode.domain.Coffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-24 09:48
 * @Description:美式风味工厂，生产美式咖啡和抹茶慕斯
 */
public class AmericanDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
