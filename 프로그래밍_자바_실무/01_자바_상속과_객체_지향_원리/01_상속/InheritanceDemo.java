class Animal {
    void move() {
        System.out.println("동물이 움직입니다.");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("멍멍");
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.move();
        dog.bark();
    }
}
