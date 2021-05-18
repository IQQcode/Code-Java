package top.iqqcode.abstract05;

import top.iqqcode.domain.Coffee;
import top.iqqcode.domain.LatteCoffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-24 09:49
 * @Description:意式风味工厂，生产拿铁咖啡和提拉米苏
 */
public class ItalyDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Tiramisu();
    }
}
