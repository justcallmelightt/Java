/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 24번 문제 - 메서드 체인 (CoffeeOrderChainPractice.java)
 *
 * 문제 조건:
 * 1. 커피 주문을 표현하는 CoffeeOrder 클래스를 작성하시오.
 * 2. 메뉴(menu), 사이즈(size), 샷 추가 여부(extraShot), 컵 종류(cup) 필드를 가진다.
 * 3. 조건1. setMenu(), setSize(), setExtraShot(), setCup() 세터는 각각
 * 4. CoffeeOrder를 반환하고 마지막에 return this; 를 작성한다.
 * 5. 조건2. getOrder()는 주문 내용을 문자열로 반환한다.
 * 6. 조건3. main에서 아래처럼 이어 붙여서 호출하시오.
 * 7. order.setMenu("아메리카노").setSize("Large").setExtraShot(true).setCup("매장 컵");
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 조건문으로 잘못된 입력과 경계 상황을 검사한다.
 * 3. 현재 객체를 반환해 메서드 호출을 연속해서 연결한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class CoffeeOrder {
    String menu;
    String size;
    boolean extraShot;
    String cup;

    CoffeeOrder setMenu(String menu) {
        this.menu = menu;
        return this;
    }

    CoffeeOrder setSize(String size) {
        this.size = size;
        return this;
    }

    CoffeeOrder setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
        return this;
    }

    CoffeeOrder setCup(String cup) {
        this.cup = cup;
        return this;
    }

    String getOrder() {
        String shot = extraShot ? "샷 추가" : "샷 추가 없음";
        return "[ 주문 내역 ] " + menu + " / " + size + " / " + shot + " / " + cup;
    }
}

public class CoffeeOrderChainPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        CoffeeOrder order = new CoffeeOrder();
        order.setMenu("아메리카노").setSize("Large").setExtraShot(true).setCup("매장 컵");
        System.out.println(order.getOrder());
    }
}
