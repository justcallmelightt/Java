# 접근 제어자 — public, private, protected, default

- 원문: http://yubs.online/java/(1%ED%95%99%EA%B8%B0)_%EA%B8%B0%EC%B4%88/02_%EA%B0%9D%EC%B2%B4-%EC%A7%80%ED%96%A5-%EA%B0%9C%EC%9A%94%EC%99%80-%ED%81%B4%EB%9E%98%EC%8A%A4/02_%ED%81%B4%EB%9E%98%EC%8A%A4-02)-%ED%81%B4%EB%9E%98%EC%8A%A4-%ED%99%9C%EC%9A%A9-%EC%A4%91%EA%B8%89.html
- 용도: yubs.online 수업 페이지의 코드 블록을 원문 순서대로 보존한 학습 자료입니다.
- 실행 가능한 예제는 같은 단원의 Java 파일을 우선 참고하세요.

## 코드 블록 1

```text
// AccessModifierDemo.java
// 주제: 접근 제어자 - public, private, default, protected

class Employee {
    public String department = "미배정";
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            System.out.println("에러: 급여는 0 이상이어야 합니다. 변경 거부.");
            return;
        }
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private String formatSalary() {
        return String.format("%,d원", salary);
    }

    public void printSummary() {
        System.out.println("[직원 요약] " + name + " / " + department + " / " + formatSalary());
    }
}

class ProtectedParent {
    protected String name;
    private int age;

    public ProtectedParent(String name) {
        this.name = name;
        this.age = 0;
    }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public void introduce() {
        System.out.println("저는 " + name + "입니다.");
    }
}

class ProtectedChild extends ProtectedParent {
    private int childAge;

    public ProtectedChild(String name, int age) {
        super(name);
        this.childAge = age;
    }

    public void showInfo() {
        System.out.println("이름: " + name);
        System.out.println("나이: " + getAge());
        System.out.println("자식 나이: " + childAge);
    }
}

public class AccessModifierDemo {

    public static void main(String[] args) {
        // ================================================================
        // 1. public vs private - 기본 비교
        // ================================================================
        Employee emp = new Employee("홍길동", 3000000);

        System.out.println(emp.department);
        // System.out.println(emp.salary);       // 컴파일 에러: private 필드

        System.out.println(emp.getSalary());
        emp.setSalary(3500000);
        System.out.println(emp.getSalary());

        System.out.println();

        // ================================================================
        // 2. private 필드에 유효성 검사가 있을 때의 이점
        // ================================================================
        // emp.salary = -9999999;  // public이었다면 막을 수 없음

        emp.setSalary(-1000);    // 유효성 검사 → 거부
        System.out.println("급여: " + emp.getSalary()); // 이전 값 유지

        System.out.println();

        // ================================================================
        // 3. private 메서드 - 클래스 내부 전용 헬퍼
        // ================================================================
        // emp.formatSalary();  // 컴파일 에러: private 메서드

        emp.printSummary();  // 내부에서 private 메서드를 호출하는 public 메서드

        System.out.println();

        // ================================================================
        // 4. 자주 하는 실수: setter에서 this 빠뜨리기
        // ================================================================
        Employee emp2 = new Employee("김철수", 2000000);
        emp2.setDepartment("개발팀");
        System.out.println(emp2.department);

        System.out.println();

        // ================================================================
        // 5. protected - 상속 관계에서만 접근 가능
        // ================================================================
        ProtectedParent parent = new ProtectedParent("이영희");
        parent.introduce();

        ProtectedChild child = new ProtectedChild("박지수", 25);
        child.introduce();
        child.showInfo();
        // child.age;   // age는 private → 자식도 직접 접근 불가
    }
}
```

## 코드 블록 2

```text
// StaticFieldAndMethodDemo.java
// 주제: static 필드, static 메서드, 인스턴스 메서드 비교

class Counter {
    // static 필드: 모든 인스턴스가 공유, 클래스 로딩 시 한 번만 초기화
    public static int totalCount = 0;

    // 인스턴스 필드: 객체마다 독립적으로 존재
    private String label;
    private int localCount = 0;

    public Counter(String label) {
        this.label = label;
        totalCount++;   // 객체 생성될 때마다 공유 카운터 증가
        localCount++;
    }

    // ================================================================
    // static 메서드: 클래스 이름으로 호출, 인스턴스 필드 접근 불가
    // ================================================================
    public static int getTotalCount() {
        // System.out.println(label);  // 컴파일 에러: 인스턴스 필드 접근 불가
        // System.out.println(localCount);  // 컴파일 에러: 인스턴스 필드 접근 불가
        return totalCount;
    }

    // static 메서드에서 static 필드는 접근 가능
    public static void resetTotal() {
        totalCount = 0;
    }

    // ================================================================
    // 인스턴스 메서드: 인스턴스 필드 + static 필드 모두 접근 가능
    // ================================================================
    public String getStatus() {
        return "[" + label + "] localCount=" + localCount + ", totalCount=" + totalCount;
    }
}

public class StaticFieldAndMethodDemo {
    public static void main(String[] args) {

        // ================================================================
        // 1. 객체 생성 전에도 static 필드/메서드 접근 가능
        // ================================================================
        System.out.println("생성 전 totalCount = " + Counter.totalCount);    // 0
        System.out.println("생성 전 getTotalCount() = " + Counter.getTotalCount()); // 0

        System.out.println();

        // ================================================================
        // 2. 객체 생성 후 - 모든 인스턴스가 같은 static 필드를 공유
        // ================================================================
        Counter c1 = new Counter("A");
        Counter c2 = new Counter("B");
        Counter c3 = new Counter("C");

        // 클래스 이름으로 접근 (권장)
        System.out.println("클래스로 접근: " + Counter.totalCount);  // 3

        // 인스턴스로도 접근은 되지만 경고 발생 → 비권장
        System.out.println("인스턴스로 접근: " + c1.totalCount);     // 3 (같은 값)

        System.out.println();

        // ================================================================
        // 3. 한 인스턴스가 바꾸면 모두에게 반영된다 (함정)
        // ================================================================
        System.out.println(c1.getStatus()); // totalCount=3
        System.out.println(c2.getStatus()); // totalCount=3

        Counter.totalCount = 999;  // static 필드 직접 수정
        System.out.println("수정 후 c1: " + c1.getStatus()); // totalCount=999
        System.out.println("수정 후 c2: " + c2.getStatus()); // totalCount=999

        System.out.println();

        // ================================================================
        // 4. static 메서드 vs 인스턴스 메서드 호출 방식
        // ================================================================
        Counter.resetTotal();                       // static 메서드: 클래스로 호출
        System.out.println(Counter.getTotalCount()); // 0

        Counter c4 = new Counter("D");
        System.out.println(c4.getStatus());         // 인스턴스 메서드: 객체로 호출

        System.out.println();

        // ================================================================
        // 5. 자주 쓰는 클래스 메서드 예시 (Math, Integer, String)
        // ================================================================
        System.out.println(Math.abs(-10));           // 10
        System.out.println(Math.max(7, 13));         // 13
        System.out.println(Integer.parseInt("123")); // 123
        System.out.println(String.valueOf(456));     // "456"

        // Math.random() — 0.0 이상 1.0 미만의 랜덤 double
        double rand = Math.random();
        System.out.println("random = " + rand);

        // 정수 범위 랜덤 (0~9)
        int randInt = (int)(Math.random() * 10);
        System.out.println("0~9 랜덤 = " + randInt);
    }
}
```

## 코드 블록 3

```text
// FinalAndInitBlockDemo.java
// 주제: final 필드, 인스턴스 초기화 블록, static 초기화 블록

class Circle {
    // final 필드: 한 번 초기화 후 변경 불가
    private final double PI = 3.14159;  // 선언 시 초기화
    private final double radius;        // 생성자에서 초기화 (선언 시 값 없음)

    public Circle(double radius) {
        this.radius = radius;
        // this.radius = 999;  // 컴파일 에러: final 필드는 재대입 불가
        // PI = 3.0;           // 컴파일 에러: 이미 선언 시 초기화됨
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }
}

class InitBlockDemo {
    private int value;
    private int anotherValue;
    private String tag;

    // ================================================================
    // 인스턴스 초기화 블록: 모든 생성자 호출 전에 실행
    // ================================================================
    {
        value = 10;
        anotherValue = 20;
        System.out.println("인스턴스 초기화 블록 실행: value=" + value + ", anotherValue=" + anotherValue);
    }

    public InitBlockDemo() {
        System.out.println("기본 생성자 호출");
    }

    public InitBlockDemo(int value) {
        this.value = value;  // 초기화 블록의 10을 덮어씀
        System.out.println("매개변수 생성자 호출: value=" + this.value);
    }

    public InitBlockDemo(int value, String tag) {
        this.value = value;
        this.tag = tag;
        System.out.println("태그 생성자 호출: value=" + this.value + ", tag=" + tag);
    }

    public String getStatus() {
        return "value=" + value + ", anotherValue=" + anotherValue + ", tag=" + tag;
    }
}

class StaticBlockDemo {
    public int instanceValue;
    public static int staticValue;

    // ================================================================
    // static 초기화 블록: 클래스 로딩 시 딱 한 번 실행
    // 인스턴스 생성 없이도 실행됨
    // ================================================================
    static {
        staticValue = 20;
        // instanceValue = 10;  // 컴파일 에러: 인스턴스 필드 접근 불가
        System.out.println("static 초기화 블록 실행: staticValue=" + staticValue);
    }
}

public class FinalAndInitBlockDemo {
    public static void main(String[] args) {

        // ================================================================
        // 1. final 필드 - 변경 시도
        // ================================================================
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle(3.0);

        System.out.println("c1 넓이: " + c1.getArea());
        System.out.println("c2 넓이: " + c2.getArea());

        // final 필드는 각 객체마다 독립적으로 존재하지만, 한 번 설정되면 변경 불가
        System.out.println("c1 반지름: " + c1.getRadius()); // 5.0
        System.out.println("c2 반지름: " + c2.getRadius()); // 3.0

        System.out.println();

        // ================================================================
        // 2. Java 표준 라이브러리의 static final 상수들
        // ================================================================
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Math.PI = " + Math.PI);
        System.out.println("Math.E  = " + Math.E);

        System.out.println();

        // ================================================================
        // 3. 인스턴스 초기화 블록 - 실행 순서 확인
        // ================================================================
        System.out.println("--- i1 생성 ---");
        InitBlockDemo i1 = new InitBlockDemo();

        System.out.println("--- i2 생성 ---");
        InitBlockDemo i2 = new InitBlockDemo(50);

        System.out.println("--- i3 생성 ---");
        InitBlockDemo i3 = new InitBlockDemo(99, "X");

        System.out.println();
        System.out.println("i1: " + i1.getStatus());
        System.out.println("i2: " + i2.getStatus()); // value=50으로 덮어써짐
        System.out.println("i3: " + i3.getStatus());

        System.out.println();

        // ================================================================
        // 4. static 초기화 블록 - 클래스 로딩 시 한 번만 실행
        // ================================================================
        // StaticBlockDemo를 처음 참조하는 시점에 static 블록이 실행됨
        System.out.println("StaticBlockDemo.staticValue = " + StaticBlockDemo.staticValue);
        System.out.println("StaticBlockDemo.staticValue = " + StaticBlockDemo.staticValue); // static 블록은 재실행 안 됨

        System.out.println();

        // ================================================================
        // 5. final + static 조합 - 클래스 상수 패턴
        // ================================================================
        // 일반적으로 상수는 public static final로 정의
        // Math.PI처럼 클래스 이름으로 접근하는 상수가 이 패턴
        final int MAX_RETRY = 3;    // 지역 상수: 해당 블록 안에서만 유효
        // MAX_RETRY = 5;           // 컴파일 에러
        System.out.println("MAX_RETRY = " + MAX_RETRY);
    }
}
```

## 코드 블록 4

```text
// VarargsDemo.java
// 주제: 가변 인자(varargs) - 개수가 유동적인 매개변수

public class VarargsDemo {

    // ================================================================
    // 1. 기본 가변 인자 - int... 로 선언, 내부적으로 배열로 처리됨
    // ================================================================
    static void printNumbers(int... numbers) {
        System.out.print("전달된 숫자들: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("배열 길이: " + numbers.length); // 배열처럼 .length 사용 가능
    }

    // ================================================================
    // 2. 일반 매개변수와 혼합 - 가변 인자는 반드시 마지막에
    // ================================================================
    static void log(String level, String... messages) {
        System.out.print("[" + level + "] ");
        for (String msg : messages) {
            System.out.print(msg + " ");
        }
        System.out.println();
    }

    // ================================================================
    // 3. 가변 인자 메서드 오버로딩 주의점
    //    - 컴파일러가 어떤 메서드를 선택할지 모호해질 수 있다
    // ================================================================
    static void ambiguous(int... nums) {
        System.out.println("int... 버전");
    }

    // static void ambiguous(int a, int... nums) { }
    // → ambiguous(1) 호출 시 어느 쪽인지 모호 → 컴파일 에러 가능

    // ================================================================
    // 4. 가변 인자 vs 배열 직접 전달
    // ================================================================
    static int sum(int... nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        return total;
    }

    public static void main(String[] args) {

        // 인자 개수 제한 없음
        printNumbers(1, 2, 3);
        printNumbers(10, 20, 30, 40, 50);

        // 인자를 전달하지 않아도 됨 → numbers.length == 0, 반복문 실행 안 됨
        printNumbers();

        System.out.println();

        // 일반 매개변수 + 가변 인자
        log("INFO", "서버 시작");
        log("ERROR", "파일 없음", "경로 오류");
        log("DEBUG"); // 메시지 없이 호출도 가능

        System.out.println();

        // 가변 인자에 배열을 직접 넘겨도 동작
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("sum(1,2,3) = " + sum(1, 2, 3));
        System.out.println("sum(arr)   = " + sum(arr));  // 배열 직접 전달

        System.out.println();

        // ================================================================
        // 5. String.format - 가변 인자를 활용하는 표준 라이브러리 예시
        // ================================================================
        String name = "철수";
        int age = 30;
        String gender = "남자";

        String s1 = String.format("이름: %s, 나이: %d", name, age);
        String s2 = String.format("이름: %s, 나이: %d, 성별: %s", name, age, gender);
        System.out.println(s1);
        System.out.println(s2);

        // printf도 내부적으로 가변 인자 사용
        System.out.printf("이름: %s, 나이: %d%n", name, age);
    }
}
```
