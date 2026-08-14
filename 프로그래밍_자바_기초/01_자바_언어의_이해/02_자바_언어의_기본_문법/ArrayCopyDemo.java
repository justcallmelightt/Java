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
