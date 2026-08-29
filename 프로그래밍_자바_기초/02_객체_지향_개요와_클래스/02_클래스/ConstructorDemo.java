// ConstructorDemo.java
class Person {
    String name;
    int age;
    String email;

    // ================================================================
    // 1. 기본 생성자 — 명시적으로 작성
    // ================================================================
    // 생성자를 하나도 안 쓰면 컴파일러가 자동으로 기본 생성자를 만들어준다
    // 단, 매개변수 있는 생성자를 하나라도 쓰면 기본 생성자는 자동 생성되지 않는다
    Person() {
        name = "이름 없음";
        age = 0;
        email = "없음";
    }

    // ================================================================
    // 2. 매개변수 있는 생성자
    // ================================================================
    Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.email = "없음";  // 기본값
    }

    Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // ================================================================
    // 3. this() — 다른 생성자 호출로 코드 중복 제거
    // ================================================================
    // 위의 2번 생성자를 this()로 리팩토링하면:
    // Person(String name, int age) {
    //     this(name, age, "없음"); // 3번 생성자 호출, 반드시 첫 줄에 써야 한다
    // }

    String getInfo() {
        return name + " / " + age + "세 / " + email;
    }
}

public class ConstructorDemo {
    public static void main(String[] args) {
        // 기본 생성자
        Person p1 = new Person();
        System.out.println(p1.getInfo());

        // 매개변수 2개 생성자
        Person p2 = new Person("홍길동", 30);
        System.out.println(p2.getInfo());

        // 매개변수 3개 생성자
        Person p3 = new Person("김영희", 25, "kim@test.com");
        System.out.println(p3.getInfo());

        System.out.println();

        // ================================================================
        // 4. 기본 생성자가 사라지는 함정
        // ================================================================
        // Person에 매개변수 생성자가 있으면 기본 생성자는 자동 생성되지 않는다
        // 아래 클래스처럼 매개변수 생성자만 정의하면 new Box()는 컴파일 에러
        // Box b = new Box(); // 컴파일 에러!

        Box b1 = new Box(10, 20, 30);
        System.out.println("부피: " + b1.getVolume());
    }
}

class Box {
    int width, height, depth;

    // 매개변수 생성자만 정의 → 기본 생성자 자동 생성 안 됨
    Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    int getVolume() {
        return width * height * depth;
    }
}
