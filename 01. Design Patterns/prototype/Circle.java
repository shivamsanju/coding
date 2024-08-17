package prototype;

public class Circle implements Shape {
    public int radius;
    public String color;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public Shape clone() {
        Circle newCircle = new Circle(radius);
        newCircle.setColor(color);
        return newCircle;
    }

}
