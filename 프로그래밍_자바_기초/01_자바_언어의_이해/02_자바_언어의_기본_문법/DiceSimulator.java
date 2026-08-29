import java.util.Scanner;

public class DiceSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;

        while (true) {
            System.out.println("===== 주사위 시뮬레이터 =====");
            System.out.println("1. 주사위 굴리기");
            System.out.println("2. 종료");
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();

            if (menu == 2) {
                System.out.println("총 " + count + "번 굴렸습니다.");
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (menu == 1) {
                int result = (int)(Math.random() * 6) + 1;
                System.out.println("결과: " + result);
                count++;
            } else {
                System.out.println("잘못된 메뉴입니다.");
            }
            System.out.println();
        }
        sc.close();
    }
}
