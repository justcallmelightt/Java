public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        try {
            int number = Integer.parseInt("Java");
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("숫자로 변환할 수 없습니다.");
        } finally {
            System.out.println("처리를 종료합니다.");
        }
    }
}
