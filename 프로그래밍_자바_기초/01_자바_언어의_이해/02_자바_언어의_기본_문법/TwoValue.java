import java.util.Scanner;

public class TwoValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("아래에 두 수를 입력:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a == b) {
            System.out.println("두수는 같습니다");
        } else {
            System.out.println("두수는 다릅니다");
        }
    }
}
