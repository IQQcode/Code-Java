/**
 * 对象数组产生随机数计算圆的面积
 *
 * e.g:声明并创建10个 Circle对象的数组
 *
 *      @Circle[] circleArray = new Circle[10];
 *
 *     for(int i =0 ; i < circleArray.length; i++) {
 *                circleArray[i] = new Circle;
 *         }
 *
 */


class CircleWithPrivateDataFields {
    private double radius = 1;
    private static int numberOfObjects = 0;

    public CircleWithPrivateDataFields() {
        numberOfObjects++;
    }
    public CircleWithPrivateDataFields(double radius) {
        this.radius = radius;
        numberOfObjects++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }
    public double getArea() {
        return radius * radius * Math.PI;
    }
}

public class TotalArea {
    public static void main(String[] args) {
        CircleWithPrivateDataFields[] circleArray;
        circleArray = creatCircleArray();
        printCircleArray(circleArray);
    }

    public static CircleWithPrivateDataFields[] creatCircleArray() {
        CircleWithPrivateDataFields[] circleArray =
                new CircleWithPrivateDataFields[5];
        for(int i = 0; i < circleArray.length; i++) {
            circleArray[i] = new CircleWithPrivateDataFields
                    (Math.random() * 100);
        }
        return circleArray;
    }

    public static void printCircleArray(
            CircleWithPrivateDataFields[] circleArray) {
        System.out.printf("%-30s%-15s\n","Radius","Area");
        for(int i = 0; i < circleArray.length; i++) {
            System.out.printf("%-30s%-15s\n",circleArray[i].getRadius(),
                    circleArray[i].getArea());
        }
        System.out.println("----------------------" +
                "--------------------------");
        System.out.printf("%-30s%-15f\n","The total area of circle is ",
                sum(circleArray));
    }

    public static double sum(CircleWithPrivateDataFields[] circleArray) {
        double sum = 0;
        for(int i = 0; i < circleArray.length; i++) {
            sum += circleArray[i].getArea();
        }
        return  sum;
    }
}
