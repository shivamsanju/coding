package prototype;

public class Rectange implements Shape {
    public int length;
    public int breadth;
    public String color;

    public Rectange(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public Shape clone() {
        Rectange cloneRectange = new Rectange(length, breadth);
        cloneRectange.setColor(color);
        return cloneRectange;
    }
}
