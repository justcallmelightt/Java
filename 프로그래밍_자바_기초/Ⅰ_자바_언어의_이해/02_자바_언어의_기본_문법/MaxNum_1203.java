import java.util.Random;
import java.util.Scanner;

/**
 * [프로그래밍 자바 기초] - 자바 프로그래밍 수행평가
 *
 * 문제명: 2차원 배열 최댓값과 위치 출력 (MaxNum_1203.java)
 *
 * 문제 조건 및 학습 목표:
 * 1. [조건 1] 배열의 크기 N을 입력받아 N×N 크기의 2차원 배열 생성
 * 2. [조건 2] Random 클래스를 활용하여 임의의 수 발생
 * 3. [조건 3] 1부터 100까지의 임의의 수를 2차원 배열에 저장
 * 4. [조건 4] 배열에서 최댓값을 찾고 해당 위치를 (행, 열) 순서로 출력
 * 5. [조건 5] 최댓값이 여러 개이면 가장 먼저 발견한 데이터의 위치 출력
 * 6. Scanner, Random, 2차원 배열, 중첩 반복문과 조건문 사용 방법 학습
 *
 * 작성자: 미림마이스터고등학교 뉴미디어소프트웨어과 1203 권율
 */
public class MaxNum_1203 {
    public static void main(String[] args) {
        // 1. 키보드로 배열의 크기를 입력받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 2. 임의의 수를 발생시키기 위한 Random 객체 생성
        Random random = new Random();

        // 3. [조건 1] 사용자에게 배열의 크기 N을 입력받음
        System.out.print("배열의 크기 : ");
        int n = sc.nextInt();

        // 4. [조건 1] 입력받은 N을 이용하여 N×N 크기의 2차원 배열 생성
        int[][] numbers = new int[n][n];

        // 5. 최댓값과 최댓값이 저장된 행, 열의 위치를 기억할 변수
        // - 난수의 범위가 1~100이므로 최댓값의 초기값을 0으로 설정
        int max = 0;
        int maxRow = 0;
        int maxColumn = 0;

        // 6. [조건 2, 3] 중첩 반복문으로 2차원 배열의 모든 칸을 순서대로 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // random.nextInt(100)은 0~99를 반환하므로 1을 더해 1~100으로 만듦
                numbers[i][j] = random.nextInt(100) + 1;

                // 7. [조건 4] 현재 값이 저장된 최댓값보다 큰 경우에만 갱신
                // - 같은 값일 때는 갱신하지 않으므로 가장 먼저 발견한 위치가 유지됨
                if (numbers[i][j] > max) {
                    max = numbers[i][j];
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }

        // 8. 생성된 배열의 크기와 안내 문구 출력
        System.out.println(n + " X " + n + " 배열의 데이터 :");

        // 9. 2차원 배열에 저장된 모든 데이터를 행 단위로 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }

        // 10. [조건 4, 5] 최댓값과 가장 먼저 발견한 최댓값의 위치 출력
        // - 배열의 위치는 0번부터 시작하며 (행, 열) 순서로 표시
        System.out.println("최댓값 : " + max);
        System.out.println("최댓값의 위치 : (" + maxRow + ", " + maxColumn + ")");

        // Resource leak 방지를 위해 사용이 끝난 Scanner 객체 해제
        sc.close();
    }
}
