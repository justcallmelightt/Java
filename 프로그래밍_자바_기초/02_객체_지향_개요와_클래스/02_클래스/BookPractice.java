// BookPractice.java
class Book {
    String title;
    String author;
    int price;

    String getTitle()  { return this.title; }
    String getAuthor() { return this.author; }
    int    getPrice()  { return this.price; }

    void setTitle(String title)   { this.title  = title; }
    void setAuthor(String author) { this.author = author; }

    void setPrice(int price) {
        if (price < 0) {
            System.out.println("에러: 가격은 0 이상이어야 합니다.");
            return;
        }
        this.price = price;
    }

    String getInfo() {
        return "제목: [" + title + "], 저자: [" + author + "], 가격: [" + price + "]원";
    }
}

public class BookPractice {
    public static void main(String[] args) {
        Book b = new Book();
        b.setTitle("자바 프로그래밍");
        b.setAuthor("홍길동");
        b.setPrice(25000);
        System.out.println(b.getInfo());

        // 유효성 검사 확인
        b.setPrice(-1000); // 에러 메시지 출력, price 변경 안 됨
        System.out.println("price = " + b.getPrice()); // 25000 그대로
    }
}
