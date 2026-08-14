class Contact {
    String address;
    String phone;
    String email;

    Contact(String address, String phone, String email) {
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    Contact(String address, String phone) {
        this(address, phone, "없음");
    }

    Contact() {
        this("미정", "미정");
    }

    String getInfo() {
        return address + " / " + phone + " / " + email;
    }
}

public class Q21 {
    public static void main(String[] args) {
        Contact c1 = new Contact();
        Contact c2 = new Contact("서울", "010-1234-5678");
        Contact c3 = new Contact("부산", "010-9999-0000", "hong@test.com");
        System.out.println(c1.getInfo());
        System.out.println(c2.getInfo());
        System.out.println(c3.getInfo());
    }
}
