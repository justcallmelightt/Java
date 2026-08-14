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

public class Q19 {
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
