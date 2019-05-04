package com.bittech.annotation;

/**
 * Author: secondriver
 * Created: 2019/3/31
 */
@FruitTarget
public class FruitFactory {
    
    public static Fruit getFruitObject() {
        //参数
        //1.通过if switch 参数判断
        //2 通过class
        //3.通过自定义注解的方法，将参数配置到注解中
        FruitTarget fruitTarget = FruitFactory.class.getAnnotation(FruitTarget.class);
        Class classz = null;
        try {
            classz = Class.forName(fruitTarget.name());
            return (Fruit) classz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        
        Fruit fruit = FruitFactory.getFruitObject();
        if(fruit!=null){
            fruit.eat();
        }
        
    }
}
