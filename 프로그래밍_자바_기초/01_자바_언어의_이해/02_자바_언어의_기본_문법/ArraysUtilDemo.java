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
