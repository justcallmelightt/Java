/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 7번 문제 - 기본 생성자 + 매개변수 생성자 (ProductConstructorPractice.java)
 *
 * 문제 조건:
 * 1. 상품명(name)과 가격(price) 필드를 가진 Product 클래스를 정의하시오.
 * 2. 기본 생성자는 name을 "미정", price를 0으로 초기화한다.
 * 3. 매개변수 생성자는 name과 price를 전달받아 초기화한다.
 * 4. 두 생성자 모두 사용해서 객체를 만들고 출력하시오.
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

    Product() {
        this.name = "미정";
        this.price = 0;
    }

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

public class ProductConstructorPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product("노트북", 1200000);
        System.out.println(p1.name + " / " + p1.price + "원");
        System.out.println(p2.name + " / " + p2.price + "원");
    }
}
