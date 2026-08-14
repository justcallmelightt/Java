class ParkingLot {
    private static final int MAX_CAPACITY = 5;
    private int currentCount = 0;

    void enter() {
        if (currentCount >= MAX_CAPACITY) {
            System.out.println("만차입니다. (정원: " + MAX_CAPACITY + "대)");
            return;
        }
        currentCount++;
    }

    void exit() {
        if (currentCount <= 0) {
            System.out.println("주차된 차량이 없습니다.");
            return;
        }
        currentCount--;
    }

    String getStatus() {
        return "현재 " + currentCount + "대 주차 중 (여유: " + (MAX_CAPACITY - currentCount) + "대)";
    }

    static int getMaxCapacity() {
        return MAX_CAPACITY;
    }
}

public class Q15 {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();
        for (int i = 0; i < 7; i++) {
            lot.enter();
        }
        System.out.println(lot.getStatus());
        for (int i = 0; i < 3; i++) {
            lot.exit();
        }
        System.out.println(lot.getStatus());
        for (int i = 0; i < 2; i++) {
            lot.exit();
        }
    }
}
