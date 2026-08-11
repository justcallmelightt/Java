# IntelliJ 디버거 사용법

- 원문: http://yubs.online/java/%EA%B8%B0%ED%83%80-%EC%A3%BC%EC%A0%9C/01_intellij-%EB%94%94%EB%B2%84%EA%B1%B0-%ED%99%9C%EC%9A%A9.html
- 용도: yubs.online 수업 페이지의 코드 블록을 원문 순서대로 보존한 학습 자료입니다.
- 실행 가능한 예제는 같은 단원의 Java 파일을 우선 참고하세요.

## 코드 블록 1

```text
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
            System.out.println("i = " + i + ", sum = " + sum); // 확인용
        }
        System.out.println("최종 합계: " + sum);
    }
}
```

## 코드 블록 2

```text
public class DebugBasicDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        int sum = a + b;
        int diff = a - b;
        int product = a * b;
        int quotient = a / b;

        System.out.println("합: " + sum);
        System.out.println("차: " + diff);
        System.out.println("곱: " + product);
        System.out.println("몫: " + quotient);
    }
}
```

## 코드 블록 3

```text
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
```

## 코드 블록 4

```text
F8 (Step Over)   : 메서드를 통째로 실행하고 다음 줄
F7 (Step Into)   : 메서드 안으로 진입
Shift+F8 (Step Out) : 메서드 나머지를 실행하고 탈출
```

## 코드 블록 5

```text
public class DebugWatchDemo {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 9, 2, 7};

        // 버블정렬: 인접한 두 값을 비교해서 큰 값을 오른쪽으로 밀어내는 정렬
        // i: 몇 번째 패스인지 (패스가 끝날 때마다 가장 큰 값이 오른쪽에 확정됨)
        // j: 현재 비교 중인 위치 (arr[j]와 arr[j+1]을 비교)
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 왼쪽 값이 더 크면 두 값의 위치를 맞바꿈 (swap)
                    int temp = arr[j];
                    arr[j] = arr[j + 1];    // 여기에 Breakpoint
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("정렬 완료");
    }
}
```

## 코드 블록 6

```text
arr.length          → 7
arr[0] + arr[1]     → 현재 두 값의 합
i * 2               → i의 두 배
```

## 코드 블록 7

```text
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
```
