public class TotalArea {
    public static void main(String[] args) {
        CircleWithPrivateDataFields[] circleArray;
        circleArray = creatCircleArray();
        printCircleArray(circleArray);
    }

    public static CircleWithPrivateDataFields[] creatCircleArray() {
        CircleWithPrivateDataFields[] circle =
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
    }
}
