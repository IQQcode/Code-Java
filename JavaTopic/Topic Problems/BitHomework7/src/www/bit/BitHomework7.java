package www.bit;

import java.lang.reflect.Constructor;/*
interface  Phone {
    void creatPhone();
}

class Mate_X implements Phone {
    @Override
    public void creatPhone() {
        System.out.println("Buy a Huawei Mate_X");
    }
}

class Mi9 implements  Phone {
    @Override
    public void creatPhone() {
        System.out.println("Rush to purchase a Mi9");
    }
}

class iPhone implements Phone {
    @Override
    public void creatPhone() {
        System.out.println("Spand a lot momey to buy a iPhone");
    }
}

class PhoneFactory {
    public static Phone getInstance(String phoneName) {
        Phone phone = null;
        try {
            phone = (Phone) Phone.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public  class BitHomework7 {
    public static void main(String[] args) {
        Phone phone = PhoneFactory.getInstance(" Mate_X");
        phone.creatPhone();
    }
}
*/

class Person {
    private String name;
    private Integer age;

    public Person() { }   //无参构造

    Person(Integer age) {
        this.age = age;
    }

    private Person(String name,Integer agr) {
        this.name = name;
        this.age = age;
    }
}

public class BitHomework7 {
    public static void main(String[] args) {
        Class<Person> per = Person.class;


        //Constructor<?>[] constructors = per.getDeclaredConstructors();
        Constructor<?>[] constructors = per.getConstructors();
        for(java.lang.reflect.Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

    }
}
