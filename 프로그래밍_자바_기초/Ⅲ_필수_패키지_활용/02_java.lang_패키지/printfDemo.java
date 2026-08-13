// System.out.println()은 출력 형식을 직접 제어하기 어렵다. 소수점 자릿수, 출력 폭 등을 지정하고 싶을 때는 printf()나 String.format()을 사용한다.

public class printfDemo {
    public static void main(String[] args) {
        System.out.printf("이름: %s, 나이: %d%n", "홍길동", 20);
        // 출력: 이름: 홍길동, 나이: 20
        
        double pi = 3.14159265;

        System.out.printf("%.2f", pi);  // 3.14
        System.out.printf("%.4f", pi);  // 3.1416

        /* String.format

        printf()와 문법이 동일하지만, 출력 대신 String으로 반환한다.
        변수에 저장하거나 다른 메서드에 넘길 때 유용하게 사용 가능하다. */
        
        String result = String.format("원주율: %.2f", 3.14159265);
        System.out.println(result);  // 원주율: 3.14
    }
}
