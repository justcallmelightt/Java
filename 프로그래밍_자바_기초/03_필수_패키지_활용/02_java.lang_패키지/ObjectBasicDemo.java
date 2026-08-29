// ObjectBasicDemo.java
// 주제: Object 클래스 - 참조 비교(==)와 equals()
class Member {
    String name;
    int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // equals()를 재정의하지 않으면 Object의 기본 equals()가 호출되는데,
    // 이는 ==와 똑같이 주소값만 비교한다.
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            Member other = (Member) obj;
            return this.name.equals(other.name) && this.age == other.age;
        } else {
            return false;
        }
    }
}

public class ObjectBasicDemo {
    public static void main(String[] args) {
        // ================================================================
        // 1. 같은 객체를 가리키는 경우 (복사가 아니라 주소 공유)
        // ================================================================
        Member m1 = new Member("이서준", 17);
        Member m2 = m1;  // 새 객체가 아니라 m1과 같은 곳을 가리킴

        m2.age = 18;

        System.out.println("m1.age = " + m1.age); // 18 (같이 바뀜)
        System.out.println("m2.age = " + m2.age); // 18

        System.out.println();

        // ================================================================
        // 2. 내용은 같지만 다른 객체인 경우
        // ================================================================
        Member m3 = new Member("이서준", 18);

        // m1과 m3는 이름, 나이가 똑같지만 완전히 별개의 객체이다.
        // ==는 "같은 객체인가"를 묻는 것이지 "내용이 같은가"를 묻는 게 아니다.
        System.out.println("m1 == m3        : " + (m1 == m3));       // false
        System.out.println("m1.equals(m3)   : " + m1.equals(m3));    // true

        System.out.println();

        // ================================================================
        // 3. equals()를 재정의하지 않으면 벌어지는 일
        // ================================================================
        // Member 클래스에 equals()가 없다고 가정하면,
        // m1.equals(m3)도 m1 == m3와 똑같이 false가 나온다.
        // 즉, "이름과 나이가 같으면 같은 사람"이라는 판단 기준은
        // 우리가 equals()를 직접 정의해줘야만 생긴다.

        System.out.println("문자열에서도 같은 원리:");
        String s1 = new String("hello");
        String s2 = new String("hello");

        System.out.println("s1 == s2        : " + (s1 == s2));       // false
        System.out.println("s1.equals(s2)   : " + s1.equals(s2));    // true
    }
}
