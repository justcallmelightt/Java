# (1) Math.random()

- 원문: http://yubs.online/java/(1%ED%95%99%EA%B8%B0)_%EA%B8%B0%EC%B4%88/01_%EC%9E%90%EB%B0%94-%EC%96%B8%EC%96%B4%EC%9D%98-%EC%9D%B4%ED%95%B4-(%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4)/999_%EB%9E%9C%EB%8D%A4%EA%B0%92-%EC%83%9D%EC%84%B1-%EB%B0%A9%EB%B2%95.html
- 용도: yubs.online 수업 페이지의 코드 블록을 원문 순서대로 보존한 학습 자료입니다.
- 실행 가능한 예제는 같은 단원의 Java 파일을 우선 참고하세요.

## 코드 블록 1

```text
double rand = Math.random();

int dice = (int)(Math.random() * 6) + 1;                     // 1~6
int randInRange = (int)(Math.random() * (20 - 10 + 1)) + 10; // 10~20
```

## 코드 블록 2

```text
import java.util.Random;

Random random = new Random();

int dice = random.nextInt(6) + 1;          // 1~6
int randInRange = random.nextInt(10, 21);  // 10~20
double randDouble = random.nextDouble();
boolean randBool = random.nextBoolean();
```

## 코드 블록 3

```text
Random r1 = new Random(100);
Random r2 = new Random(100);
System.out.println(r1.nextInt(100)); // r2와 항상 동일한 결과
System.out.println(r2.nextInt(100));
```

## 코드 블록 4

```text
import java.util.concurrent.ThreadLocalRandom;

int dice = ThreadLocalRandom.current().nextInt(1, 7); // 1~6
double randDouble = ThreadLocalRandom.current().nextDouble();
```
