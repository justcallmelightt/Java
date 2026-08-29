// Array2DPatternDemo.java
// 주제: 2차원 배열 중첩 for문 패턴, 정렬 출력, 가변 배열

public class Array2DPatternDemo {
    public static void main(String[] args) {

        // ================================================================
        // 1. 중첩 for문으로 채우기 + 출력 (기본 패턴)
        // ================================================================
        int[][] arr = new int[3][4];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ++cnt;
            }
        }

        // printf("%3d")로 우측 정렬 출력
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }
        // 출력:
        //   1  2  3  4
        //   5  6  7  8
        //   9 10 11 12


        // ================================================================
        // 2. 가변 배열 생성 패턴
        // ================================================================
        // i행에 (i+1)개의 열을 할당 → 삼각형 모양
        int[][] jagged = new int[5][];
        cnt = 0;

        for (int i = 0; i < jagged.length; i++) {
            jagged[i] = new int[i + 1]; // 행마다 열 수가 다름
        }

        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                jagged[i][j] = ++cnt;
            }
        }

        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.printf("%3d", jagged[i][j]);
            }
            System.out.println();
        }
        // 출력:
        //   1
        //   2  3
        //   4  5  6
        //   7  8  9 10
        //  11 12 13 14 15


        // ================================================================
        // 3. for-each로 2차원 배열 순회
        // ================================================================
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};

        for (int[] row : matrix) {       // row는 각 행 배열의 참조
            for (int val : row) {
                System.out.printf("%3d", val);
            }
            System.out.println();
        }

        // for-each에서 행 교체는 반영되지 않는다 (참조 복사이므로)
        for (int[] row : matrix) {
            row = new int[]{0, 0, 0}; // matrix 자체는 바뀌지 않음
        }
        System.out.println("matrix[0][0] = " + matrix[0][0]); // 여전히 1

        // 단, 행 내부 요소 변경은 반영됨 (같은 배열 객체를 참조하므로)
        for (int[] row : matrix) {
            row[0] = 999; // 실제 배열 요소가 바뀜
        }
        System.out.println("matrix[0][0] = " + matrix[0][0]); // 999
        System.out.println("matrix[1][0] = " + matrix[1][0]); // 999


        // ================================================================
        // [심화] 행 배열 자체를 교체하면 해당 행의 열 수도 바뀐다
        // ================================================================
        int[][] flex = new int[2][3]; // 2행 3열
        System.out.println("flex[0].length = " + flex[0].length); // 3

        flex[0] = new int[]{10, 20}; // 0행을 길이 2짜리로 교체
        System.out.println("flex[0].length = " + flex[0].length); // 2

        // 열 수를 flex[0].length 고정으로 쓰면 이런 케이스에서 논리 버그 발생
        // 항상 arr[i].length를 기준으로 순회해야 안전
    }
}
