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

public class Q24 {
    public static void main(String[] args) {
        CoffeeOrder order = new CoffeeOrder();
        order.setMenu("아메리카노").setSize("Large").setExtraShot(true).setCup("매장 컵");
        System.out.println(order.getOrder());
    }
}
