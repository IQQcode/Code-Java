package thread10;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-28 12:53
 * @Description:死锁
 */
class Ship { }

class Money { }

class Shopping extends Thread {
    //发生死锁的双发各持有一份资源，static保证只有一份资源
    static Ship phone = new Ship();
    static Money money = new Money();

    private String person;
    private boolean choice;

    public Shopping(String person, boolean choice) {
        this.person = person;
        this.choice = choice;
    }

    @Override
    public void run() {
        try {
            pay();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //互相持有对方的锁，想要获取对方的资源
    private void pay() throws InterruptedException {
        if (choice) {
            //获得商品的锁
            synchronized (phone) {
                System.out.println(this.person + "->获得商品的锁");
                Thread.sleep(2000);

                //2s后想获得金钱的锁
                synchronized (money) {
                    System.out.println(this.person + "-->>获得金钱的锁");
                }
            }
        }else {
            //获得金钱的锁
            synchronized (money) {
                System.out.println(this.person + "<<--获得金钱的锁");
                Thread.sleep(2000);

                //2s后想获得商品的锁
                synchronized (phone) {
                    System.out.println(this.person + "<-获得商品的锁");
                }
            }
        }
    }
}

public class DeadLock {
    public static void main(String[] args) {
        new Shopping("顾客",true).start();
        new Shopping("商家",false).start();
    }
}























