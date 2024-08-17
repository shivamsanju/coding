package prototype;

public class Client {
    private static String assignRandomColor() {
        String[] colors = { "red", "green", "blue", "yellow", "orange", "purple", "cyan", "magenta" };
        int randomIndex = (int) (Math.random() * colors.length);
        return colors[randomIndex];
    }

    public static void main(String[] args) {
        Shape rectange = new Rectange(20, 25);
        Shape circle = new Circle(30);

        rectange.setColor(assignRandomColor());
        circle.setColor(assignRandomColor());

        System.out.println(rectange.getColor());
        System.out.println(circle.getColor());

        // Create clones
        Shape circleClone = circle.clone();
        Shape rectangeClone = rectange.clone();

        System.out.println(rectangeClone.getColor());
        System.out.println(circleClone.getColor());

    }
}
