class StringJoiner {
    static String join(String separator, String... words) {
        if (words.length == 0) {
            return "";
        }
        String result = words[0];
        for (int i = 1; i < words.length; i++) {
            result += separator + words[i];
        }
        return result;
    }
}

public class Q14 {
    public static void main(String[] args) {
        System.out.println(StringJoiner.join("-", "Java", "Python", "C++"));
        System.out.println(StringJoiner.join(", ", "홍길동", "김철수", "이영희"));
        System.out.println(StringJoiner.join("|", "one", "two", "three", "four"));
    }
}
