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

public class Q18 {
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
