// GetterSetterDemo.java
class Product {
    String name;
    int price;
    int stock;

    // ================================================================
    // 1. 기본 게터/세터 — 단순 반환/대입
    // ================================================================
    String getName() { return name; }
    void setName(String name) { this.name = name; }

    int getPrice() { return price; }

    // ================================================================
    // 2. 세터에 유효성 검사 추가
    // ================================================================
    void setPrice(int price) {
        if (price < 0) {
            System.out.println("가격은 음수가 될 수 없습니다.");
            return;
        }
        this.price = price;
    }

    void setStock(int stock) {
        if (stock < 0) {
            System.out.println("재고는 음수가 될 수 없습니다.");
            return;  // 대입하지 않고 종료
        }
        this.stock = stock;
    }

    // ================================================================
    // 3. 게터에서 필드를 조합해 새로운 값 반환
    // ================================================================
    String getProductInfo() {
        return "[" + name + "] " + price + "원 (재고: " + stock + "개)";
    }

    int getTotalValue() {
        return price * stock;
    }
}

public class GetterSetterDemo {

    public static void main(String[] args) {

        Product p = new Product();

        // 정상 입력
        p.setName("노트북");
        p.setPrice(1200000);
        p.setStock(10);
        System.out.println(p.getProductInfo());
        System.out.println("총 재고 가치: " + p.getTotalValue() + "원");

        System.out.println();

        // ================================================================
        // 4. 세터 없이 직접 필드 접근 vs 세터 사용 비교
        // ================================================================
        // 직접 접근: 유효성 검사 없이 잘못된 값이 들어갈 수 있다
        p.price = -500;   // 아무 제약 없이 대입됨
        System.out.println("직접 대입 후 price = " + p.price); // -500

        // 세터 사용: 유효성 검사가 작동한다
        p.setPrice(-500); // "가격은 음수가 될 수 없습니다." 출력 후 무시
        System.out.println("세터 사용 후 price = " + p.price); // 그대로 -500 (직접 대입 값)

        System.out.println();

        // ================================================================
        // 5. this 키워드 — 매개변수명과 필드명이 같을 때
        // ================================================================
        // setName(String name)에서
        //   this.name = name 의 this.name은 필드
        //   name은 매개변수
        // this 없이 name = name 으로 쓰면 매개변수에 매개변수를 대입하는 것 → 필드 변경 안 됨
        Product p2 = new Product();
        p2.setName("마우스");
        System.out.println("p2.name = " + p2.getName()); // 마우스
    }
}
