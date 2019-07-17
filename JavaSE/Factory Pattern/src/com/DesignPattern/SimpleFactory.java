package com.DesignPattern;

//抽象行为买手机buyPhone()
interface Phone {
    void buyPhone();
}
//具体的产品 HUAWEI
class HUAWEI implements Phone {
    @Override
    public void buyPhone() {
        System.out.println("买一台HUAWEI P30");
    }
}
//具体的产品 SAMSUNG
class SAMSUNG implements Phone {
    @Override
    public void buyPhone() {
        System.out.println("买一台SAMSUNG Galaxy S10+");
    }
}
//具体的产品 Apple
class Apple implements Phone {
    @Override
    public void buyPhone() {
        System.out.println("买一台iPhone X");
    }
}

//工厂类
class SmartPhoneFactory {
    public static Phone getInstance(String smartPhone) {
        if(smartPhone.equals("HUAWEI")) {
            return new HUAWEI();
        }else if(smartPhone.equals("Apple")) {
            return new Apple();
        }else if(smartPhone.equals("SAMSUNG")) {
            return new SAMSUNG();
        }
        return null;
    }
}
//客户端 Client
public class SimpleFactory {
    public static void main(String[] args) {
        Phone phone = SmartPhoneFactory.getInstance("HUAWEI");
        phone.buyPhone();
    }
}
