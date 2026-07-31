import java.util.Scanner;

/**
 * [프로그래밍 자바 기초] - 자바 프로그래밍 수행평가
 *
 * 문제명: 극장 좌석 예약 시스템 (Seat_1203.java)
 *
 * 문제 조건 및 학습 목표:
 * 1. [조건 1] 좌석 크기 N을 입력받아 N×N 크기의 2차원 배열 생성
 * 2. [조건 2] 예약, 취소, 현황, 종료 메뉴를 반복하여 출력
 * 3. [조건 3] 행 번호와 열 번호를 입력받아 좌석의 예약 및 취소 처리
 * 4. [조건 4, 5] 맨 앞의 빈 좌석은 R, 나머지 빈 좌석은 O, 예약 좌석은 X로 출력
 * 5. [조건 6] 이미 예약된 좌석을 다시 예약하면 오류 메시지 출력
 * 6. [조건 7] 현재 좌석의 예약 상태와 빈자리 및 예약 자리 개수 출력
 * 7. [조건 8] 종료 메뉴 선택 시 종료 메시지를 출력하고 프로그램 종료
 * 8. Scanner, 2차원 배열, 중첩 반복문과 조건문 사용 방법 학습
 *
 * 작성자: 미림마이스터고등학교 뉴미디어소프트웨어과 1203 권율
 */
public class Seat_1203 {
    public static void main(String[] args) {
        // 1. 키보드로 좌석 크기와 메뉴 번호를 입력받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 2. [조건 1] 사용자에게 좌석 크기 N을 입력받음
        System.out.print("좌석 크기 : ");
        int n = sc.nextInt();

        // 3. [조건 1] 입력받은 N을 이용하여 N×N 크기의 2차원 좌석 배열 생성
        // - int 배열의 초깃값인 0은 빈 좌석, 1은 예약된 좌석을 의미함
        int[][] seats = new int[n][n];

        // 메뉴 선택 값을 저장할 변수
        // - 0은 프로그램을 처음 실행했을 때 현황판을 출력하기 위해 사용
        int menu = 0;

        // 4. [조건 2, 8] 사용자가 4번 종료 메뉴를 선택하기 전까지 반복
        while (menu != 4) {
            // 현재 빈 좌석과 예약된 좌석의 개수를 저장할 변수
            int emptyCount = 0;
            int reservedCount = 0;

            // 5. [조건 7] 처음 실행하거나 3번 현황 메뉴를 선택하면 좌석 현황 출력
            if (menu == 0 || menu == 3) {
                System.out.println("=== 극장 좌석 예약 시스템 ===");

                // 6. 중첩 반복문으로 2차원 좌석 배열의 모든 칸을 순서대로 확인
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        // [조건 5] 배열 값이 1이면 예약된 좌석이므로 X로 출력
                        if (seats[i][j] == 1) {
                            System.out.print("[ X ]");
                            reservedCount++;
                        // [조건 4] 첫 번째 행에 있는 빈 좌석은 R로 출력
                        } else if (i == 0) {
                            System.out.print("[ R ]");
                            emptyCount++;
                        // [조건 5] 첫 번째 행이 아닌 빈 좌석은 O로 출력
                        } else {
                            System.out.print("[ O ]");
                            emptyCount++;
                        }
                    }
                    System.out.println();
                }

                // 7. [조건 7] 빈 좌석과 예약된 좌석의 개수 출력
                System.out.println("빈 자리 : " + emptyCount + "개 | 예약된 자리 : " + reservedCount + "개");
            }

            // 8. [조건 2] 사용자에게 메뉴를 출력하고 선택 번호를 입력받음
            System.out.print("1.예약 2.취소 3.현황 4.종료 : ");
            menu = sc.nextInt();

            // 9. [조건 3] 1번 예약 메뉴를 선택한 경우
            if (menu == 1) {
                // 예약할 좌석의 행 번호와 열 번호를 각각 입력받음
                System.out.print("예약할 행 번호 : ");
                int row = sc.nextInt();
                System.out.print("예약할 열 번호 : ");
                int column = sc.nextInt();

                // 배열의 위치는 0부터 시작하므로 입력받은 번호에서 1을 뺌
                // 10. [조건 6] 배열 값이 이미 1이면 예약 오류 메시지 출력
                if (seats[row - 1][column - 1] == 1) {
                    System.out.println("[오류] 이미 예약된 좌석입니다.");
                } else {
                    // 빈 좌석의 배열 값을 1로 변경하여 예약 상태로 만듦
                    seats[row - 1][column - 1] = 1;
                    System.out.println(row + "행 " + column + "열 좌석 예약 완료!");
                }
            } else if (menu == 2) {
                // 11. [조건 3] 2번 취소 메뉴를 선택한 경우
                // 취소할 좌석의 행 번호와 열 번호를 각각 입력받음
                System.out.print("취소할 행 번호 : ");
                int row = sc.nextInt();
                System.out.print("취소할 열 번호 : ");
                int column = sc.nextInt();

                // 예약된 좌석의 배열 값을 0으로 변경하여 빈 좌석으로 만듦
                seats[row - 1][column - 1] = 0;
                System.out.println(row + "행 " + column + "열 좌석 취소 완료!");
            } else if (menu == 4) {
                // 12. [조건 8] 4번 종료 메뉴를 선택하면 종료 메시지 출력
                System.out.println("프로그램을 종료합니다.");
            }
        }

        // Resource leak 방지를 위해 사용이 끝난 Scanner 객체 해제
        sc.close();
    }
}
