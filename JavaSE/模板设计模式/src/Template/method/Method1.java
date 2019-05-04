package Template.method;

import java.util.Scanner;

/**
 * 饮料是一个抽象类
 */
/*
abstract class Coffeedrink {
    */
/**
     * 用一个prepareRecipe方法来处理茶和咖啡
     * final修饰不希望子类覆写覆盖这个方法
     *//*

    final void prepareRecipe() {
        boilerwater();
        brew();
        pourInCup();
        addCondiments();
    }


    // 咖啡和茶的处理方法不同，所以用abstract声明，具体到子类在实现

    abstract void brew();
    abstract void addCondiments();

    public void boilerwater() {
        System.out.println("Boiling water");
    }

    public void pourInCup() {
        System.out.println("Pouer drinking into cups");
    }
}

class Coffee extends Coffeedrink {
    void brew() {
        System.out.println("Dripping Coffee through filteer");
    }

    void addCondiments() {
        System.out.println("Adding sugger ang milk!");
    }
}
class Tea extends Coffeedrink {
    void brew() {
        System.out.println("Making tea");
    }

    public void addCondiments() {
        System.out.println("Adding lemon");
    }
}


public class Method1 {
    public static void main(String[] args) {
        Coffeedrink coffee = new Coffee();
        coffee.prepareRecipe();
        Tea tea = new Tea();
        System.out.println("*******************");
        tea.prepareRecipe();
    }
}
*/









/**
 * Mathod1 changed
 */


abstract class Coffeeproduce {

    public final void prepareRecipe() {
        boilerwater();
        brew();
        pourInCup();
        if (customerswantCondiments()) {
            addCondiments();
        }
    }


    public abstract void brew();
    public abstract void addCondiments();


    public final void boilerwater() {
        System.out.println("Boiling water");
    }

    public final void pourInCup() {
        System.out.println("Pouer drinking into cups");
    }

/**
     * 钩子方法，子类可以选择性的覆写此方法
     * @return true
     */

    public boolean customerswantCondiments() {
        return true;
    }
}


class Coffee extends Coffeeproduce {
    public void brew() {
        System.out.println("Dripping Coffee through filteer");
    }

    public void addCondiments() {
        System.out.println("Adding suger and milk!");
    }

    public boolean customerswantCondiments() {
        System.out.println("Do you want to add Suger or milk in your coffee?");
        System.out.println("Y / N");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if(answer.equals("Y")) {
            return true;
        }else {
           return false;
        }
    }
}


class Tea extends Coffeeproduce {
    public void brew() {
        System.out.println("Making tea");
    }

    public void addCondiments() {
        System.out.println("Adding lemon");
    }
}


public class Method1 {
    public static void main(String[] args) {
        Coffeeproduce coffee = new Coffee();
        Coffeeproduce tea = new Tea();

        System.out.println("Making coffee...");
        coffee.prepareRecipe();

        System.out.println("\nMaking tea...");
        tea.prepareRecipe();
    }
}




