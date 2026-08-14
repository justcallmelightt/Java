import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] record = new int[3]; // 0: 승, 1: 패, 2: 무
        String[] names = {"가위", "바위", "보"};

        while (true) {
            System.out.println("===== 가위바위보 =====");
            System.out.println("1. 가위");
            System.out.println("2. 바위");
            System.out.println("3. 보");
            System.out.println("4. 종료");
            System.out.print("메뉴 선택: ");
            int user = sc.nextInt();

            if (user == 4) {
                System.out.println("전적 - 승: " + record[0] + " 패: " + record[1] + " 무: " + record[2]);
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            if (user < 1 || user > 3) {
                System.out.println("잘못된 메뉴입니다.");
                System.out.println();
                continue;
            }

            int com = (int)(Math.random() * 3) + 1;
            System.out.println("나: " + names[user - 1] + " / 컴퓨터: " + names[com - 1]);

            if (user == com) {
                System.out.println("무승부");
                record[2]++;
            } else if ((user == 1 && com == 3) || (user == 2 && com == 1) || (user == 3 && com == 2)) {
                System.out.println("승리");
                record[0]++;
            } else {
                System.out.println("패배");
                record[1]++;
            }
            System.out.println();
        }
        sc.close();
    }
}
