public class Narcissus {
    public static void main(String[] args) {
        int count = 0;
        for (int n = 100; n <= 999; n++) {
            int a = n / 100;
            int b = (n / 10) % 10;
            int c = n % 10;
            if (a * a * a + b * b * b + c * c * c == n) {
                count++;
                System.out.println(count + "번째 나르시시즘 수 : " + n);
            }
        }
    }
}
