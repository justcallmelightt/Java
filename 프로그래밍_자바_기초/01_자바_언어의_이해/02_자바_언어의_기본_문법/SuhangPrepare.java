import java.util.Scanner;

public class SuhangPrepare {
    public static void main(String[] args) {
        /* 민주리 T 문제 선택 5개 */
        // 1. 근로소득 세금 문제
//        Scanner sc = new Scanner(System.in);
//        System.out.print("근로소득 입력(만원): ");
//        int salary = sc.nextInt();
//        double tax;
//        if(salary > 8000) {
//            tax = salary * 0.4;
//        } else if(salary > 4000 && salary <= 8000) {
//            tax = salary * 0.25;
//        } else if(salary > 2000 && salary <= 4000) {
//            tax = salary * 0.15;
//        } else {
//            tax = salary * 0.05;
//        }
//        System.out.println("세금: " + tax);

        // 2. 근무평가등급에 따른 새 연봉 구하기 문제
//        Scanner sc = new Scanner(System.in);
//        System.out.print("현 연봉(만원): ");
//        double currentSalary = sc.nextDouble();
//        System.out.print("근무평가등급(우수, 보통, 불량): ");
//        sc.nextLine();
//        String rating = sc.nextLine();
//        double raise = 0.0; // 연봉 인상액
//        double newSalary;
//        if(rating.equals("우수")) {
//            raise = currentSalary * 0.06;
//            newSalary = currentSalary + raise;
//        } else if(rating.equals("보통")) {
//            newSalary = currentSalary * 1.04;
//        } else if(rating.equals("불량")) {
//            newSalary = currentSalary * 1.02;
//        } else {
//            System.out.println("잘못된 등급 입력");
//            newSalary = -1;
//        }
//        System.out.println(newSalary);

        // 3. "1 - 2 + 3 - 4 + 5 ... -n" 을 구하는 문제 (수식 출력 포함)
//        Scanner sc = new Scanner(System.in);
//        System.out.print("N입력: ");
//        int n = sc.nextInt();
//        int sum = 0;
//        for(int i=1;i<=n;i++) {
//            if(i == 1) {
//                sum += 1;
//                System.out.print("1");
//            } else if(i % 2 == 0) {
//                sum -= i;
//                System.out.print("-" + i);
//            } else {
//                sum += i;
//                System.out.print("+" + i);
//            }
//        }
//        System.out.println("\n총 합:" + sum);

        // 4. StudentScore 문제 (사용자로부터 학생 정보랑 점수 입력받아서 총합, 평균 구하는 문제)
//        Scanner sc = new Scanner(System.in);
//        System.out.print("학생 이름 입력: ");
//        String name = sc.nextLine();
//        System.out.print("학교 이름 입력: ");
//        String school = sc.nextLine();
//        System.out.print("입력 점수 개수 입력: ");
//        int n = sc.nextInt();
//        int sum = 0;
//        for(int i=1;i<=n;i++) {
//            System.out.print(i + "번째 점수 입력: ");
//            int score = sc.nextInt();
//            sum += score;
//        }
//        System.out.println("--- 결과 리포트 ---");
//        System.out.println("학교: " + school);
//        System.out.println("학교: " + name);
//        System.out.println("점수 총합: " + sum);
//        System.out.println("평균 점수: " + ((double) sum / n));

        // 5. 0이 입력될때까지, 양수를 입력받고, 입력받은 양수중 최대값을 출력하는 문제
//        Scanner sc = new Scanner(System.in);
//        int num, max = 0;
//        while(true) {
//            System.out.print("양수 입력: ");
//            num = sc.nextInt();
//            if(max < num) {
//                max = num;
//            }
//            if(num == 0) break;
//        }
//        System.out.println("최대값: " + max);

        /* 추가 문제 */
//        // 4번 문제 - 급여 계산 문제
//        final int MINIMUM_WAGE = 9860;
//        Scanner sc = new Scanner(System.in);
//        System.out.print("시간당 시급 입력: ");
//        int payPerHour = sc.nextInt();
//        System.out.print("근무 시간 입력: ");
//        int workHours = sc.nextInt();
//        System.out.println("급여: " + (payPerHour * workHours));
//        System.out.println("차이: " + ((payPerHour * workHours) - (MINIMUM_WAGE * workHours)));

//        // 9번 문제 - 단리 이자 계산
//        Scanner sc = new Scanner(System.in);
//        System.out.print("원금 입력: ");
//        int price = sc.nextInt();
//        System.out.print("연이율 입력: ");
//        double interest = sc.nextDouble();
//        System.out.print("기간(년) 입력: ");
//        int years = sc.nextInt();
//        double v = price * interest * years;
//        System.out.println("단리 이자: " + v);
//        System.out.println("최종 금액: " + (price + v));

//        // 9번 문제 - 배달비 계산 문제
//        Scanner sc = new Scanner(System.in);
//        System.out.print("주문 금액 입력: ");
//        int orderPrice = sc.nextInt();
//        int fee = 0;
//        if(orderPrice < 15000) {
//            fee = 3000;
//        } else if(orderPrice >= 15000 && orderPrice < 30000) {
//            fee = 1000;
//        }
//        System.out.println("최종 금액(배달비 포함): " + (orderPrice + fee));

//        // 10번 문제 - 대출 가능 여부 판단 문제
//        Scanner sc = new Scanner(System.in);
//        System.out.print("나이 입력: ");
//        int age = sc.nextInt();
//        System.out.print("연소득 입력: ");
//        int salary = sc.nextInt();
//        System.out.print("신용점수 입력: ");
//        int creditScore = sc.nextInt();
//
//        boolean loan = true;
//        int limit = 0;
//        if(age < 20 || creditScore < 600) {
//            loan = false;
//        } else {
//            if(creditScore < 800) {
//                limit = 2000;
//            } else {
//                if(salary >= 5000) {
//                    limit = 10000;
//                } else {
//                    limit = 5000;
//                }
//            }
//        }
//
//        System.out.println("대출 가능 여부: " + (loan ? "대출 가능" : "대출 불가"));
//        System.out.println("대출 한도: " + limit);

//        // 6번 문제 - 계절 출력
//        Scanner sc = new Scanner(System.in);
//        System.out.print("월(month) 입력: ");
//        int month = sc.nextInt();
//        String season = null;
//        switch (month) {
//            case 3: case 4: case 5:
//                season = "봄";
//                break;
//            case 6: case 7: case 8:
//                season = "여름";
//                break;
//            case 9: case 10: case 11:
//                season = "가을";
//                break;
//            case 12: case 1: case 2:
//                season = "겨울";
//                break;
//            default:
//                System.out.println("잘못된 입력");
//        }
//        System.out.println("계절: " + season);

//        // 반복문 문제 - 최소값, 최대값 구하기
//        Scanner sc = new Scanner(System.in);
//        System.out.print("개수 n 입력: ");
//        int n = sc.nextInt();
//        int min = 0;
//        int max = 0;
//        for(int i=1;i<=n;i++) {
//            int num = sc.nextInt();
//            if(num < min) min = num;
//            if(num > max) max = num;
//        }
//        System.out.println("최소값: " + min);
//        System.out.println("최대값: " + max);
    }
}
