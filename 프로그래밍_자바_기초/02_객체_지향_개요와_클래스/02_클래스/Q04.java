class Circle {
    double radius;

    double getArea() {
        return 3.14 * radius * radius;
    }
}

public class Q04 {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.radius = 5;
        System.out.println("원의 넓이: " + c.getArea());
    }
}
