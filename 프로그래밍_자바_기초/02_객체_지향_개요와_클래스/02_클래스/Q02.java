class Car {
    String color;
    int speed;
}

public class Q02 {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.color = "빨간색";
        c1.speed = 100;

        Car c2 = new Car();
        c2.color = "파란색";
        c2.speed = 150;

        System.out.println(c1.color + " 자동차, 속도: " + c1.speed);
        System.out.println(c2.color + " 자동차, 속도: " + c2.speed);
    }
}
