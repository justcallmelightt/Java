// ArrayIterationDemo.java
// 주제: 배열 순회, 에러 케이스, 참조 대입, 동적 할당

import java.util.Scanner;

public class ArrayIterationDemo {
    public static void main(String[] args) {

        // ================================================================
        // 1. for문으로 배열 순회
        // ================================================================
        int[] arr = new int[]{10, 20, 30, 40};

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }


        // ================================================================
        // 2. 자주 하는 컴파일 에러 3가지
        // ================================================================

        // 에러 1: 초기화할 때 길이를 명시하면 안 된다
        // int[] e1 = new int[3]{10, 20, 30}; // 컴파일 에러

        // 에러 2: 초기화 없이 new int[]만 쓰면 길이가 없어서 에러
        // int[] e2 = new int[];              // 컴파일 에러

        // 에러 3: 배열을 일반 변수에 대입할 수 없다 (타입 불일치)
        // int e3 = new int[3];               // 컴파일 에러: int[] → int 불가


        // ================================================================
        // 3. ArrayIndexOutOfBoundsException (런타임 에러)
        // ================================================================
        int[] data = {10, 20, 30, 40, 50}; // 인덱스 0~4 유효
        // System.out.println(data[5]);      // 런타임 에러: Index 5 out of bounds for length 5

        // 흔한 실수: i <= data.length 로 쓰는 경우
        // for (int i = 0; i <= data.length; i++) { // <= 이면 마지막에 에러 발생
        //     System.out.println(data[i]);
        // }


        // ================================================================
        // 4. 향상된 for문 (for-each)
        // ================================================================
        // 인덱스가 필요 없을 때 간결하게 사용
        int[] nums = {10, 20, 30, 40, 50};
        for (int n : nums) {
            System.out.print(n + "\t");
        }
        System.out.println();

        // for-each의 한계: 요소값 변경이 배열에 반영되지 않는다
        for (int n : nums) {
            n = 0; // 지역변수 n만 바뀔 뿐, nums 배열은 그대로
        }
        System.out.println("nums[0] = " + nums[0]); // 여전히 10

        // 값을 바꾸려면 일반 for문 사용
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 0; // 실제 배열 요소가 변경됨
        }
        System.out.println("nums[0] 변경 후 = " + nums[0]); // 0


        // ================================================================
        // 5. String 배열 (참조형 배열)
        // ================================================================
        // String도 참조형 → 배열의 각 칸에는 문자열 객체의 주소가 저장됨
        String[] str = new String[3];
        str[0] = "Happy";
        str[1] = "Meister";
        str[2] = "School";

        for (int i = 0; i < str.length; i++) {
            System.out.println("str[" + i + "] = " + str[i]);
        }

        // new String[3] 직후 초기값은 null (0이나 false가 아님에 주의)
        String[] empty = new String[3];
        System.out.println("empty[0] = " + empty[0]); // null


        // ================================================================
        // 6. 배열 참조 대입 - 같은 배열을 가리키게 된다
        // ================================================================
        int[] b = new int[]{21, 22, 23, 24};
        int[] c = {31, 32, 33};

        System.out.println("대입 전 c.length = " + c.length); // 3

        c = b; // c가 b와 같은 배열을 가리키게 됨 (기존 {31,32,33} 객체는 참조 없어짐)

        System.out.println("대입 후 c.length = " + c.length); // 4 (b와 동일)

        // b와 c는 이제 완전히 같은 배열 → 한쪽을 바꾸면 양쪽에 반영
        b[0] = 999;
        System.out.println("c[0] = " + c[0]); // 999


        // ================================================================
        // 7. 동적 크기 배열 (런타임에 크기 결정)
        // ================================================================
        Scanner scan = new Scanner(System.in);
        System.out.print("배열의 크기 입력: ");
        int size = scan.nextInt();
        int[] dynamicArray = new int[size]; // 변수로 크기 지정 가능
        System.out.println("생성된 배열의 크기: " + dynamicArray.length);
        scan.close();
    }
}
