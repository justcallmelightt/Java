import java.util.Random;
import java.util.concurrent.ThreadLocalRandom; // 여러 스레드가 동시에 난수를 생성할 때 성능 저하를 막기 위한 클래스. 스레드별로 독립된 생성기를 쓰기 때문에 경합이 없다.

public class RandomUtilDemo {
    public static void main(String[] args) {
        // 1. 기본 Random 클래스 사용
        Random random = new Random();

        int dice = random.nextInt(6) + 1;          // 1~6
        int randInRange = random.nextInt(10, 21);  // 10~20 (Java 17 이상 공식 지원)
        double randDouble = random.nextDouble();      // 0.0 이상 1.0 미만
        boolean randBool = random.nextBoolean();

        System.out.println("=== 기본 Random 결과 ===");
        System.out.println("주사위 (1~6): " + dice);
        System.out.println("범위 지정 (10~20): " + randInRange);
        System.out.println("랜덤 실수를 반환 (0.0~1.0): " + randDouble);
        System.out.println("랜덤 불리언 반환: " + randBool);
        System.out.println();

        // 2. ThreadLocalRandom 사용 (변수명 중복 버그 수정: tlr 접두사 추가)
        int tlrDice = ThreadLocalRandom.current().nextInt(1, 7); // 1~6 (시작값 포함, 끝값 제외)
        double tlrRandDouble = ThreadLocalRandom.current().nextDouble();

        System.out.println("=== ThreadLocalRandom 결과 ===");
        System.out.println("TLR 주사위 (1~6): " + tlrDice);
        System.out.println("TLR 랜덤 실수: " + tlrRandDouble);
        System.out.println();

        // 3. 동일한 시드(Seed)를 가진 Random 객체 비교
        // 같은 시드로 생성한 Random은 항상 같은 순서로 똑같은 값을 만든다.
        Random r1 = new Random(100);
        Random r2 = new Random(100);

        System.out.println("=== 동일한 Seed(100) 테스트 ===");
        System.out.println("r1 첫 번째 값: " + r1.nextInt(100)); // r2와 항상 동일한 결과
        System.out.println("r2 첫 번째 값: " + r2.nextInt(100));
        System.out.println("r1 두 번째 값: " + r1.nextInt(100)); // 다음 값들도 순서대로 일치함
        System.out.println("r2 두 번째 값: " + r2.nextInt(100));

        /*
        * 1. Random 클래스 (의사 난수)
        컴퓨터 공식 기반의 가짜 무작위 수(의사 난수)를 생성함.
        같은 시드(Seed)를 넣으면 실행할 때마다 항상 똑같은 순서와 숫자가 나옴.
        2. ThreadLocalRandom (멀티스레드 최적화)
        하나의 Random을 여러 스레드가 공유하면 줄 서기 현상(경합)으로 성능이 저하됨.
        각 스레드마다 독립된 생성기를 줘서 동시 접속 환경에서도 속도가 밀리지 않음.
        */
    }
}
