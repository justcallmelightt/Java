class Rectangle {
    int width;
    int height;
    String color;

    Rectangle(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    Rectangle(int width, int height) {
        this(width, height, "흰색");
    }

    Rectangle() {
        this(1, 1);
    }

    String getInfo() {
        return "가로:" + width + " 세로:" + height + " 색상:" + color;
    }
}

public class Q22 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(5, 3);
        Rectangle r3 = new Rectangle(4, 6, "파란색");
        System.out.println(r1.getInfo());
        System.out.println(r2.getInfo());
        System.out.println(r3.getInfo());
    }
}
