package mx.edu.j2se.studentLastName.evaluation;

public class Evaluation1 {
    public static void main(String[] args) {
        Circle Invalid = new Circle(-1);
        Circle Circle1 = new Circle(10.1);
        Circle Circle2 = new Circle(25.4);
        Circle Circle3 = new Circle(17);
        System.out.println(Circle1.getRadius());
        System.out.println(Circle2.getRadius());
        System.out.println(Circle3.getRadius());

        Circle[] arrayOfCircles = new Circle[3];
        arrayOfCircles[0] = Circle1;
        arrayOfCircles[1] = Circle2;
        arrayOfCircles[2] = Circle3;

        System.out.println(arrayOfCircles[biggestCircle(arrayOfCircles)].getRadius());

        for (int i = 0; i < arrayOfCircles.length; i++)
            System.out.println(arrayOfCircles[i].getArea());
    }

    public static int biggestCircle(Circle[] arrayOfCircles) {
        int max = 0;
        for (int i = 1; i < arrayOfCircles.length; i++) {
            if (arrayOfCircles[i].getRadius() > arrayOfCircles[max].getRadius())
                max = i;
        }
        return max;
        }
}