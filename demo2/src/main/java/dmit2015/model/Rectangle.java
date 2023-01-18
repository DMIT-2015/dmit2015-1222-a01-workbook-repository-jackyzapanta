package dmit2015.model;

public class Rectangle {
    private double thelength;
    private double width;

    public double getLength() {
        return thelength;
    }

    public void setLength(double length) {
        this.thelength = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Rectangle() {
    }

    public Rectangle(double thelength, double width) {
        this.thelength = thelength;
        this.width = width;
    }

    public  double area() {
        return width * thelength;
    }
}
