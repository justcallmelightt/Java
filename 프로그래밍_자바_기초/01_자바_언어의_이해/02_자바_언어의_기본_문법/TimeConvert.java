import java.util.Scanner;

public class TimeConvert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("초 입력 : ");
        int seconds = sc.nextInt();
        int hours   = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs    = seconds % 60;
        System.out.println(hours + "시간 " + minutes + "분 " + secs + "초");
        sc.close();
    }
}
