class Robot {
    private static int count = 0;
    private String name;

    Robot() {
        count++;
        this.name = "로봇-" + count;
    }

    String getName() {
        return name;
    }

    static int getCount() {
        return count;
    }
}

public class Q11 {
    public static void main(String[] args) {
        Robot[] robots = new Robot[10];
        for (int i = 0; i < robots.length; i++) {
            robots[i] = new Robot();
        }
        for (int i = 0; i < robots.length; i++) {
            if ((i + 1) % 2 != 0) {
                System.out.println(robots[i].getName());
            }
        }
        System.out.println("전체 생성 수: " + Robot.getCount());
    }
}
