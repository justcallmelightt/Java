class Rectangle {
    int width;
    int height;

    void printArea() {
        System.out.println("넓이: " + (width * height));
    }
}

public class Q03 {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.width = 5;
        r.height = 10;
        r.printArea();
    }
}
