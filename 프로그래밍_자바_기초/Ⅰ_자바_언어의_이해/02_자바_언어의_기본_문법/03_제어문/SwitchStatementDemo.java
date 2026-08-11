public class SwitchStatementDemo {
    public static void main(String[] args) {
        
    int day = 3;
    if(day == 1) {
        System.out.println("월요일");
    } else if(day == 2) {
        System.out.println("화요일");
    } else {
        System.out.println("수요일");
    }
        switch (day) {
            case 1: System.out.println("월요일"); break;
            case 2: System.out.println("화요일"); break;
            case 3: System.out.println("수요일"); break;
            default: System.out.println("기타"); 
        }
    }
}
