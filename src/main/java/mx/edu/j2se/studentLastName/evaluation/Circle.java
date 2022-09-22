package mx.edu.j2se.studentLastName.evaluation;

/**
 * Classname: Circle
 * This class implements circles creation and calculates their area
 *
 * @version info: 0.3 21 September 2022
 * @author Mariia Kuntsevych
 * Copyright notice: freeware
 */
public class Circle {
    private int radius;

    /**
     * This empty constructor constructs a circle and sets the radius to 1
     */
    public Circle() {
        radius = 1;
    };

    /**
     * This constructor take a value of a radius and constructs a circle.
     * It throws an IllegalArgumentException exception if
     * the radius is invalid.
     * @param radius is the argument which sets a circle's radius
     */
    public Circle(int radius) {
        setRadius(radius);
    }

    /**
     * This method implements setting of the circle's radius
     * @param radius is the argument which sets a circle's radius
     */
    private void setRadius(int radius) {
        if (radius < 0) {
            throw new IndexOutOfBoundsException("Radius should be a positive value");
        }
        this.radius = radius;
    }

    /**
     * This method implements reading of a circle's radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * This method is calculating a circle's area on the base of radius variable and math value of π
     */
    public double getArea() {
        double area = radius*radius*Math.PI;
        return area;
    }

}
