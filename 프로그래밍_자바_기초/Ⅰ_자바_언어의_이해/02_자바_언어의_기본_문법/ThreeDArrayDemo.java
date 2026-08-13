public class ThreeDArrayDemo {
    public static void main(String[] args) {
        int[][][] array3D = new int[2][2][3];
        for (int i = 0; i < array3D.length; i++) {              // array3D.length = 2 (면의 개수)
            for (int j = 0; j < array3D[i].length; j++) {          // array3D[i].length = 2 (해당 면의 행 개수)
                for (int k = 0; k < array3D[i][j].length; k++) {   // array3D[i][j].length = 3 (해당 행의 열 개수)
                    
                    // 각 위치마다 직관적으로 구별 가능한 규칙적인 숫자 생성 및 대입
                    // 예: 1번째 면(i=0), 1번째 행(j=0), 1번째 열(k=0) -> 111 대입
                    array3D[i][j][k] = (i + 1) * 100 + (j + 1) * 10 + (k + 1);
                }
            }
        }
        for (int i = 0; i < array3D.length; i++) {
            // 현재 접근 중인 면의 정보 출력
            System.out.println("--- " + (i + 1) + "번째 면 (Layer " + i + ") ---");
            
            for (int j = 0; j < array3D[i].length; j++) {
                for (int k = 0; k < array3D[i][j].length; k++) {
                    // 값을 구분할 수 있게 공백 문자를 더하여 출력
                    System.out.print(array3D[i][j][k] + " ");
                }
                System.out.println(); // 한 행의 출력이 끝나면 줄 바꿈
            }
            System.out.println(); // 한 면의 출력이 끝나면 면 사이에 빈 줄 추가
        }
    }
}
