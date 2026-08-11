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
