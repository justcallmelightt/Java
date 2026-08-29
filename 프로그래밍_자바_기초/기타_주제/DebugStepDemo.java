class MathHelper {

    int divide(int a, int b) {
        int result = a / b;   // 정수 나눗셈 — 소수점 버려짐
        return result;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int addAndDouble(int a, int b) {
        int sum = a + b;
        int doubled = sum * 2;
        return doubled;
    }
}

public class DebugStepDemo {
    public static void main(String[] args) {
        MathHelper helper = new MathHelper();

        int x = 10;
        int y = 4;

        int result1 = helper.divide(x, y);       // 여기에 Breakpoint
        int result2 = helper.multiply(x, y);
        int result3 = helper.addAndDouble(x, y);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
