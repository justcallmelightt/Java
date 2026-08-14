import java.util.Scanner;

class GachaMachine {
    private int[] counts = new int[3]; // 0: 일반, 1: 희귀, 2: 전설
    private String[] names = {"일반", "희귀", "전설"};

    String pull() {
        int rand = (int)(Math.random() * 100); // 0~99
        int grade;
        if (rand < 70) {
            grade = 0;
        } else if (rand < 95) {
            grade = 1;
        } else {
            grade = 2;
        }
        counts[grade]++;
        return names[grade];
    }

    void printStats() {
        int total = counts[0] + counts[1] + counts[2];
        System.out.println("총 뽑기 횟수: " + total + "회");
        for (int i = 0; i < counts.length; i++) {
            System.out.println(names[i] + ": " + counts[i] + "회");
        }
    }
}

public class GachaSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GachaMachine machine = new GachaMachine();

        while (true) {
            System.out.println("===== 가챠 시뮬레이터 =====");
            System.out.println("1. 뽑기");
            System.out.println("2. 결과 통계 보기");
            System.out.println("3. 종료");
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();

            if (menu == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (menu) {
                case 1:
                    String result = machine.pull();
                    System.out.println("결과: " + result);
                    break;
                case 2:
                    machine.printStats();
                    break;
                default:
                    System.out.println("잘못된 메뉴입니다.");
            }
            System.out.println();
        }
        sc.close();
    }
}
