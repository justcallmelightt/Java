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

public class Q16 {
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
