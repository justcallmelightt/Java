class Bicycle {
    String color;
    int speed;

    void accelerate(int amount) {
        speed += amount;
    }
}

public class ObjectModelDemo {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        bicycle.color = "blue";
        bicycle.accelerate(15);

        System.out.println("color = " + bicycle.color);
        System.out.println("speed = " + bicycle.speed);
    }
}
