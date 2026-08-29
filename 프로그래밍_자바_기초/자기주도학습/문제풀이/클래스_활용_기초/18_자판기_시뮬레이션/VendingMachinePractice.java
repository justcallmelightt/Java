/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 18번 문제 - 자판기 시뮬레이션 (VendingMachinePractice.java)
 *
 * 문제 조건:
 * 1. 상품명(name)과 가격(price) 필드를 가진 Item 클래스를 작성하시오.
 * 2. VendingMachine 클래스는 Item 배열(5칸)과 잔액(balance) 필드를 가진다.
 * 3. - addItem(int slot, Item item) : 해당 슬롯에 상품 등록
 * 4. - insertMoney(int amount) : 잔액 추가
 * 5. - buy(int slot) : 해당 슬롯 상품 구매.
 * 6. 슬롯이 비어있으면 "상품이 없습니다.",
 * 7. 잔액 부족이면 "잔액이 부족합니다. (잔액: N원, 가격: N원)" 출력,
 * 8. 구매 성공 시 "N 구매 완료. 잔액: N원" 출력
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 배열과 반복문으로 여러 객체 또는 데이터를 순서대로 처리한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Item {
    String name;
    int price;

    Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

class VendingMachine {
    Item[] items = new Item[5];
    int balance;

    void addItem(int slot, Item item) {
        items[slot] = item;
    }

    void insertMoney(int amount) {
        balance += amount;
    }

    void buy(int slot) {
        if (items[slot] == null) {
            System.out.println("상품이 없습니다.");
            return;
        }
        if (balance < items[slot].price) {
            System.out.println("잔액이 부족합니다. (잔액: " + balance + "원, 가격: " + items[slot].price + "원)");
            return;
        }
        balance -= items[slot].price;
        System.out.println(items[slot].name + " 구매 완료. 잔액: " + balance + "원");
    }
}

public class VendingMachinePractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        vm.addItem(0, new Item("콜라", 1200));
        vm.addItem(1, new Item("사이다", 1100));
        vm.insertMoney(500);
        vm.buy(0);
        vm.buy(3);
        vm.insertMoney(1000);
        vm.buy(0);
    }
}
