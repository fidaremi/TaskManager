package mx.edu.j2se.studentLastName.evaluation;

public class Evaluation1 {
    public static void main(String[] args) {
        try {
           Circle invalid = new Circle(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException => " + e.getMessage());
        }

        Circle circle1 = new Circle(10);
        Circle circle2 = new Circle(25);
        Circle circle3 = new Circle(17);
        System.out.println(circle1.getRadius());
        System.out.println(circle2.getRadius());
        System.out.println(circle3.getRadius());

        Circle[] arrayOfCircles = new Circle[3];
        arrayOfCircles[0] = circle1;
        arrayOfCircles[1] = circle2;
        arrayOfCircles[2] = circle3;

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