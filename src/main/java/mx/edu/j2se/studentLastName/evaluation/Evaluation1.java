package mx.edu.j2se.studentLastName.evaluation;

/**
 * Classname: Evaluation1
 * This class implements circles creation from the constructor class Circle
 * and identifies the biggest circle throw biggestCircle() method
 *
 * @version info: 0.3 21 September 2022
 * @author Mariia Kuntsevych
 * Copyright notice: freeware
 */
public class Evaluation1 {

    /**
     * This method implements creating of an invalid circle and
     * catch the exception thrown to print a user-friendly message.
     * It creates an array of three valid circles and send it to the biggestCircle() method.
     * This method prints the radius of the largest circle.
     * This method checks all circles in the array and prints their areas as the output
     * @param args
     */
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

    /**
     * This method takes an array of circles and returns the index in the array where
     * the largest circle is stored
     * @param arrayOfCircles is an argument which takes a value of an array of three valid circles
     * created in public static void main(String[] args) method
     */
    public static int biggestCircle(Circle[] arrayOfCircles) {
        int max = 0;
        for (int i = 1; i < arrayOfCircles.length; i++) {
            if (arrayOfCircles[i].getRadius() > arrayOfCircles[max].getRadius())
                max = i;
        }
        return max;
        }
}