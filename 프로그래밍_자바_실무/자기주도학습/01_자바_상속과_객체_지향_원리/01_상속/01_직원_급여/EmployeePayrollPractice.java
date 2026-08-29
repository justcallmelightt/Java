/**
 * [프로그래밍 자바 실무] - 자기주도학습
 *
 * 주제: 상속을 이용한 직원별 급여 계산
 *
 * 학습 조건:
 * 1. Employee 클래스에 이름과 기본 급여를 저장한다.
 * 2. Developer와 Manager가 Employee를 상속한다.
 * 3. 각 자식 클래스는 calculatePay()를 자신의 급여 규칙에 맞게 재정의한다.
 * 4. Employee 배열에 서로 다른 자식 객체를 저장하고 같은 메서드로 급여를 출력한다.
 *
 * 학습 목표:
 * 1. extends를 사용한 클래스 상속 구조를 이해한다.
 * 2. super 생성자로 부모 클래스의 필드를 초기화한다.
 * 3. 메서드 재정의와 다형성을 함께 연습한다.
 */
class Employee {
    private final String name;
    private final int basePay;

    Employee(String name, int basePay) {
        this.name = name;
        this.basePay = basePay;
    }

    String getName() {
        return name;
    }

    int getBasePay() {
        return basePay;
    }

    int calculatePay() {
        return basePay;
    }
}

class Developer extends Employee {
    private final int projectBonus;

    Developer(String name, int basePay, int projectBonus) {
        // 부모 생성자를 호출해 Employee가 관리하는 공통 상태를 먼저 초기화한다.
        super(name, basePay);
        this.projectBonus = projectBonus;
    }

    @Override
    int calculatePay() {
        return getBasePay() + projectBonus;
    }
}

class Manager extends Employee {
    private final int teamAllowance;

    Manager(String name, int basePay, int teamAllowance) {
        super(name, basePay);
        this.teamAllowance = teamAllowance;
    }

    @Override
    int calculatePay() {
        return getBasePay() + teamAllowance;
    }
}

public class EmployeePayrollPractice {
    public static void main(String[] args) {
        // 부모 타입 배열에는 Employee를 상속한 모든 객체를 저장할 수 있다.
        Employee[] employees = {
            new Employee("일반 직원", 2_500_000),
            new Developer("개발자", 3_000_000, 500_000),
            new Manager("팀장", 3_500_000, 700_000)
        };

        for (Employee employee : employees) {
            // 실제 객체에 따라 재정의된 calculatePay()가 선택된다.
            System.out.printf("%s 급여: %,d원%n", employee.getName(), employee.calculatePay());
        }
    }
}
