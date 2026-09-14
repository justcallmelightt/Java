// OOP(객체 지향 프로그래밍) 4대 원칙 - 다형성 (Polymorphism)

class Person {
    protected int age;
    public void go() { // 메서드 
        System.out.println("사람이 갑니다.");
    }
}

class Student extends Person {
    public String grade;
    public void study() {
        System.out.println("학생이 공부합니다.");
    }

    @Override 
    public void go() {
        System.out.println("학생이 갑니다.");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println(s1.age); // 0
        s1.go(); // 학생이 갑니다. // 자식 go가 아닌 부모 go, 오버라이드 된것을 호출
        System.out.println(s1.grade); // null
        s1.study(); // 학생이 공부합니다.

        // 다형성 (Polymorphism) - 부모 클래스로 받아오기

        // 오류 예제
        Person p = new Student(); // 업캐스팅 (Upcasting) 부모 타입으로 자식 객체를 참조, 이미 상속을 받았기 떄문에 Student에 Person이 포함됨
        System.out.println(p.grade); // Person 타입으로 받음 -> 접근을 못하게 함 (원랜 접근을 쉽게 할려고 public을 사용함)
        p.study(); // Person 타입 -> study() 접근 불가


        // 다형성 Demo 예제
        System.out.println(p.age); // 
        p.go(); // 오버라이드 한 객체로 호출됨, 중요
        // "다형성 (Polymorphism) - 부모 클래스로 받아오기" 끝.


        // 다형성 -> 자식 타입 객체를 부모 타입 값으로 받는 것.
        // 1) 부모 타입에 정의된 것에만 접근할수 있음
        // 2) 오버라이드 된 메서드가 있으면 부모 타입으로 받았어도 "오버라이드 된 메서드"가 호출됨 (*)

        // 다른 관점으로 보기

        // 부모 타입으로 자식 타입 값을 대입했을때 (즉, 다형성 적용) 장점?
        // 1) 부모 타입에만 접근 할 수 있다. -> 접근 범위가 줄어든게 장점인지? -> X
        // 2) 오버라이드 된 메서드가 호출 되니까 종다 -> 원래 자식 타입으로 했으면 원래 그런것, 장점이라고 보기에는 애매함.

        // 보기엔 아무 장점이 없어보임. -> 다형성의 장점은 "코드의 재사용성"에 있음. (중요)
        // 프로젝트나 즉 경험을 해봐야 장점을 알 수 있음. 

        /* Student ss = new Person(); 더 낮은 타입을 더 높은 타입으로 받는건 안됨. 부모 -> 자식 (다운캐스팅) -> 다운캐스팅은 명시적으로 해야함. (강제 형변환)
        p.go();
        Student ss = (Student) p; 강제 형변환 Person을 더 작은 Student 타입으로 변환. Student 였다가 Person이였다가 Student로 원상복구 */

        /* Person p = new Person(); 
        Student s = (Student) p; 강제로 바꾸는 과정에서, 바꿀수가 없음 (Study랑 Grade가 없음), 자식 타입일땐 p가 Student 타입이였지만, Person 타입으로 바뀌면서 Study랑 Grade가 없어짐. 그래서 ClassCastException 발생.

        ClassCastException 발생, 형변환이 영어로 Casting */

        // StringBuilder sb = new (StringBuilder) p; ClassCastException 발생, StringBuilder는 Person과 아무런 상속관계가 없음. 그래서 형변환이 안됨.
        Object o = p; // 이게 안되는 경우는 없음
    }
}
