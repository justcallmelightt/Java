import java.util.Scanner;

/**
 * [프로그래밍 자바 기초] - 자바 프로그래밍 수행평가
 *
 * 문제명: 바둑판 흑백돌 놓기 (메뉴 방식) (GoStone_1203.java)
 *
 * 문제 조건 및 학습 목표:
 * 1. [조건 1] 바둑판 크기 N을 입력받아 N×N 크기의 2차원 배열 생성
 * 2. [조건 2] 백돌, 흑돌, 현황, 종료 메뉴를 반복해서 출력
 * 3. [조건 3] 행과 열 번호를 입력받아 백돌 또는 흑돌 배치
 * 4. [조건 4, 5] 빈자리는 ., 백돌은 W, 흑돌은 B로 출력
 * 5. [조건 6] 이미 돌이 놓인 자리에는 새로운 돌을 놓지 않음
 * 6. [조건 7] 현재 바둑판과 백돌·흑돌의 개수를 출력
 * 7. [조건 8] 종료 메뉴를 선택하면 반복문을 종료
 * 8. Scanner, 2차원 배열, 반복문과 조건문 사용 방법 학습
 *
 * 작성자: 미림마이스터고등학교 뉴미디어소프트웨어과 1203 권율
 */
public class GoStone_1203 {
    public static void main(String[] args) {
        // 1. 키보드 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 2. [조건 1] 바둑판의 크기 N을 입력받음
        System.out.print("바둑판 크기 : ");
        int n = sc.nextInt();

        // 3. 입력받은 N을 이용하여 N×N 크기의 2차원 배열 생성
        char[][] board = new char[n][n];

        // 4. 바둑판의 모든 칸을 빈자리를 뜻하는 .으로 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // 5. 현재 놓인 백돌과 흑돌의 개수를 저장할 변수
        int whiteCount = 0;
        int blackCount = 0;

        // 6. 프로그램을 시작할 때 초기 바둑판을 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        // 7. [조건 2] 종료 메뉴를 선택할 때까지 메뉴를 반복
        while (true) {
            System.out.print("1.백돌 2.흑돌 3.현황 4.종료 : ");
            int menu = sc.nextInt();

            // 8. [조건 3] 백돌 또는 흑돌 메뉴를 선택한 경우
            if (menu == 1 || menu == 2) {
                int row;
                int column;

                // 선택한 돌의 종류에 맞는 행과 열 번호를 입력받음
                if (menu == 1) {
                    System.out.print("백돌 놓을 행 번호 : ");
                    row = sc.nextInt();
                    System.out.print("백돌 놓을 열 번호 : ");
                    column = sc.nextInt();
                } else {
                    System.out.print("흑돌 놓을 행 번호 : ");
                    row = sc.nextInt();
                    System.out.print("흑돌 놓을 열 번호 : ");
                    column = sc.nextInt();
                }

                // 사용자는 1번부터 입력하므로 배열에서 사용할 수 있도록 1을 뺌
                int rowIndex = row - 1;
                int columnIndex = column - 1;

                // 9. [조건 6] 선택한 자리에 돌이 있으면 오류 메시지 출력
                if (board[rowIndex][columnIndex] != '.') {
                    System.out.println("[오류] 이미 돌이 놓인 자리입니다.");
                } else {
                    // 10. 빈자리이면 선택한 종류의 돌을 놓고 개수를 1 증가
                    if (menu == 1) {
                        board[rowIndex][columnIndex] = 'W';
                        whiteCount++;
                        System.out.println(row + "행 " + column + "열에 백돌(W) 배치 완료!");
                    } else {
                        board[rowIndex][columnIndex] = 'B';
                        blackCount++;
                        System.out.println(row + "행 " + column + "열에 흑돌(B) 배치 완료!");
                    }
                }
            } else if (menu == 3) {
                // 11. [조건 7] 현재 바둑판의 모든 칸을 행 단위로 출력
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(board[i][j] + " ");
                    }
                    System.out.println();
                }

                // 현재까지 놓인 백돌과 흑돌의 개수 출력
                System.out.println("백돌 : " + whiteCount + "개 흑돌 : " + blackCount + "개");
            } else if (menu == 4) {
                // 12. [조건 8] 종료 메시지를 출력하고 반복문 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }

        // Resource leak 방지를 위해 사용이 끝난 Scanner 객체 해제
        sc.close();
    }
}
