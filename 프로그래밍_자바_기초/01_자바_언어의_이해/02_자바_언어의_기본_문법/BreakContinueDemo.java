public class BreakContinueDemo {

    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static void printMessage() {
        System.out.println("메시지 출력");
        return;
    }

    public static void main(String[] args) {

        // =========================================================
        // 1. break - 반복문을 즉시 탈출
        //    break 이전에 출력 → 7 미포함
        // =========================================================
        for (int i = 1; i <= 10; i++) {
            if (i == 7) {
                break;
            }
            System.out.print(i + "\t");
        }
        System.out.println();
        // 출력: 1 2 3 4 5 6

        // break 이후에 출력 → 7 포함
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "\t");
            if (i == 7) {
                break;
            }
        }
        System.out.println();
        // 출력: 1 2 3 4 5 6 7

        // =========================================================
        // 2. [핵심] break는 가장 가까운 반복문 하나만 탈출한다
        //    중첩 루프에서 바깥 루프까지 한 번에 탈출하지 못한다
        // =========================================================
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 2) {
                    break;              // 안쪽 for만 탈출
                }
                System.out.print("i=" + i + " j=" + j + "  ");
            }
            System.out.println();
        }
        // 출력: i=1 j=1 / i=2 j=1 / i=3 j=1  (바깥 루프는 계속 돈다)

        // =========================================================
        // 3. continue - 이후 코드를 건너뛰고 다음 반복으로 이동
        // =========================================================
        for (int i = 1; i <= 10; i++) {
            if (i == 7) {
                continue;
            }
            System.out.print(i + "\t");
        }
        System.out.println();
        // 출력: 1 2 3 4 5 6 8 9 10

        // =========================================================
        // 4. [핵심] while에서 continue 사용 시 변화식 위치 주의
        //    변화식이 continue 아래에 있으면 건너뛰어 무한 루프 발생
        // =========================================================
        int i = 0;
        while (i < 10) {
            i++;
            if (i == 7) {
                continue;               // i++ 이후이므로 안전
            }
            System.out.print(i + "\t");
        }
        System.out.println();

        // 아래는 무한 루프 예시 (주석 처리)
        // int k = 0;
        // while (k < 10) {
        //     if (k == 7) {
        //         continue;            // k가 7이면 k++를 건너뜀 → 영원히 7
        //     }
        //     k++;
        // }

        // =========================================================
        // 5. return - 메서드 종료 및 값 반환
        // =========================================================
        System.out.println("합계 : " + sum(5, 3));
        printMessage();

        // =========================================================
        // 6. [고급] return vs break
        //    break는 반복문만 탈출하지만, return은 메서드 자체를 종료한다
        // =========================================================
        System.out.println("첫 번째 짝수: " + findFirstEven(1, 10));
    }

    public static int findFirstEven(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                return i;               // 찾는 순간 메서드 종료
            }
        }
        return -1;
    }
}
