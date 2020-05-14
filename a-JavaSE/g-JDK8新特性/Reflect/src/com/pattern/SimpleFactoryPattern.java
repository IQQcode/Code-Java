package com.pattern;

interface Phone {
    void use();
}

class Huawei implements Phone {
    @Override
    public void use() {
        System.out.println("Use Huawei Mate30");
    }
}

class Iphone implements Phone {
    @Override
    public void use() {
        System.out.println("Use Iphone XI");
    }
}

class Factory {
    public static Phone getInstance(String smartPhone) {
        if(smartPhone.equals("Huawei")) {
            return new Huawei();
        }else if(smartPhone.equals("Iphone")) {
            return new Iphone();
        }
        return null;
    }
}
public class SimpleFactoryPattern {
    public static void main(String[] args) {
        Phone phone = Factory.getInstance("Huawei");
        phone.use();
    }
}
