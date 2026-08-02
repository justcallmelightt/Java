    import java.util.Scanner;

    /**
     * [프로그래밍 자바 기초] - 자바 프로그래밍 수행평가
     *
     * 문제명: 두 배열 내림차순 출력·중복 제거 (MergeD_1203.java)
     *
     * 문제 조건 및 학습 목표:
     * 1. [조건 1] 크기가 5인 두 배열에 양수 데이터를 각각 입력받아 저장
     * 2. [조건 2] 두 배열의 모든 데이터를 큰 숫자부터 내림차순으로 출력
     * 3. [조건 3] 중복된 데이터는 한 번만 출력
     * 4. [조건 4] sort 메소드를 사용하지 않고 중첩 반복문으로 직접 정렬
     * 5. Scanner, 배열, 중첩 반복문, 조건문과 값 교환 방법 학습
     *
     * 작성자: 미림마이스터고등학교 뉴미디어소프트웨어과 1203 권율
     */
    public class MergeD_1203 {
        public static void main(String[] args) {
            // 1. 키보드 입력을 받기 위한 Scanner 객체 생성
            Scanner sc = new Scanner(System.in);

            // 2. [조건 1] 크기가 5인 두 배열과 전체 데이터를 저장할 배열 생성
            int[] array1 = new int[5];
            int[] array2 = new int[5];
            int[] all = new int[10];

            // 3. 첫 번째 배열에 5개의 양수 데이터 입력
            for (int i = 0; i < array1.length; i++) {
                System.out.print("배열1의 " + i + "번방 입력 : ");
                array1[i] = sc.nextInt();
            }

            // 4. 두 번째 배열에 5개의 양수 데이터 입력
            for (int i = 0; i < array2.length; i++) {
                System.out.print("배열2의 " + i + "번방 입력 : ");
                array2[i] = sc.nextInt();
            }

            // 5. 첫 번째 배열을 입력받은 순서대로 출력
            // - 출력과 동시에 전체 데이터 배열의 앞쪽에 복사
            System.out.print("배열1 데이터 : ");
            for (int i = 0; i < array1.length; i++) {
                System.out.print(array1[i] + " ");
                all[i] = array1[i];
            }
            System.out.println();

            // 6. 두 번째 배열을 입력받은 순서대로 출력
            // - 출력과 동시에 전체 데이터 배열의 뒤쪽에 복사
            System.out.print("배열2 데이터 : ");
            for (int i = 0; i < array2.length; i++) {
                System.out.print(array2[i] + " ");
                all[i + 5] = array2[i];
            }
            System.out.println();

            // 7. [조건 2, 4] sort 메소드 없이 전체 데이터를 내림차순으로 정렬
            // - 앞의 값보다 뒤의 값이 크면 두 값을 서로 교환
            for (int i = 0; i < all.length - 1; i++) {
                for (int j = i + 1; j < all.length; j++) {
                    if (all[i] < all[j]) {
                        // temp 변수를 이용하여 두 배열 요소의 값을 교환
                        int temp = all[i];
                        all[i] = all[j];
                        all[j] = temp;
                    }
                }
            }

            // 8. 중복을 포함한 전체 데이터를 내림차순으로 출력
            System.out.print("전체 데이터 (내림차순) : ");
            for (int i = 0; i < all.length; i++) {
                System.out.print(all[i] + " ");
            }
            System.out.println();

            // 9. [조건 3] 첫 번째 데이터는 비교 대상이 없으므로 먼저 출력
            System.out.print("중복 제거된 데이터 : ");
            System.out.print(all[0] + " ");

            // 10. 현재 값이 바로 앞의 값과 다를 때만 출력
            // - 배열이 정렬되어 있으므로 같은 값들은 서로 붙어 있음
            for (int i = 1; i < all.length; i++) {
                if (all[i] != all[i - 1]) {
                    System.out.print(all[i] + " ");
                }
            }
            System.out.println();

            // Resource leak 방지를 위해 사용이 끝난 Scanner 객체 해제
            sc.close();
        }
    }
