class IdGenerator {
    private static int nextId = 1;

    private IdGenerator() {}

    static int generate() {
        return nextId++;
    }
}

public class Q09 {
    public static void main(String[] args) {
        System.out.println(IdGenerator.generate());
        System.out.println(IdGenerator.generate());
        System.out.println(IdGenerator.generate());
        // IdGenerator ig = new IdGenerator();  // 컴파일 에러
    }
}
