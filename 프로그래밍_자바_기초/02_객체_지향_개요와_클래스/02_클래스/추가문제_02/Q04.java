class Circle {
    private final double PI = 3.14159;
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return PI * radius * radius;
    }

    double getCircumference() {
        return 2 * PI * radius;
    }
}

public class Q04 {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        System.out.println("넓이: " + c.getArea());
        System.out.println("둘레: " + c.getCircumference());
    }
}
