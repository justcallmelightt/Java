class MathUtil {
    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }

    static int abs(int n) {
        return n < 0 ? -n : n;
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }
}

public class Q03 {
    public static void main(String[] args) {
        System.out.println(MathUtil.max(7, 10));
        System.out.println(MathUtil.min(3, 9));
        System.out.println(MathUtil.abs(-5));
        System.out.println(MathUtil.isEven(4));
        System.out.println(MathUtil.isEven(7));
    }
}
