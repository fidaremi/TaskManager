package mx.edu.j2se.studentLastName.evaluation;

public class Circle {
    private int radius;

    public Circle() {
        radius = 1;
    };

    public Circle(int radius) {
        if (radius < 0) {
            throw new IndexOutOfBoundsException("Radius should be a positive value");
        }
        setRadius(radius);
    }

    private void setRadius(int radius) {
        if (radius < 0) {
            throw new IndexOutOfBoundsException("Radius should be a positive value");
        }
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getArea() {
        double area = radius*radius*Math.PI;
        return area;
    }

}
