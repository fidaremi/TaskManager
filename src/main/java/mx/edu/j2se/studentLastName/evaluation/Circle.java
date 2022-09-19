package mx.edu.j2se.studentLastName.evaluation;

public class Circle {
    private double radius;
    private double area;

    public Circle() {
        radius = 1;
    };

    public Circle(double radius) {
        try {
            if (radius < 0) {
                throw new IndexOutOfBoundsException("Radius should be a positive value");
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException => " + e.getMessage());
        }
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius (double radius) {
        try {
            if (radius < 0) {
                throw new IndexOutOfBoundsException("Radius should be a positive value");
            }
        }
        catch (IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException => " + e.getMessage());
            }
        this.radius = radius;
    }

    public double getArea() {
        area = radius*radius*Math.PI;
        return area;
    }

}
