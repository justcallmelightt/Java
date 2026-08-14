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

public class Q07 {
    public static void main(String[] args) {
        Product p1 = new Product();
        Product p2 = new Product("노트북", 1200000);
        System.out.println(p1.name + " / " + p1.price + "원");
        System.out.println(p2.name + " / " + p2.price + "원");
    }
}
