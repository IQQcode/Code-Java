package com.pattern;

/**
 * 如果要添加其他类，只需要修改客户端即可
 */

interface Fruit {
    void eat();
}

class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat an apple");
    }
}

class Peach implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat many peaches");
    }
}

//反射改造工厂模式
class FruitFactory {
    public static Fruit getInstance(String fruitName) {
        Fruit newFruit = null;
        try {
            Class<?> cls = Class.forName(fruitName);
            newFruit = (Fruit)cls.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return newFruit;
    }
}

public class ReflectFactoryPattern {
    public static void main(String[] args) {
        Fruit fruit = FruitFactory.getInstance("com.pattern.Peach");
        fruit.eat();
    }
}
