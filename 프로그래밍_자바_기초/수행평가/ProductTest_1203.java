import java.util.Scanner;

/**
 * 상품 한 개의 정보를 저장하고 출력하는 클래스
 *
 * 멤버변수:
 * 1. category: 상품의 구분
 * 2. name: 상품명
 * 3. stock: 현재 재고량
 * 4. price: 상품의 단가
 */
class Product {
    // 1. [조건 1] 상품의 구분, 상품명, 재고량, 단가를 저장할 멤버변수 선언
    String category;
    String name;
    int stock;
    int price;

    // 2. [조건 3] 객체 생성 시 전달받은 값으로 모든 멤버변수를 초기화하는 생성자
    Product(String category, String name, int stock, int price) {
        this.category = category;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    // 3. 상품 한 개의 정보를 한 줄로 출력하는 메소드
    void printInfo() {
        System.out.println(category + " " + name + " " + stock + " " + price);
    }
}

/**
 * [프로그래밍 자바 기초] - 자바 프로그래밍 수행평가
 *
 * 문제명: Product 클래스 — 상품 목록 출력 (ProductTest_1203.java)
 *
 * 문제 조건 및 학습 목표:
 * 1. [조건 1] Product 클래스에 구분, 상품명, 재고량, 단가 필드 정의
 * 2. [조건 2] 5개의 상품 정보를 입력받아 Product 객체 생성
 * 3. [조건 3] 생성자를 사용하여 모든 멤버변수 초기화
 * 4. [조건 4] 상품 목록과 상품의 총 재고량 출력
 * 5. 클래스, 객체 배열, 생성자, 반복문과 메소드 사용 방법 학습
 *
 * 작성자: 미림마이스터고등학교 뉴미디어소프트웨어과 1203 권율
 */
public class ProductTest_1203 {
    public static void main(String[] args) {
        // 4. 키보드 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 5. [조건 2] 5개의 Product 객체를 저장할 배열 생성
        Product[] products = new Product[5];

        // 6. 반복문으로 5개의 상품 정보를 차례대로 입력받음
        for (int i = 0; i < products.length; i++) {
            // 상품의 구분과 상품명은 공백을 포함할 수 있으므로 nextLine()으로 입력
            System.out.print("상품" + (i + 1) + " 구분 : ");
            String category = sc.nextLine();

            System.out.print("상품" + (i + 1) + " 상품명 : ");
            String name = sc.nextLine();

            System.out.print("상품" + (i + 1) + " 재고량 : ");
            int stock = sc.nextInt();

            System.out.print("상품" + (i + 1) + " 단가 : ");
            int price = sc.nextInt();

            // nextInt() 뒤에 남아 있는 줄바꿈 문자를 제거
            sc.nextLine();

            // 7. [조건 2, 3] 생성자를 사용하여 Product 객체를 만들고 배열에 저장
            products[i] = new Product(category, name, stock, price);
        }

        // 8. 상품 목록의 제목을 출력
        System.out.println("─────────────────────");
        System.out.println("구분 상품명 재고량 단가");

        // 9. 모든 상품의 재고량을 더할 변수
        int totalStock = 0;

        // 10. [조건 4] 저장된 상품 객체를 모두 출력하고 총 재고량 계산
        for (int i = 0; i < products.length; i++) {
            // Product 클래스의 출력 메소드를 호출
            products[i].printInfo();
            totalStock = totalStock + products[i].stock;
        }

        // 11. 계산된 총 재고량을 출력
        System.out.println("─────────────────────");
        System.out.println("상품의 총 재고량 : " + totalStock);

        // Resource leak 방지를 위해 사용이 끝난 Scanner 객체 해제
        sc.close();
    }
}
