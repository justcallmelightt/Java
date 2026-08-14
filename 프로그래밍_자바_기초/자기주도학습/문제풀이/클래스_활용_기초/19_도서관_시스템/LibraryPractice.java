/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 19번 문제 - 도서관 시스템 (LibraryPractice.java)
 *
 * 문제 조건:
 * 1. 제목(title), 저자(author), 대출 여부(isBorrowed) 필드를 가진 Book 클래스를 작성하시오.
 * 2. Library 클래스는 Book 배열(10칸)과 등록 수(count) 필드를 가진다.
 * 3. - addBook(Book book) : 책 등록 (10권 초과 시 "등록 불가" 출력)
 * 4. - borrow(String title) : 책 대출. 없으면 "없는 책", 이미 대출 중이면 "대출 중" 출력
 * 5. - returnBook(String title) : 반납. 대출 중이 아니면 "대출된 책이 아닙니다." 출력
 * 6. - printAll() : 전체 목록과 대출 상태 출력
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 배열과 반복문으로 여러 객체 또는 데이터를 순서대로 처리한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Book {
    String title;
    String author;
    boolean isBorrowed;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }
}

class Library {
    Book[] books = new Book[10];
    int count;

    void addBook(Book book) {
        if (count >= 10) {
            System.out.println("등록 불가");
            return;
        }
        books[count++] = book;
    }

    void borrow(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equals(title)) {
                if (books[i].isBorrowed) {
                    System.out.println("대출 중");
                } else {
                    books[i].isBorrowed = true;
                    System.out.println(title + " 대출 완료");
                }
                return;
            }
        }
        System.out.println("없는 책");
    }

    void returnBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equals(title)) {
                if (!books[i].isBorrowed) {
                    System.out.println("대출된 책이 아닙니다.");
                } else {
                    books[i].isBorrowed = false;
                    System.out.println(title + " 반납 완료");
                }
                return;
            }
        }
        System.out.println("없는 책");
    }

    void printAll() {
        for (int i = 0; i < count; i++) {
            String status = books[i].isBorrowed ? "대출 중" : "대출 가능";
            System.out.println("[" + books[i].title + "] " + books[i].author + " 저 - " + status);
        }
    }
}

public class LibraryPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book("자바의 정석", "홍길동"));
        lib.addBook(new Book("클린코드", "김철수"));
        lib.printAll();
        lib.borrow("자바의 정석");
        lib.printAll();
        lib.borrow("자바의 정석");
        lib.returnBook("자바의 정석");
    }
}
