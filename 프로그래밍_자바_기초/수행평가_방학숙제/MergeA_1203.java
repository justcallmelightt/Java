/**
 * [프로그래밍 자바 기초] - 자바 프로그래밍 수행평가
 *
 * 문제명: 두 배열 병합, 오름차순 정렬 및 중복 제거 (MergeA_1203.java)
 *
 * 문제 조건 및 학습 목표:
 * 1. [조건 1] 크기가 5인 두 개의 정수 배열과 크기가 10인 병합 배열 생성
 * 2. [조건 2] 두 배열에 각각 5개의 정수를 입력받아 저장
 * 3. [조건 3] 두 배열의 데이터를 출력하면서 하나의 배열로 병합
 * 4. [조건 4] 중첩 반복문과 값 교환을 이용하여 병합 배열을 오름차순 정렬
 * 5. [조건 5] 정렬된 전체 데이터를 출력하고, 연속된 값을 비교하여 중복 제거
 * 6. 배열, 반복문, 조건문, 버블 정렬 및 중복 제거 원리 학습
 *
 * 작성자: 미림마이스터고등학교 뉴미디어소프트웨어과 1203 권율
 */

import java.util.Scanner;

public class MergeA_1203 {
    public static void main(String[] args) {
        // 키보드로 정수를 입력받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 1. [조건 1] 입력 데이터를 저장할 두 배열과 병합 결과를 저장할 배열 생성
        // - array1과 array2에는 각각 5개, merged에는 두 배열을 합친 10개의 정수가 저장된다.
        int[] array1 = new int[5];
        int[] array2 = new int[5];
        int[] merged = new int[10];

        // 2. [조건 2] 첫 번째 배열에 5개의 정수를 입력받아 저장
        // - i는 0부터 4까지 증가하며 배열의 각 인덱스를 차례대로 가리킨다.
        for (int i = 0; i < 5; i++) {
            System.out.print("배열1의 " + i + "번째 입력 : ");
            array1[i] = sc.nextInt();
        }

        // 3. [조건 2] 두 번째 배열에 5개의 정수를 입력받아 저장
        for (int i = 0; i < 5; i++) {
            System.out.print("배열2의 " + i + "번째 입력 : ");
            array2[i] = sc.nextInt();
        }

        // 4. [조건 3] 첫 번째 배열의 데이터를 출력하고 merged의 0~4번 위치에 복사
        System.out.print("배열1 데이터 : ");
        for (int i = 0; i < 5; i++) {
            System.out.print(array1[i] + " ");
            merged[i] = array1[i]; // 같은 인덱스 위치에 첫 번째 배열의 값 저장
        }
        System.out.println();

        // 5. [조건 3] 두 번째 배열의 데이터를 출력하고 merged의 5~9번 위치에 복사
        System.out.print("배열2 데이터 : ");
        for (int i = 0; i < 5; i++) {
            System.out.print(array2[i] + " ");
            merged[i + 5] = array2[i]; // i에 5를 더하여 병합 배열의 뒷부분에 저장
        }
        System.out.println();

        // 6. [조건 4] 버블 정렬을 사용하여 병합 배열을 오름차순으로 정렬
        // - 바깥쪽 반복문이 한 번 실행될 때마다 가장 큰 값이 배열의 뒤쪽에 확정된다.
        for (int i = 0; i < merged.length - 1; i++) {
            // 이미 정렬이 끝난 뒤쪽 i개 요소는 비교 대상에서 제외한다.
            for (int j = 0; j < merged.length - 1 - i; j++) {
                // 앞의 값이 뒤의 값보다 크면 두 값의 위치를 서로 교환한다.
                if (merged[j] > merged[j + 1]) {
                    // 값을 잃어버리지 않고 교환하기 위해 임시 변수 temp를 사용한다.
                    int temp = merged[j];
                    merged[j] = merged[j + 1];
                    merged[j + 1] = temp;
                }
            }
        }

        // 7. [조건 5] 오름차순으로 정렬된 병합 배열의 전체 데이터 출력
        System.out.print("전체 데이터 (오름차순) : ");
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i] + " ");
        }
        System.out.println();

        // 8. [조건 5] 정렬된 배열에서 중복된 값을 제외하고 출력
        // - 첫 번째 값은 앞에서 비교할 값이 없으므로 반복문 전에 먼저 출력한다.
        System.out.print("중복 제거된 데이터 : ");
        System.out.print(merged[0] + " ");

        // 두 번째 요소부터 바로 앞 요소와 비교하여 값이 다를 때만 출력한다.
        // 배열이 정렬되어 있으므로 같은 값들은 서로 연속된 위치에 모여 있다.
        for (int i = 1; i < merged.length; i++) {
            if (merged[i] != merged[i - 1]) {
                System.out.print(merged[i] + " ");
            }
        }

        // Resource leak 방지를 위해 사용이 끝난 Scanner 객체 해제
        sc.close();
    }
}
