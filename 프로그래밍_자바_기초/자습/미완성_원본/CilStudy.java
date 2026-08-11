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
