import java.util.Random;
import java.util.Scanner;

class GachaMachine {
    int pullCount = 0; // 총 뽑은 횟수
    int[] counts = {0, 0, 0}; // 각각 일반, 희귀, 전설

    String pull() {
        pullCount++; // 횟수 증가
        Random random = new Random();
        int num = random.nextInt(0, 100); // 0~99까지
        String result = "";
        // 범위 검사하여 등급 결정
        if(num >= 0 && num <= 69) {
            result = "일반";
            counts[0]++;
        } else if(num >= 70 && num <= 94) {
            result = "희귀";
            counts[1]++;
        } else if(num >= 95 && num <= 99) {
            result = "전설";
            counts[2]++;
        }
        return result;
    }

    void printStatus() {
        System.out.println("총 뽑기 횟수: " + pullCount);
        System.out.println("일반: " + counts[0]);
        System.out.println("희귀: " + counts[1]);
        System.out.println("전설: " + counts[2]);
    }
}

class DiceRecord {
    int round;
    int value;

    public DiceRecord(int round, int value) {
        this.round = round;
        this.value = value;
    }
    public int getRound() {
        return round;
    }
    public void setRound(int round) {
        this.round = round;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}

class Dice {
    DiceRecord[] records = new DiceRecord[100];
    int rollCount = 0;

    int roll() {
        Random random = new Random();
        int num = random.nextInt(1, 7);
        records[rollCount] = new DiceRecord(rollCount + 1, num);
        rollCount++;
        return num;
    }

    boolean hasHistory() {
        return rollCount > 0;
    }

    void printHistory() {
        for(int i=0;i<rollCount;i++) {
            System.out.println(records[i].getRound() + "번째: " + records[i].getValue());
        }
    }

    int getMax() {
        if(hasHistory()) {
            int max = records[0].getValue();
            for(int i=0;i<rollCount;i++) {
                if(records[i].getValue() > max) max = records[i].getValue();
            }
            return max;
        } else {
            System.out.println("굴린 적 없음.");
            return -1;
        }
    }

    int getMin() {
        if(hasHistory()) {
            int min = records[0].getValue();
            for(int i=0;i<rollCount;i++) {
                if(records[i].getValue() < min) min = records[i].getValue();
            }
            return min;
        } else {
            System.out.println("굴린 적 없음.");
            return -1;
        }
    }
}

public class CliStudy {
    public static void main(String[] args) {
        /*
        // 4번 문제
        Scanner sc = new Scanner(System.in);
        System.out.println("===== 가챠 시뮬레이터 =====");
        System.out.println("1. 뽑기");
        System.out.println("2. 결과 통계 보기");
        System.out.println("3. 종료");
        GachaMachine machine = new GachaMachine();
        while(true) {
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            if (menu == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if(menu == 2) {
                machine.printStatus();
            } else if(menu == 1) {
                String result = machine.pull();
                System.out.println("결과:" + result);
            } else {
                System.out.println("잘못된 입력.");
            }
        }
        */

        /*
        // 3번 문제
        Scanner sc = new Scanner(System.in);
        System.out.println("===== 주사위 게임 =====");
        System.out.println("1. 굴리기");
        System.out.println("2. 기록 보기");
        System.out.println("3. 최대값/최솟값 보기");
        System.out.println("4. 종료");
        Dice dice = new Dice();
        while(true) {
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            if(menu == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if(menu == 3) {
                System.out.printf("최댓값: %d / 최솟값: %d%n", dice.getMax(), dice.getMin());
            } else if(menu == 2){
                if(dice.hasHistory()) {
                    dice.printHistory();
                } else {
                    System.out.println("굴린적이 없습니다.");
                }
            } else if(menu == 1) {
                int num = dice.roll();
                String result = String.format("결과: %d", num);
                System.out.println(result);
            } else {
                System.out.println("잘못된 번호 입력.");
            }
        }
        */

        /*
        // 2번 문제
        Scanner sc = new Scanner(System.in);
        System.out.println("===== 가위바위보 =====");
        int[] status = {0, 0, 0}; // 각각 승, 패, 무
        while(true) {
            System.out.println("1. 가위");
            System.out.println("2. 바위");
            System.out.println("3. 보");
            System.out.println("4. 종료");
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            if(menu == 4) {
                System.out.println("전적 - 승: "+ status[0] + " 패: " + status[1] + " 무: " + status[2]);
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if(menu == 1 || menu == 2 || menu == 3) {
                // 노가다
                Random random = new Random();
                int computerNum = random.nextInt(1, 4); // 1 ~ 3
                String[] hands = {"가위", "바위", "보"};
                System.out.println("나: " + hands[menu - 1] + " 컴퓨터: " + hands[computerNum - 1]);
                if (menu == 1) {
                    if(computerNum == 1) {
                        status[2]++;
                        System.out.println("무승부");
                    }
                    if(computerNum == 2) {
                        status[1]++;
                        System.out.println("패배");
                    }
                    if(computerNum == 3) {
                        status[0]++;
                        System.out.println("승리");
                    }
                }
                // 나머지는 한 번 해보기
                if (menu == 2) {
                    if(computerNum == 1) {
                        status[0]++;
                        System.out.println("승리");

                    }
                    if(computerNum == 2) {
                        status[2]++;
                        System.out.println("무승부");
                    }
                    if(computerNum == 3) {
                        status[1]++;
                        System.out.println("패배");
                    }
                }
                if (menu == 3) {
                    if(computerNum == 1) {
                        status[1]++;
                        System.out.println("패배");
                    }
                    if(computerNum == 2) {
                        status[0]++;
                        System.out.println("승리");
                    }
                    if(computerNum == 3) {
                        status[2]++;
                        System.out.println("무승부");
                    }
                }
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        */

        /*
        // 1번 문제
        Scanner sc = new Scanner(System.in);
        System.out.println("===== 주사위 시뮬레이터 =====");
        int count = 0;
        while(true) {
            System.out.println("1. 주사위 굴리기");
            System.out.println("2. 종료");
            System.out.print("메뉴 선택: ");
            int menu = sc.nextInt();
            if(menu == 2) {
                System.out.println("총 " + count + "번 굴렸습니다.");
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if(menu == 1) {
                int dice = (int) (Math.random() * 6) + 1;
                System.out.println("결과: " + dice);
                count++;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
        */
    }
}
