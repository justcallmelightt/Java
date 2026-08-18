/**
 * [프로그래밍 자바 실무] - 자기주도학습
 *
 * 주제: 추상 클래스를 활용한 도형 넓이 계산
 *
 * 학습 조건:
 * 1. Shape를 직접 객체로 만들 수 없는 추상 클래스로 선언한다.
 * 2. getArea()를 추상 메서드로 선언한다.
 * 3. Rectangle과 Circle이 각자의 넓이 공식을 구현한다.
 * 4. Shape 배열을 순회하며 도형 이름과 넓이를 출력한다.
 *
 * 학습 목표:
 * 1. 추상 클래스가 공통 규칙을 제공하는 방법을 이해한다.
 * 2. 자식 클래스가 추상 메서드를 반드시 구현해야 하는 이유를 확인한다.
 * 3. 부모 타입 배열을 이용한 다형적 호출을 연습한다.
 */
abstract class Shape {
    private final String name;

    Shape(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    // 도형마다 계산식이 다르므로 구체적인 구현은 자식 클래스에 맡긴다.
    abstract double getArea();
}

class Rectangle extends Shape {
    private final double width;
    private final double height;

    Rectangle(double width, double height) {
        super("직사각형");
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return width * height;
    }
}

class Circle extends Shape {
    private final double radius;

    Circle(double radius) {
        super("원");
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}

public class ShapePolymorphismPractice {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Rectangle(4, 6),
            new Circle(3)
        };

        for (Shape shape : shapes) {
            System.out.printf("%s 넓이: %.2f%n", shape.getName(), shape.getArea());
        }
    }
}
