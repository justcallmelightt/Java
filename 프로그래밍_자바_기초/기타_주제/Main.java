public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
            System.out.println("i = " + i + ", sum = " + sum); // 확인용
        }
        System.out.println("최종 합계: " + sum);
    }
}
