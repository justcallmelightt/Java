/**
 * [프로그래밍 자바 기초] - 자바 프로그래밍 수행평가
 *
 * 문제명: 회원 정보 관리 프로그램 (Member_1203.java)
 *
 * 문제 조건 및 학습 목표:
 * 1. [조건 1] Member 클래스에 name, age, point 멤버 변수(필드) 선언
 * 2. [조건 2] setAge()에서 나이가 0 미만이면 오류 메시지를 출력하고 대입하지 않음
 * 3. [조건 3] getInfo()에서 필드를 참조하여 정해진 형식의 문자열 반환
 * 4. [조건 4] 사용자에게 이름, 나이, 포인트를 입력받아 Member 객체 생성
 * 5. 생성자, this, 필드, 메서드, 객체 생성 및 메서드 호출 방법 학습
 *
 * 작성자: 미림마이스터고등학교 뉴미디어소프트웨어과 1203 권율
 */

import java.util.Scanner;

// 회원 한 명의 이름, 나이, 포인트를 저장하고 관리하는 클래스
class Member {
    // 1. [조건 1] Member 객체가 가지는 3개의 멤버 변수(필드) 선언
    String name;
    int age;
    int point;

    // 2. Member 객체 생성 시 이름, 나이, 포인트를 전달받는 생성자
    Member(String name, int age, int point) {
        // this.필드는 현재 객체의 필드이고, 오른쪽 변수는 생성자가 전달받은 값이다.
        this.name = name;
        this.age = age;
        this.point = point;
    }

    // 3. [조건 2] 전달받은 나이를 검사한 후 변경하는 메서드
    public void setAge(int age) {
        // 전달받은 나이가 0 미만이면 유효하지 않은 값이므로 안내 문구를 출력한다.
        if (age < 0) {
            System.out.println("유효하지 않은 나이입니다.");

            // 메서드를 즉시 종료하여 잘못된 나이가 age 필드에 대입되지 않게 한다.
            return;
        }

        // 0 이상의 유효한 나이인 경우에만 현재 객체의 age 필드를 변경한다.
        this.age = age;
    }

    // 4. [조건 3] 현재 객체의 필드를 정해진 형식의 문자열로 반환하는 메서드
    public String getInfo() {
        // 문자열 연결 연산자(+)를 사용하여 이름, 나이, 포인트를 하나의 문자열로 만든다.
        return "이름: " + name + " | 나이: " + age + "세 | 포인트: " + point;
    }
}

// 프로그램의 시작점인 main() 메서드를 포함하는 실행 클래스
public class Member_1203 {
    public static void main(String[] args) {
        // 5. 키보드로 값을 입력받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 6. [조건 4] 사용자에게 이름을 문자열로 입력받음
        // - 이름에는 공백이 포함될 수 있으므로 한 줄 전체를 읽는 nextLine() 사용
        System.out.print("이름 : ");
        String name = scanner.nextLine();

        // 7. [조건 4] 사용자에게 나이와 포인트를 정수로 입력받음
        System.out.print("나이 : ");
        int age = scanner.nextInt();

        System.out.print("포인트 : ");
        int point = scanner.nextInt();

        // 8. [조건 4] 입력받은 값을 생성자에 전달하여 Member 객체 생성
        // - new 연산자는 새로운 객체를 만들고 Member 생성자를 호출한다.
        Member member = new Member(name, age, point);

        // 9. getInfo()가 반환한 최초 회원 정보 출력
        System.out.println(member.getInfo());

        // 10. 변경할 나이를 입력받아 setAge()의 매개변수로 전달
        // - setAge() 내부에서 나이가 유효한지 검사한 후 변경 여부를 결정한다.
        System.out.print("변경할 나이 : ");
        int newAge = scanner.nextInt();
        member.setAge(newAge);

        // 11. 나이 변경 또는 유효성 검사 결과가 반영된 회원 정보 출력
        System.out.println(member.getInfo());

        // Resource leak 방지를 위해 사용이 끝난 Scanner 객체 해제
        scanner.close();
    }
}
