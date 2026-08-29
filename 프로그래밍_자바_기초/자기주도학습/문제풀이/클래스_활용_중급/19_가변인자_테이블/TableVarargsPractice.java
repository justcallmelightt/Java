/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 19번 문제 - 가변 인자 + 클래스 설계 (어려움) (TableVarargsPractice.java)
 *
 * 문제 조건:
 * 1. Table 클래스를 작성하시오.
 * 2. - private String[] headers
 * 3. - private String[][] rows (최대 100행)
 * 4. - private int rowCount = 0
 * 5. - 생성자: 가변 인자로 헤더를 받는다. Table(String... headers)
 * 6. - addRow(String... values) : 행 추가.
 * 7. 값의 수가 헤더 수와 다르면 "열 수 불일치" 출력 후 무시
 * 8. - print() : 헤더와 행을 | 구분자로 출력
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 * 3. 접근 제어와 getter/setter로 객체의 상태를 안전하게 관리한다.
 * 4. 가변 인자를 사용해 호출 시 전달되는 인자 수를 유연하게 처리한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Table {
    private String[] headers;
    private String[][] rows = new String[100][];
    private int rowCount = 0;

    Table(String... headers) {
        this.headers = headers;
    }

    void addRow(String... values) {
        if (values.length != headers.length) {
            System.out.println("열 수 불일치");
            return;
        }
        rows[rowCount++] = values;
    }

    void print() {
        String header = headers[0];
        for (int i = 1; i < headers.length; i++) {
            header += " | " + headers[i];
        }
        System.out.println(header);
        for (int i = 0; i < rowCount; i++) {
            String row = rows[i][0];
            for (int j = 1; j < rows[i].length; j++) {
                row += " | " + rows[i][j];
            }
            System.out.println(row);
        }
    }
}

public class TableVarargsPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Table t = new Table("이름", "나이", "직업");
        t.addRow("홍길동", "25", "학생");
        t.addRow("김철수", "30", "개발자");
        t.addRow("잘못된", "행");
        t.print();
    }
}
