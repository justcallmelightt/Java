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

public class Q19 {
    public static void main(String[] args) {
        Table t = new Table("이름", "나이", "직업");
        t.addRow("홍길동", "25", "학생");
        t.addRow("김철수", "30", "개발자");
        t.addRow("잘못된", "행");
        t.print();
    }
}
