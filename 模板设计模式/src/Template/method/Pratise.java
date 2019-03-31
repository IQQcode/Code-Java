package Template.method;

import java.util.Scanner;


abstract class Drinking {

    public final void prepareRecipe() {
        boildwater();
        brew();
        pourInCup();
        if(customerwantstoaddCondiments()) {
            addCondiments();
        }
    }

    public abstract  void brew();

    public abstract  void addCondiments();

    public final  void boildwater() {
        System.out.println("把水烧开……");
    }

    public final void pourInCup() {
        System.out.println("把饮料倒入杯中……");
    }

    /**
     * 钩子方法
     * @return
     */
    public boolean customerwantstoaddCondiments() {
        return true;
    }
}


class Coffeedinnk extends  Drinking {
    @Override
    public void brew() {
        System.out.println("把咖啡倒入杯中……");
    }

    @Override
    public void addCondiments() {
        System.out.println("加糖，加牛奶！");
    }

    @Override
    public boolean customerwantstoaddCondiments() {
        System.out.println("请问您需要添加其他辅料吗？");
        System.out.println("点头Yes,摇头Now! 亲输入 Y / N");
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        if(answer.equals("Y")) {
            return true;
        }else {
            return false;
        }
    }
}


public class Pratise {
    public static void main(String[] args) {
        Drinking coffee = new Coffeedinnk();
        System.out.println("咖啡的制作流程");
        coffee.prepareRecipe();
    }
}
