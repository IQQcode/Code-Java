package www.javaSE;

class Data { }

public class Reflect {
    public static void main(String[] args) {
        Data data = new Data();
        System.out.println(data.getClass().getName());
    }
}
