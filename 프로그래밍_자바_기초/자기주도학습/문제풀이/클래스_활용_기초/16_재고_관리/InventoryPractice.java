/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 16번 문제 - 재고 관리 (InventoryPractice.java)
 *
 * 문제 조건:
 * 1. 상품명(name), 가격(price), 재고(stock) 필드를 가진 Product 클래스를 작성하시오.
 * 2. - 매개변수 생성자로 초기화
 * 3. - sell(int qty) : qty만큼 판매. 재고 부족 시 "재고가 부족합니다. (현재 재고: N개)" 출력
 * 4. - restock(int qty) : qty만큼 재고 추가. 0 이하 입력 시 "유효하지 않은 수량입니다." 출력
 * 5. - getInfo() : "상품명 | 가격원 | 재고: N개" 형태 문자열 반환
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Product {
    String name;
    int price;
    int stock;

    Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    void sell(int qty) {
        if (qty > stock) {
            System.out.println("재고가 부족합니다. (현재 재고: " + stock + "개)");
            return;
        }
        stock -= qty;
    }

    void restock(int qty) {
        if (qty <= 0) {
            System.out.println("유효하지 않은 수량입니다.");
            return;
        }
        stock += qty;
    }

    String getInfo() {
        return name + " | " + price + "원 | 재고: " + stock + "개";
    }
}

public class InventoryPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Product p = new Product("노트북", 1200000, 10);
        System.out.println(p.getInfo());
        p.sell(3);
        System.out.println(p.getInfo());
        p.sell(999);
        p.restock(-5);
        p.restock(5);
        System.out.println(p.getInfo());
    }
}
