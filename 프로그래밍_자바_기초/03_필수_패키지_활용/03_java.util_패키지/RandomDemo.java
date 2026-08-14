// RandomDemo.java
// 주제: Random 클래스 - java.util 패키지의 난수 생성기, 원하는 타입으로 바로 난수를 뽑는다

import java.util.Random;

public class RandomDemo {

    public static void main(String[] args) {

        // ================================================================
        // 1. Random 객체 생성
        // ================================================================
        // Math.random()은 0.0~1.0 사이 double만 주고, 원하는 타입을 얻으려면
        // 매번 곱하고 캐스팅하는 계산이 필요했다.
        // Random 클래스는 객체를 하나 만들어두고, 원하는 타입에 맞는 메소드를
        // 바로 호출하면 된다는 점이 다르다.
        Random random = new Random();

        System.out.println();

        // ================================================================
        // 2. nextInt() - 매개변수 없이 쓰면 int 전체 범위
        // ================================================================
        // -2,147,483,648 ~ 2,147,483,647 사이의 값이 그대로 나온다.
        System.out.println("nextInt()      : " + random.nextInt());

        // ================================================================
        // 3. nextInt(n) - 0 이상 n 미만의 정수 (실전에서 제일 많이 씀)
        // ================================================================
        // Math.random() * n 으로 매번 계산하던 걸 nextInt(n) 하나로 끝낸다.
        System.out.println("nextInt(10)    : " + random.nextInt(10));      // 0~9

        // 원하는 범위로 만들고 싶으면 더하기만 하면 된다 (곱하기 계산이 필요 없어짐)
        System.out.println("nextInt(10)+1  : " + (random.nextInt(10) + 1)); // 1~10

        System.out.println();

        // ================================================================
        // 4. 다른 타입의 난수도 각자 전용 메소드로 바로 뽑는다
        // ================================================================
        System.out.println("nextBoolean()  : " + random.nextBoolean());   // true 또는 false
        System.out.println("nextFloat()    : " + random.nextFloat());    // 0.0~1.0 사이 float
        System.out.println("nextDouble()   : " + random.nextDouble());   // 0.0~1.0 사이 double
        System.out.println("nextLong()     : " + random.nextLong());     // long 전체 범위

        System.out.println();

        // ================================================================
        // 5. 실전 예시 - 주사위 두 개 굴리기
        // ================================================================
        // Math.random()으로 만들 때는 "* 6 + 1" 같은 계산이 필요했는데,
        // nextInt(6) + 1 로 바로 끝난다.
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;

        System.out.println("주사위1: " + dice1 + ", 주사위2: " + dice2 + ", 합: " + (dice1 + dice2));
    }
}
