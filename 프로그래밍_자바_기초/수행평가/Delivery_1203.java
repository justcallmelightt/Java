import java.util.Scanner;

/**
 * 배송 정보를 저장하고 관리하는 클래스
 *
 * 멤버변수:
 * 1. recipient: 배송 물품을 받을 수령인
 * 2. fee: 배송 요금
 * 3. weight: 배송 물품의 무게
 */
class Delivery {
    // 1. [조건 1] 수령인, 요금, 무게를 저장할 멤버변수 선언
    String recipient;
    int fee;
    int weight;

    // 2. 객체를 생성할 때 전달받은 값으로 모든 멤버변수를 초기화하는 생성자
    Delivery(String recipient, int fee, int weight) {
        this.recipient = recipient;
        this.fee = fee;
        this.weight = weight;
    }

    // 3. [조건 2] 새로운 배송 요금을 전달받아 변경하는 메소드
    void setFee(int fee) {
        // 요금이 0보다 작으면 오류 메시지만 출력하고 기존 요금을 유지
        if (fee < 0) {
            System.out.println("유효하지 않은 요금입니다.");
        } else {
            // 요금이 0 이상이면 멤버변수 fee에 새로운 값을 저장
            this.fee = fee;
        }
    }

    // 4. [조건 3] 세 멤버변수를 지정된 형식의 문자열로 만들어 반환하는 메소드
    String getInfo() {
        return "수령인: " + recipient + " | 요금: " + fee + "원 | 무게: " + weight + "kg";
    }
}

/**
 * [프로그래밍 자바 기초] - 자바 프로그래밍 수행평가
 *
 * 문제명: 배송 정보 클래스 (Delivery) (Delivery_1203.java)
 *
 * 문제 조건 및 학습 목표:
 * 1. [조건 1] recipient, fee, weight 멤버변수를 가진 Delivery 클래스 정의
 * 2. [조건 2] setFee()에서 음수 요금을 검사하고 올바른 값만 저장
 * 3. [조건 3] getInfo()에서 배송 정보를 지정된 형식의 문자열로 반환
 * 4. 사용자에게 배송 정보를 입력받아 Delivery 객체 생성
 * 5. 클래스, 객체, 생성자, 멤버변수와 메소드 사용 방법 학습
 *
 * 작성자: 미림마이스터고등학교 뉴미디어소프트웨어과 1203 권율
 */
public class Delivery_1203 {
    public static void main(String[] args) {
        // 5. 키보드 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 6. 사용자에게 수령인을 문자열로 입력받음
        System.out.print("수령인 : ");
        String recipient = sc.nextLine();

        // 7. 사용자에게 최초 배송 요금을 정수로 입력받음
        System.out.print("요금 : ");
        int fee = sc.nextInt();

        // 8. 사용자에게 배송 물품의 무게를 정수로 입력받음
        System.out.print("무게 : ");
        int weight = sc.nextInt();

        // 9. 입력받은 값들을 생성자에 전달하여 Delivery 객체 생성
        Delivery delivery = new Delivery(recipient, fee, weight);

        // 10. getInfo()가 반환한 최초 배송 정보를 출력
        System.out.println(delivery.getInfo());

        // 11. 사용자에게 변경할 배송 요금을 입력받음
        System.out.print("변경할 요금 : ");
        int newFee = sc.nextInt();

        // 12. setFee()로 요금 변경을 시도하고 변경 결과를 다시 출력
        delivery.setFee(newFee);
        System.out.println(delivery.getInfo());

        // Resource leak 방지를 위해 사용이 끝난 Scanner 객체 해제
        sc.close();
    }
}
