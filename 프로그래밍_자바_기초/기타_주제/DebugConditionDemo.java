public class DebugConditionDemo {
    public static void main(String[] args) {
        String[] names  = {"김철수", "이영희", "홍길동", "박민준", "최수연"};
        int[] scores = {72, 85, 43, 91, 38};

        int failCount = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failCount++;            // 여기에 Conditional Breakpoint
            }
        }

        System.out.println("불합격 인원: " + failCount);
    }
}
