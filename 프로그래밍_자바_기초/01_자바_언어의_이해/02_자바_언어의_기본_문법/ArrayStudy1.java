import java.util.Scanner;

public class ArrayStudy1 {
    public static void main(String[] args) {
        // 10번 문제 (과제)
        // 9번 문제 (과제)
        // 8번 문제 (과제)

        /*
        // 7번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("학생 수: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            System.out.print((i + 1) + "번 학생 점수: ");
            int num = sc.nextInt();
            arr[i] = num;
        }
        int sum=0, min=arr[0], max=arr[0];
        for(int i=0;i<N;i++) {
            if(arr[i] < min) min = arr[i];
            if(arr[i] > max) max = arr[i];
            sum += arr[i];
        }
        double avg = (double) sum / N;
        System.out.println("합계: " + sum);
        System.out.println("평균: " + avg);
        System.out.println("최고점: " + max);
        System.out.println("최저점: " + min);
        */

        /*
        // 6번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            System.out.print((i + 1) + "번째 정수: ");
            int num = sc.nextInt();
            arr[i] = num;
        }
        int neg=0, pos=0, zero=0;
        for(int i=0;i<N;i++) {
            if(arr[i] > 0) pos++;
            else if(arr[i] == 0) zero++;
            else neg++;
        }
        System.out.println("양수: " + pos + "개");
        System.out.println("음수: " + neg + "개");
        System.out.println("0: " + zero + "개");
        */

        // 5번 문제 (과제)

        /*
        // 4번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력: ");
        int N = sc.nextInt();
        // 크기 N짜리 정수 배열 만들기
        int[] arr1 = new int[N];
        // N번 만큼 정수 입력 받기
        for(int i=0;i<N;i++) {
            System.out.print((i + 1) + "번째 정수: ");
            int num = sc.nextInt();
            arr1[i] = num;
        }
        System.out.print("M 입력: ");
        int M = sc.nextInt();
        // 크기 M짜리 정수 배열 만들기
        int[] arr2 = new int[M];
        for(int i=0;i<M;i++) {
            System.out.print((i + 1) + "번째 정수: ");
            int num = sc.nextInt();
            arr2[i] = num;
        }
        // 1) N + M 사이즈의 병합할 배열 만들기
        int[] merged = new int[N + M];

        // 2) 첫 번째 배열 복사 진행 (0번 인덱스 부터)
        for(int i=0;i<N;i++) merged[i] = arr1[i];

        // 3) 두 번째 배열 복사 진행 (N번 인덱스 부터)
        for(int i=N, j=0;i<(N+M);i++, j++) merged[i] = arr2[j];

        // 4) 병합된 배열 내용 출력
        for(int i=0;i<merged.length;i++) System.out.print(merged[i] + " ");
        */

        /*
        // 3번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력: ");
        int N = sc.nextInt();
        // 크기 N짜리 정수 배열 만들기
        int[] arr = new int[N];
        // N번 만큼 정수 입력 받기
        for(int i=0;i<N;i++) {
            System.out.print((i + 1) + "번째 정수: ");
            int num = sc.nextInt();
            arr[i] = num;
        }
        // 1) 똑같은 크기의 새 배열 만들기
        int[] copy = new int[N];

        // 2) 반복문 돌면서 기존 배열의 내용을 복사본 배열에 복사
        for(int i=0;i<arr.length;i++) copy[i] = arr[i];

        // 3) 원본 배열의 첫 번째 값을 999로 수정
        arr[0] = 999;

        // 4) 두 배열의 각 요소를 모두 출력
        System.out.print("원본 : ");
        for(int i=0;i<arr.length;i++) System.out.print(arr[i] + " ");
        System.out.print("\n복사본 : ");
        for(int i=0;i<copy.length;i++) System.out.print(copy[i] + " ");
        */

        /*
        // 2번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력: ");
        int N = sc.nextInt();
        // 크기 N짜리 정수 배열 만들기
        int[] arr = new int[N];
        // N번 만큼 정수 입력 받기
        for(int i=0;i<N;i++) {
            System.out.print((i + 1) + "번째 정수: ");
            int num = sc.nextInt();
            arr[i] = num;
        }
        // 찾을 값 입력
        System.out.print("찾을 값: ");
        int target = sc.nextInt();
        int count = 0;
        // 돌면서 찾아서, 찾으면 인덱스 출력
        for(int i=0;i<N;i++) {
            if(arr[i] == target) {
                System.out.println("인덱스 " + i);
                count++;
            }
        }
        // 못 찾은 케이스만 출력
        if(count == 0) System.out.println("찾을 수 없습니다.");
        */

        /*
        // 1번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력: ");
        int N = sc.nextInt();
        // 크기 N짜리 정수 배열 만들기
        int[] arr = new int[N];
        // N번 만큼 정수 입력 받기
        for(int i=1;i<=N;i++) {
            System.out.print(i + "번째 정수: ");
            int num = sc.nextInt();
            arr[i - 1] = num;
        }
        // 역순으로 출력
        for(int i=N-1;i>=0;i--) {
            System.out.print(arr[i] + " ");
        }
        */
    }
}
