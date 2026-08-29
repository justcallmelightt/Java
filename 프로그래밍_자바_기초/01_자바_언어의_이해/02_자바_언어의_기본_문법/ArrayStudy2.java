import java.util.Arrays;
import java.util.Scanner;

public class ArrayStudy2 {
    public static void main(String[] args) {
        /*
        // 20번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력: ");
        int N = sc.nextInt();
        int[][] nums = new int[N][N];
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<nums[i].length;j++) {
                System.out.print((i + 1) + "행 " + (j + 1) + " 열 : ");
                int num = sc.nextInt();
                nums[i][j] = num;
            }
        }
        // System.out.println(Arrays.deepToString(nums));
        // 주대각선 요소의 합
        int sum1 = 0;
        // 반대각선 요소의 합
        int sum2 = 0;
        for(int i=0;i<nums.length;i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if(i == j) {
                    // 주대각선이니까
                    sum1 += nums[i][j];
                }
                if(i + j == N - 1) {
                    // 반대각선이니까
                    sum2 += nums[i][j];
                }
            }
        }
        System.out.println("주 대각선 합 : " + sum1);
        System.out.println("반 대각선 합 : " + sum2);
        */

        /*
        // 19번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력: ");
        int N = sc.nextInt();
        int[] counts = new int[10];
        for(int i=0;i<N;i++) {
            System.out.print((i + 1) + "번째 정수: ");
            int num = sc.nextInt();
            // counts[num]++;
            counts[num] = counts[num] + 1;
        }
        // System.out.println(Arrays.toString(counts));
        int max = 0;
        for(int i=0;i<10;i++) {
            if(counts[i] != 0) {
                System.out.println(i + " : " + counts[i] + "번");
                if(counts[i] > max) {
                    // 최빈값의 개수를 갱신
                    max = counts[i];
                }
            }
        }
        System.out.print("최빈값: ");
        for(int i=0;i<10;i++) {
            if(counts[i] == max) {
                System.out.print(i + " ");
            }
        }
        */

        /*
        // 18번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("문제 수: ");
        int N = sc.nextInt();
        int[] marks = new int[N];
        for(int i=0;i<N;i++) {
            System.out.print("정답 입력(1 => O, 0 => X): ");
            int ox = sc.nextInt();
            marks[i] = ox;
        }
        System.out.println();
        int[] answers = new int[N];
        for(int i=0;i<N;i++) {
            System.out.print("답안 입력(1 => O, 0 => X): ");
            int ox = sc.nextInt();
            answers[i] = ox;
        }
//        System.out.println(Arrays.toString(marks));
//        System.out.println(Arrays.toString(answers));
        int score = 0;
        int currentStreak = 0;
        int totalStreak = 0;
        for(int i=0;i<N;i++) {
            if(marks[i] == answers[i]) {
                score++;
                currentStreak++;
            } else {
                totalStreak += (currentStreak - 1);
                currentStreak = 0;
            }
        }
        if(currentStreak != 0) totalStreak += (currentStreak - 1);
        System.out.println("기본 점수: " + score);
        System.out.println("가산 점수: " + totalStreak);
        System.out.println("최종 점수: " + (score + totalStreak));
        */

//        // 17번 문제
//        Scanner sc = new Scanner(System.in);
//        System.out.print("행(N): ");
//        int N = sc.nextInt();
//        System.out.print("열(M): ");
//        int M = sc.nextInt();
//        // N x M 행렬 생성
//        int[][] nums = new int[N][M];
//        for(int i=0;i<nums.length;i++) {
//            for(int j=0;j<nums[i].length;j++) {
//                System.out.print((i + 1) + "행 " + (j + 1) + " 열 : ");
//                int num = sc.nextInt();
//                nums[i][j] = num;
//            }
//        }
////        // 행별 합계 출력
////        /*
////        for(int i=0;i<N;i++) {
////            int sum = 0;
////            for(int j=0;j<M;j++) {
////                sum += nums[i][j];
////            }
////            System.out.println((i + 1) + "행 합계 : " + sum);
////        }
////        */
////
////        /*
////        for(int i=0;i<M;i++) { // 열(M) 만큼 (행 만큼 아님 주의!)
////            int sum = 0;
////            for(int j=0;j<N;j++) { // 행(N) 만큼
////                sum += nums[j][i]; // 인덱스 [i][j]가 아니라 [j][i]인거 주의!
////            }
////            System.out.println((i + 1) + "열 합계 : " + sum);
////        }
////        */

        /*
        // 15번 문제
        Scanner sc = new Scanner(System.in);
        int[][] nums = new int[3][3];
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<nums[i].length;j++) {
                System.out.print((i + 1) + "행 " + (j + 1) + " 열 : ");
                int num = sc.nextInt();
                nums[i][j] = num;
            }
        }
        System.out.println(Arrays.deepToString(nums));
        // 전체 합계 더하기
        int sum = 0;
        // 이중 for문 작성
        */

        /*
        // 14번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("학생 수: ");
        int N = sc.nextInt();
        int[][] scores = new int[N][];
        for(int i=0;i<N;i++) {
            scores[i] = new int[3];
            // 반복문 돌면서 0, 1, 2 번에 국, 영, 수 점수 넣기
            String[] subjects = new String[]{"국어", "영어", "수학"};
            System.out.println((i + 1) + "번째 학생");
            for(int j=0;j<3;j++) {
                System.out.print(subjects[j] + " 과목 점수 입력: ");
                int score = sc.nextInt();
                scores[i][j] = score;
            }
        }
        // System.out.println(Arrays.toString(scores));
        // System.out.println(Arrays.deepToString(scores));
        for(int i=0;i<N;i++) {
            int sum = 0;
            for(int j=0;j<3;j++) {
                sum += scores[i][j];
            }
            double avg = (double) sum / 3;
            System.out.println((i + 1) + "번 학생: 평균 " + avg + " 점 -> "
                    + (avg > 60 ? "합격" : "불합격"));
        }
        */

        /*
        // 13번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            System.out.print((i + 1) + "번째 정수: ");
            int num = sc.nextInt();
            arr[i] = num;
        }
        int i = 0;
        int j = N - 1;
        boolean isSymmetric = true;
        for( ; j > i ; i++, j-- ) {
            if(arr[i] != arr[j]) {
                isSymmetric = false;
                break;
            }
        }
        System.out.println(isSymmetric ? "대칭입니다." : "대칭이 아닙니다.");
        */

        /*
        // 12번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            System.out.print((i + 1) + "번째 정수: ");
            int num = sc.nextInt();
            arr[i] = num;
        }
        int[] result = new int[N];
        int count = 0;
        for(int i=0;i<N;i++) {
            boolean foundDuplication = false;
            for(int j=0;j<count;j++) {
                if(arr[i] == result[j]) {
                    foundDuplication = true;
                    break;
                }
            }
            if(!foundDuplication) {
                result[count++] = arr[i];
//                result[count] = arr[i];
//                count++;
            }
        }
        // System.out.println(Arrays.toString(result));
        for(int i=0;i<count;i++) {
            System.out.print(result[i] + " ");
        }
        */

        /*
        // 11번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("상품 수: ");
        int N = sc.nextInt();
        int[] stocks = new int[N];
        for(int i=0;i<N;i++) {
            System.out.print((i + 1) + "번 상품 재고: ");
            int num = sc.nextInt();
            stocks[i] = num;
        }
        int sum = 0;
        for(int i=0;i<N;i++) {
            if(stocks[i] == 0) System.out.println("품절");
            else if(stocks[i] <= 5) System.out.println("재고 부족 (" + stocks[i] + "개)");
            else System.out.println(stocks[i] + "개");
            sum += stocks[i];
        }
        System.out.println("전체 재고: " + sum + "개");
        */
    }
}
