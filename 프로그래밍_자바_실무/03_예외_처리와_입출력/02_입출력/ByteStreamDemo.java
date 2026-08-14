import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteStreamDemo {
    public static void main(String[] args) throws IOException {
        byte[] source = {65, 66, 67};

        try (ByteArrayInputStream input = new ByteArrayInputStream(source);
             ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            int data;
            while ((data = input.read()) != -1) {
                output.write(data);
            }
            System.out.println(output.toString());
        }
    }
}
