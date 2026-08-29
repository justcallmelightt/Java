/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 21번 문제 - this로 생성자 체인 (ContactConstructorChainPractice.java)
 *
 * 문제 조건:
 * 1. 주소(address), 전화번호(phone), 이메일(email) 필드를 가진 Contact 클래스를 작성하시오.
 * 2. 조건1. 매개변수 3개짜리 생성자를 작성한다.
 * 3. 조건2. 매개변수 2개짜리 생성자(address, phone)는 this()를 이용해
 * 4. 3개짜리 생성자를 호출하되, email은 "없음"으로 처리한다.
 * 5. 조건3. 기본 생성자도 this를 이용해 2개짜리 생성자를 호출하되,
 * 6. address는 "미정", phone은 "미정"으로 처리한다.
 * 7. 조건4. getInfo()는 세 필드를 합쳐서 반환한다.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 * 3. 조건문으로 잘못된 입력과 경계 상황을 검사한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Contact {
    String address;
    String phone;
    String email;

    Contact(String address, String phone, String email) {
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    Contact(String address, String phone) {
        this(address, phone, "없음");
    }

    Contact() {
        this("미정", "미정");
    }

    String getInfo() {
        return address + " / " + phone + " / " + email;
    }
}

public class ContactConstructorChainPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Contact c1 = new Contact();
        Contact c2 = new Contact("서울", "010-1234-5678");
        Contact c3 = new Contact("부산", "010-9999-0000", "hong@test.com");
        System.out.println(c1.getInfo());
        System.out.println(c2.getInfo());
        System.out.println(c3.getInfo());
    }
}
