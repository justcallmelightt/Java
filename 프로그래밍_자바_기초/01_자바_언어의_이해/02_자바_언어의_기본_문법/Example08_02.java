// Scanner 객체 생성
Scanner sc = new Scanner(System.in);

// 기본 사용 예시
System.out.print("정수 입력 : ");
int num = sc.nextInt();
System.out.println("입력값 : " + num);

System.out.print("실수 입력 : ");
double d = sc.nextDouble();
System.out.println("입력값 : " + d);

System.out.print("문자열 입력 : ");
String str = sc.nextLine();
System.out.println("입력값 : " + str);

// 주의 - nextInt(), nextLong(), nextDouble() 후 nextLine() 사용 시 버퍼 문제
// 숫자 입력 메서드는 \n을 버퍼에 남기므로, 이후 nextLine() 사용 전 반드시 아래 패턴 필요
int age = sc.nextInt();
// 버퍼에 남은 \n 제거 (필수 패턴)
sc.nextLine();
// 정상 입력
String name = sc.nextLine();

// 사용 후 닫기 (일단 안해도 됨)
sc.close();
