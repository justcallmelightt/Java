/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 17번 문제 - static 초기화 블록 + 배열 (어려움) (PrimeCachePractice.java)
 *
 * 문제 조건:
 * 1. static 초기화 블록으로 소수(prime number) 배열을 미리 계산해두는
 * 2. PrimeCache 클래스를 작성하시오.
 * 3. - private static int[] primes : 크기 10
 * 4. - static 초기화 블록에서 primes 배열에 소수 10개를 채운다.
 * 5. (소수 판별은 직접 구현)
 * 6. - static int get(int index) : index번째 소수 반환
 * 7. - static void printAll() : 전체 출력
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 배열과 반복문으로 여러 객체 또는 데이터를 순서대로 처리한다.
 * 3. 인스턴스 멤버와 클래스(static) 멤버의 차이를 이해한다.
 * 4. 접근 제어와 getter/setter로 객체의 상태를 안전하게 관리한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class PrimeCache {
    private static int[] primes = new int[10];

    static {
        int count = 0;
        int num = 2;
        while (count < 10) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[count++] = num;
            }
            num++;
        }
    }

    static int get(int index) {
        return primes[index];
    }

    static void printAll() {
        for (int i = 0; i < primes.length; i++) {
            System.out.print(primes[i]);
            if (i < primes.length - 1) System.out.print(" ");
        }
        System.out.println();
    }
}

public class PrimeCachePractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        PrimeCache.printAll();
        System.out.println("5번째 소수: " + PrimeCache.get(4));
    }
}
