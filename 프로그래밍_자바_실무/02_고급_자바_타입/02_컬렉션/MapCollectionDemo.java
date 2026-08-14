import java.util.HashMap;
import java.util.Map;

public class MapCollectionDemo {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Java", 95);
        scores.put("Database", 88);

        System.out.println(scores.get("Java"));
    }
}
