import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class CharacterStreamDemo {
    public static void main(String[] args) throws IOException {
        try (StringReader reader = new StringReader("Java 문자 스트림");
             StringWriter writer = new StringWriter()) {
            int data;
            while ((data = reader.read()) != -1) {
                writer.write(data);
            }
            System.out.println(writer);
        }
    }
}
