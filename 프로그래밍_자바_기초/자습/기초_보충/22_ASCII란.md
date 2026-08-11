# ASCII란?

- 원문: http://yubs.online/java/(1%ED%95%99%EA%B8%B0)_%EA%B8%B0%EC%B4%88/01_%EC%9E%90%EB%B0%94-%EC%96%B8%EC%96%B4%EC%9D%98-%EC%9D%B4%ED%95%B4-(%EB%B3%B4%EC%A1%B0%EC%9E%90%EB%A3%8C)/03_%EC%95%84%EC%8A%A4%ED%82%A4-%ED%85%8C%EC%9D%B4%EB%B8%94%EA%B3%BC-%EB%AC%B8%EC%9E%90-%ED%91%9C%ED%98%84-%EC%9D%B4%ED%95%B4.html
- 용도: yubs.online 수업 페이지의 코드 블록을 원문 순서대로 보존한 학습 자료입니다.
- 실행 가능한 예제는 같은 단원의 Java 파일을 우선 참고하세요.

## 코드 블록 1

```text
Dec  Char    Dec  Char    Dec  Char    Dec  Char
 32  (space)  56   8       80   P      104   h
 33   !       57   9       81   Q      105   i
 34   "       58   :       82   R      106   j
 35   #       59   ;       83   S      107   k
 36   $       60   <       84   T      108   l
 37   %       61   =       85   U      109   m
 38   &       62   >       86   V      110   n
 39   '       63   ?       87   W      111   o
 40   (       64   @       88   X      112   p
 41   )       65   A       89   Y      113   q
 42   *       66   B       90   Z      114   r
 43   +       67   C       91   [      115   s
 44   ,       68   D       92   \      116   t
 45   -       69   E       93   ]      117   u
 46   .       70   F       94   ^      118   v
 47   /       71   G       95   _      119   w
 48   0       72   H       96   `      120   x
 49   1       73   I       97   a      121   y
 50   2       74   J       98   b      122   z
 51   3       75   K       99   c      123   {
 52   4       76   L      100   d      124   |
 53   5       77   M      101   e      125   }
 54   6       78   N      102   f      126   ~
 55   7       79   O      103   g
```

## 코드 블록 2

```text
32   공백 (space)
48   '0'   ~   57   '9'
65   'A'   ~   90   'Z'
97   'a'   ~  122   'z'
```

## 코드 블록 3

```text
char c = 'A';
int n = c;               // 묵시적 변환 가능
System.out.println(n);   // 65
```

## 코드 블록 4

```text
int n = 65;
char c = (char) n;       // 명시적 캐스팅 필요
System.out.println(c);   // A
```

## 코드 블록 5

```text
char c = 'A';
System.out.println(c);       // A  <- 문자로 인식 (단, 내부적으로는 숫자임)
System.out.println((int) c); // 65 <- 타입 변환을 하여 정수로 인식됨
```

## 코드 블록 6

```text
'A' = 65,  'a' = 97   →  차이 : 32
'B' = 66,  'b' = 98   →  차이 : 32
'Z' = 90,  'z' = 122  →  차이 : 32
```

## 코드 블록 7

```text
char upper = 'G';
char lower = (char) (upper + 32);   // 'g'
System.out.println(lower);          // g

char lower2 = 'g';
char upper2 = (char) (lower2 - 32); // 'G'
System.out.println(upper2);         // G
```

## 코드 블록 8

```text
'0' = 48 // 숫자 48이 글자 '0'
'1' = 49
'5' = 53
'9' = 57
```

## 코드 블록 9

```text
char c = '5';
int wrong = c;       // 53  <- 아스키 값
int right = c - '0'; // 5   <- 실제 숫자 값
```

## 코드 블록 10

```text
int n = 7;
char c = (char) (n + '0'); // '7'
System.out.println(c);     // 7
```

## 코드 블록 11

```text
char c1 = '\u0041'; // 'A'
char c2 = '\u0042'; // 'B'
char c3 = '\u0061'; // 'a'
char c4 = '\uAC00'; // '가'
char c5 = '\uD7A3'; // '힣'
System.out.println(c1);
System.out.println(c2);
System.out.println(c3);
System.out.println(c4);
System.out.println(c5);

// char c4 = '\uAC0';   // 컴파일 에러 : 4자리 맞추지 않으면 에러
```

## 코드 블록 12

```text
// 아스키 테이블의 출력 가능한 글자 전체 출력
for (int i = 32; i <= 126; i++) {
    System.out.printf("%3d : %c%n", i, (char) i);
}
```

## 코드 블록 13

```text
// 한글 전체를 출력 (유니코드 범위: AC00 ~ D7A3)
for(char s=0xAC00;s<=0xD7A3;s++) {
	System.out.print(s);
}
```

## 코드 블록 14

```text
BufferedWriter bw = new BufferedWriter(new FileWriter("unicode.txt"));
for (int c = 32; c <= 65535; c++) {
	bw.write(c);
}
bw.close();
System.out.println("완료");
```
