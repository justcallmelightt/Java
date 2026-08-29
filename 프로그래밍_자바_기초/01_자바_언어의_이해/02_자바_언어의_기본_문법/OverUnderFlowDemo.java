public class OverUnderFlowDemo {
    public static void main(String[] args) {
        // 1. int 오버플로우 - 최댓값에서 +1
        int maxInt = Integer.MAX_VALUE; // 2,147,483,647
        System.out.println("int 최댓값: " + maxInt);
        System.out.println("최댓값 + 1: " + (maxInt + 1)); // -2,147,483,648 (음수로 wrap!)
        System.out.println();

        // 2. int 언더플로우 - 최솟값에서 -1
        int minInt = Integer.MIN_VALUE; // -2,147,483,648
        System.out.println("int 최솟값: " + minInt);
        System.out.println("최솟값 - 1: " + (minInt - 1)); // 2,147,483,647 (양수로 wrap!)
        System.out.println();

        // 3. byte로 더 짧게 체감
        byte b = 127;
        System.out.println("byte 최댓값: " + b);
        b++;
        System.out.println("127 + 1 = " + b); // -128
        System.out.println();

        // 4. 실무 사고 사례 - 대용량 곱셈
        int views1 = 1_000_000;
        int views2 = 1_000_000;
        System.out.println("int 곱셈 결과: " + (views1 * views2));        // 오버플로우!
        System.out.println("long 곱셈 결과: " + ((long)views1 * views2)); // 정상
    }
}
