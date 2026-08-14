class Calculator {
    static int sum(int... nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        return total;
    }

    static double average(int... nums) {
        if (nums.length == 0) {
            return 0.0;
        }
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        return (double) total / nums.length;
    }
}

public class Q07 {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(1, 2, 3));
        System.out.println(Calculator.sum(1, 2, 3, 4, 5));
        System.out.println(Calculator.average());
        System.out.println(Calculator.average(2, 3, 4, 5));
    }
}
