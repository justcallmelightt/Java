/**
 * [프로그래밍 자바 기초] - 자바 프로그래밍 2차 수행평가 (06/24 A형 1번)
 * 
 * 문제명: 최솟값 제외 평균 계산 (MinExclude_학번.java)
 * 
 * 문제 조건 및 학습 목표:
 * 1. [조건 1] 정수 N(N >= 2)을 입력받아 N개의 실수(double) 점수를 배열에 저장
 * 2. [조건 2] 입력된 전체 점수 출력
 * 3. [조건 3] 배열 순회를 통한 최솟값(min) 탐색 및 출력
 * 4. [조건 4] 최솟값을 제외한 나머지 점수의 합계 및 평균(소수점 둘째 자리) 출력
 * 5. [조건 5] 최솟값이 중복(여러 개)일 경우, 1개만 제외하고 계산 (sum - min)
 * 
 * 작성자: 미림마이스터고등학교 뉴미디어소프트웨어과 1203 권율
 */

import java.util.Scanner;

public class MinExclude_1203 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. [조건 1] 입력 데이터 개수(N) 지정 및 double 배열 동적 할당
        System.out.print("점수 개수 : ");
        int n = sc.nextInt();
        double[] scores = new double[n]; // 입력받은 n 크기만큼 double 배열 생성

        // 2. [조건 1] N개의 실수 점수 입력 및 배열 저장
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i + 1) + "번째 점수 : ");
            scores[i] = sc.nextDouble();
        }

        // 3. [조건 2] 입력받은 전체 점수 출력 (배열 순회)
        System.out.print("입력 점수 : ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();

        // 4. [조건 3] 최솟값 탐색 및 누적 합계 계산
        // - min 변수는 배열의 첫 번째 요소(scores[0])로 초기화하여 비교 기준점 설정
        double min = scores[0];
        double sum = 0.0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i]; // 전체 누적 합계 계산

            // 현재 요소가 기존 min보다 작으면 최솟값 갱신
            if (scores[i] < min) {
                min = scores[i];
            }
        }

        System.out.println("제거된 최솟값 : " + min);

        // 5. [조건 4 & 5] 최솟값 제외 합계 및 평균 계산
        // - 전체 합(sum)에서 최솟값(min)을 1번만 차감하므로 중복 최솟값이 있어도 1개만 제외됨
        // - 최솟값 1개를 제외했으므로 평균의 분모는 (n - 1) 적용
        double sumWithoutMin = sum - min;
        double averageWithoutMin = sumWithoutMin / (n - 1);

        // 6. [조건 4] 결과 출력 (%.2f 포맷팅으로 소수점 둘째 자리까지 표시)
        System.out.println("최솟값 제외 합계 : " + sumWithoutMin);
        System.out.printf("최솟값 제외 평균 : %.2f%n", averageWithoutMin);

        // Resource leak 방지를 위해 Scanner 객체 해제
        sc.close();
    }
}
