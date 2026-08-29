import java.util.ArrayList;
import java.util.List;

public class ListCollectionDemo {
    public static void main(String[] args) {
        List<String> subjects = new ArrayList<>();
        subjects.add("Java");
        subjects.add("Database");
        subjects.add("Network");

        for (String subject : subjects) {
            System.out.println(subject);
        }
    }
}
