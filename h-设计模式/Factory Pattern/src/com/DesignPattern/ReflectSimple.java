package com.DesignPattern;


class Mi implements Phone {
    @Override
    public void buyPhone() {
        System.out.println("买一台Mi 9");
    }
}

//反射改造工厂模式
class SmartPhoneReflect {
    public static Phone getInstance(String smartPhone) {
        Phone phone = null;
        try {
            Class<?> cls = Class.forName(smartPhone);
            phone = (Phone) cls.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return phone;
    }
}

//客户端 Client
public class ReflectSimple {
    public static void main(String[] args) {
        Phone phone = SmartPhoneReflect.getInstance("com.DesignPattern.Mi");
        phone.buyPhone();
    }
}
