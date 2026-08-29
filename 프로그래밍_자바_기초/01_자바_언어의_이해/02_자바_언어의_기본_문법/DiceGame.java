import java.util.Scanner;

class DiceRecord {
    private int round;
    private int value;

    DiceRecord(int round, int value) {
        this.round = round;
        this.value = value;
    }

    int getRound() { return round; }
    int getValue() { return value; }
    void setRound(int round) { this.round = round; }
    void setValue(int value) { this.value = value; }
}

class Dice {
    private DiceRecord[] history = new DiceRecord[100];
    private int rollCount = 0;

    int roll() {
        int result = (int)(Math.random() * 6) + 1;
        history[rollCount] = new DiceRecord(rollCount + 1, result);
        rollCount++;
        return result;
    }

    boolean hasHistory() {
        return rollCount > 0;
    }

    void printHistory() {
        for (int i = 0; i < rollCount; i++) {
            System.out.println(history[i].getRound() + "번째: " + history[i].getValue());
        }
    }

    int getMax() {
        int max = history[0].getValue();
        for (int i = 1; i < rollCount; i++) {
            if (history[i].getValue() > max) {
                max = history[i].getValue();
            }
        }
        return max;
    }

    int getMin() {
        int min = history[0].getValue();
        for (int i = 1; i < rollCount; i++) {
            if (history[i].getValue() < min) {
                min = history[i].getValue();
            }
        }
        return min;
    }
}

public class DiceGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Dice dice = new Dice();

        while (true) {
            System.out.println("===== 주사위 게임 =====");
            System.out.println("1. 굴리기");
            System.out.println("2. 기록 보기");
            System.out.println("3. 최댓값/최솟값 보기");
            System.out.println("4. 종료");
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();

            if (menu == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (menu) {
                case 1:
                    System.out.println("결과: " + dice.roll());
                    break;
                case 2:
                    if (!dice.hasHistory()) {
                        System.out.println("기록이 없습니다.");
                    } else {
                        dice.printHistory();
                    }
                    break;
                case 3:
                    if (!dice.hasHistory()) {
                        System.out.println("기록이 없습니다.");
                    } else {
                        System.out.println("최댓값: " + dice.getMax() + " / 최솟값: " + dice.getMin());
                    }
                    break;
                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
            System.out.println();
        }
        sc.close();
    }
}
