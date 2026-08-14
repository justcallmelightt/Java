class Box<T> {
    private T content;

    void set(T content) {
        this.content = content;
    }

    T get() {
        return content;
    }
}

public class GenericBoxDemo {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.set("Java");
        System.out.println(box.get());
    }
}
