# 1차원 배열 - 선언, 생성, 초기화, 요소 접근, length

- 원문: http://yubs.online/java/(1%ED%95%99%EA%B8%B0)_%EA%B8%B0%EC%B4%88/01_%EC%9E%90%EB%B0%94-%EC%96%B8%EC%96%B4%EC%9D%98-%EC%9D%B4%ED%95%B4/02_%EC%9E%90%EB%B0%94-%EC%96%B8%EC%96%B4%EC%9D%98-%EA%B8%B0%EB%B3%B8-%EB%AC%B8%EB%B2%95-04)-%EB%B0%B0%EC%97%B4.html
- 용도: yubs.online 수업 페이지의 코드 블록을 원문 순서대로 보존한 학습 자료입니다.
- 실행 가능한 예제는 같은 단원의 Java 파일을 우선 참고하세요.

## 코드 블록 1

```text
// ArrayBasicsDemo.java
// 주제: 1차원 배열 - 선언, 생성, 초기화, 요소 접근, length

public class ArrayBasicsDemo {
    public static void main(String[] args) {

        // ================================================================
        // 1. 배열 선언
        // ================================================================
        // 선언만으로는 메모리 공간이 확보되지 않는다 → 참조값은 null
        int[] a;         // 권장 스타일
        int b[];         // C언어 스타일, Java에서도 허용되지만 비권장

        // System.out.println(a); // 컴파일 에러: 초기화되지 않은 지역 변수


        // ================================================================
        // 2. 배열 생성 (new)
        // ================================================================
        a = new int[3];  // 힙에 int 3칸 확보, a에 참조(주소) 저장
        System.out.println("a.length = " + a.length); // 3

        // 선언 + 생성 동시에
        int[] scores = new int[5];

        // 생성 직후 각 원소는 데이터형의 기본값으로 자동 초기화
        // int → 0, double → 0.0, boolean → false, char → '\u0000', 참조형 → null
        System.out.println("scores[0] = " + scores[0]); // 0 (명시적 초기화 없이도)


        // ================================================================
        // 3. 배열 초기화
        // ================================================================
        // 방법 1: 선언과 동시에 중괄호로 초기화 (가장 일반적)
        int[] nums1 = {10, 20, 30};

        // 방법 2: new와 함께 중괄호 사용
        int[] nums2 = new int[]{10, 20, 30};

        // 방법 3: 선언 후 나중에 초기화할 때는 반드시 new 필요
        int[] nums3;
        // nums3 = {10, 20, 30};        // 컴파일 에러! 분리된 경우 중괄호 단독 불가
        nums3 = new int[]{10, 20, 30};  // OK

        // 초기화 시 배열의 길이를 직접 지정할 수 없다
        // int[] nums4 = new int[3]{10, 20, 30}; // 컴파일 에러


        // ================================================================
        // 4. 배열 요소 접근 및 변경
        // ================================================================
        int[] arr = {10, 20, 30, 40, 50};

        // 읽기
        System.out.println("arr[0] = " + arr[0]); // 10
        System.out.println("arr[4] = " + arr[4]); // 50

        // 쓰기
        arr[1] = 100;
        System.out.println("arr[1] 변경 후 = " + arr[1]); // 100

        // 인덱스 범위: 0 ~ length-1
        // arr[5] = 999; // 런타임 에러: ArrayIndexOutOfBoundsException


        // ================================================================
        // 5. length 속성
        // ================================================================
        int[] data = {1, 2, 3, 4, 5};
        System.out.println("data.length = " + data.length); // 5

        // length는 final 필드 → 변경 불가
        // data.length = 10; // 컴파일 에러: cannot assign a value to final variable length

        // length 활용: 마지막 원소 접근
        System.out.println("마지막 원소 = " + data[data.length - 1]); // 5

        // for문과 length 조합 (순회)
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        System.out.println("합계 = " + sum); // 15


        // ================================================================
        // [심화] 배열 변수는 참조형 - 같은 배열을 가리킬 수 있다
        // ================================================================
        int[] x = {1, 2, 3};
        int[] y = x;         // x의 참조(주소)를 y에 복사 → 같은 배열 공유

        y[0] = 999;
        System.out.println("x[0] = " + x[0]); // 999 (x와 y는 같은 배열!)

        // 내용 비교 시 == 는 참조 비교임에 주의
        int[] p = {1, 2, 3};
        int[] q = {1, 2, 3};
        System.out.println("p == q : " + (p == q));             // false (다른 객체)
        System.out.println("p[0] == q[0] : " + (p[0] == q[0])); // true (값 비교)
    }
}
```

## 코드 블록 2

```text
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
```

## 코드 블록 3

```text
// Array2DDemo.java
// 주제: 2차원 배열 - 선언, 생성, 초기화, 요소 접근, length, 가변 배열

public class Array2DDemo {
    public static void main(String[] args) {

        // ================================================================
        // 1. 2차원 배열 선언 방식 (세 가지 모두 동일)
        // ================================================================
        int[][] a;   // 권장
        // int a[][];
        // int[] a[];


        // ================================================================
        // 2. 배열 생성 - 메모리 구조 이해
        // ================================================================
        // new int[2][3] → 행 배열 1개 + 각 행의 int 배열 2개가 따로 힙에 생성됨
        // a[0], a[1]은 각 행 배열을 가리키는 참조값
        a = new int[2][3];

        System.out.println("행의 수 : " + a.length);    // 2
        System.out.println("열의 수 : " + a[0].length); // 3


        // ================================================================
        // 3. 배열 초기화
        // ================================================================
        int[][] grid = {
            {10, 11, 12},
            {20, 21, 22}
        };

        // 초기화 시에도 길이 명시 불가 (1차원과 동일)
        // int[][] err = new int[2][3]{{10,11,12},{20,21,22}}; // 컴파일 에러


        // ================================================================
        // 4. 요소 접근 및 변경
        // ================================================================
        int[][] numbers = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9, 10, 11, 12}
        };

        // 읽기: [행][열]
        System.out.println("numbers[0][1] = " + numbers[0][1]); // 2
        System.out.println("numbers[2][3] = " + numbers[2][3]); // 12

        // 쓰기
        numbers[1][2] = 100;
        System.out.println("numbers[1][2] 변경 후 = " + numbers[1][2]); // 100

        // 행 인덱스, 열 인덱스 모두 범위 초과 시 ArrayIndexOutOfBoundsException
        // System.out.println(numbers[3][0]); // 런타임 에러: 행 초과
        // System.out.println(numbers[0][4]); // 런타임 에러: 열 초과


        // ================================================================
        // 5. length 사용법 - 가장 많이 헷갈리는 부분
        // ================================================================
        int[][] m = {
            {1, 2, 3, 4},
            {5, 6, 7}
        };

        System.out.println("m.length    = " + m.length);    // 2 (행의 수)
        System.out.println("m[0].length = " + m[0].length); // 4 (0행의 열 수)
        System.out.println("m[1].length = " + m[1].length); // 3 (1행의 열 수, 다를 수 있음!)

        // 중첩 for문으로 전체 순회할 때 열 길이는 반드시 각 행 기준으로 확인
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) { // m[0].length 고정이면 가변 배열에서 에러
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }


        // ================================================================
        // 6. 가변 배열 - 각 행의 열 길이가 달라도 된다
        // ================================================================
        // Java의 2차원 배열은 "배열의 배열" 구조이므로 행마다 열 크기가 달라도 됨
        // (C/C++의 2차원 배열과 구조적으로 다름)

        // 방법: 행 배열만 먼저 만들고, 각 행을 따로 생성
        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1};
        jagged[1] = new int[]{2, 3};
        jagged[2] = new int[]{4, 5, 6};

        for (int i = 0; i < jagged.length; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
        // 출력:
        // 1
        // 2 3
        // 4 5 6

        // jagged[1][5]는 런타임 에러: 1행의 열은 2개뿐
        // System.out.println(jagged[1][5]); // ArrayIndexOutOfBoundsException


        // ================================================================
        // [심화] a[0]은 그 자체로 1차원 배열 참조 → 교체 가능
        // ================================================================
        int[][] mat = new int[2][3];
        mat[0] = new int[]{100, 200}; // 0행을 길이 2짜리 새 배열로 교체
        System.out.println("mat[0].length = " + mat[0].length); // 2 (원래 3이었음)
        System.out.println("mat[1].length = " + mat[1].length); // 3 (그대로)
    }
}
```

## 코드 블록 4

```text
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
```

## 코드 블록 5

```text
// ArrayCopyDemo.java
// 주제: 배열 복사 - 참조 복사 vs 진짜 복사

import java.util.Arrays;

public class ArrayCopyDemo {
    public static void main(String[] args) {

        // ================================================================
        // 1. = 대입은 복사가 아니다 (참조 복사)
        // ================================================================
        int[] original = {1, 2, 3, 4, 5};
        int[] ref = original; // 같은 배열을 가리킬 뿐

        ref[0] = 999;
        System.out.println("original[0] = " + original[0]); // 999 (같이 바뀜!)

        // 배열을 "복사"했다고 생각하고 원본을 건드리지 않으려 했지만
        // 실제로는 같은 배열을 공유하고 있음


        // ================================================================
        // 2. System.arraycopy() - 진짜 복사
        // ================================================================
        // System.arraycopy(src, srcPos, dest, destPos, length)
        //   src     : 원본 배열
        //   srcPos  : 원본 시작 인덱스
        //   dest    : 대상 배열
        //   destPos : 대상 시작 인덱스
        //   length  : 복사할 원소 개수

        int[] src = {10, 20, 30, 40, 50};
        int[] dst = new int[5];

        System.arraycopy(src, 0, dst, 0, src.length); // 전체 복사

        dst[0] = 999;
        System.out.println("src[0] = " + src[0]); // 10 (원본 불변)
        System.out.println("dst[0] = " + dst[0]); // 999

        // 부분 복사: src의 인덱스 1~2 (20, 30)를 dst의 인덱스 2부터 복사
        int[] src2 = {10, 20, 30, 40, 50};
        int[] dst2 = {0, 0, 0, 0, 0};
        System.arraycopy(src2, 1, dst2, 2, 2);
        System.out.println(Arrays.toString(dst2)); // [0, 0, 20, 30, 0]

        // 범위 초과 시 런타임 에러
        // System.arraycopy(src, 3, dst, 3, 5); // ArrayIndexOutOfBoundsException


        // ================================================================
        // 3. Arrays.copyOf() - 길이 지정 복사
        // ================================================================
        int[] data = {1, 2, 3, 4, 5};

        // 전체 복사
        int[] copy1 = Arrays.copyOf(data, data.length);

        // 길이를 늘리면 나머지는 기본값(0)으로 채워짐
        int[] copy2 = Arrays.copyOf(data, 8);
        System.out.println(Arrays.toString(copy2)); // [1, 2, 3, 4, 5, 0, 0, 0]

        // 길이를 줄이면 앞에서부터 잘림
        int[] copy3 = Arrays.copyOf(data, 3);
        System.out.println(Arrays.toString(copy3)); // [1, 2, 3]


        // ================================================================
        // 4. 얕은 복사 주의 - 참조형 배열
        // ================================================================
        // String은 불변(immutable)이라 실질적으로 문제가 없지만
        // 참조형 배열의 복사는 원소 참조값만 복사된다는 점은 알아둘 것
        String[] strOriginal = {"Hello", "World"};
        String[] strCopy = Arrays.copyOf(strOriginal, strOriginal.length);

        strCopy[0] = "Hi"; // String은 새 객체가 만들어지므로 원본 불변
        System.out.println("strOriginal[0] = " + strOriginal[0]); // Hello (영향 없음)
    }
}
```

## 코드 블록 6

```text
// ArraysUtilDemo.java
// 주제: java.util.Arrays 유틸리티 - toString, fill, sort

import java.util.Arrays;

public class ArraysUtilDemo {
    public static void main(String[] args) {

        // ================================================================
        // 1. 배열을 그냥 출력하면 주소값이 나온다
        // ================================================================
        int[] arr = {3, 1, 4, 1, 5};
        System.out.println(arr);             // [I@1b6d3586 형태 (주소값)
        System.out.println(Arrays.toString(arr)); // [3, 1, 4, 1, 5] (내용 출력)

        // 2차원 배열은 Arrays.deepToString() 사용
        int[][] matrix = {{1, 2}, {3, 4}};
        System.out.println(Arrays.toString(matrix));         // [[I@..., [I@...] (행 주소값)
        System.out.println(Arrays.deepToString(matrix));     // [[1, 2], [3, 4]]


        // ================================================================
        // 2. Arrays.fill() - 배열 전체 또는 범위를 같은 값으로 채운다
        // ================================================================
        int[] filled = new int[5];
        Arrays.fill(filled, 7);
        System.out.println(Arrays.toString(filled)); // [7, 7, 7, 7, 7]

        // 범위 지정: fill(배열, fromIndex, toIndex, value)
        // fromIndex 포함, toIndex 미포함
        Arrays.fill(filled, 1, 4, 0);
        System.out.println(Arrays.toString(filled)); // [7, 0, 0, 0, 7]


        // ================================================================
        // 3. Arrays.sort() - 오름차순 정렬 (기본)
        // ================================================================
        int[] nums = {5, 3, 8, 1, 9, 2};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums)); // [1, 2, 3, 5, 8, 9]

        // sort는 원본 배열 자체를 변경한다
        // 원본을 유지하려면 복사 후 정렬
        int[] original = {5, 3, 8, 1};
        int[] sorted = Arrays.copyOf(original, original.length);
        Arrays.sort(sorted);
        System.out.println("original: " + Arrays.toString(original)); // [5, 3, 8, 1]
        System.out.println("sorted  : " + Arrays.toString(sorted));   // [1, 3, 5, 8]

        // 범위 정렬: sort(배열, fromIndex, toIndex)
        int[] partial = {5, 3, 8, 1, 9, 2};
        Arrays.sort(partial, 1, 4); // 인덱스 1~3만 정렬 (toIndex 미포함)
        System.out.println(Arrays.toString(partial)); // [5, 1, 3, 8, 9, 2]

        // String 배열도 정렬 가능 (사전순)
        String[] words = {"banana", "apple", "cherry"};
        Arrays.sort(words);
        System.out.println(Arrays.toString(words)); // [apple, banana, cherry]
    }
}
```
