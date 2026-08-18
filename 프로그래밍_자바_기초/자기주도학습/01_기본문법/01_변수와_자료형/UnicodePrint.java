import java.util.Scanner;

public class UnicodePrint {
    public static void main(String[] args) {
        for (int i = 0; i <= 0x10FFFF; i++) {
            if (Character.isValidCodePoint(i)) {
                System.out.printf("U+%04X ", i);
                if (Character.isDefined(i)) {
                    System.out.print(new String(Character.toChars(i)));
                } else {
                    System.out.print("(undefined)");
                }
                System.out.println();
            }
        }
    }
