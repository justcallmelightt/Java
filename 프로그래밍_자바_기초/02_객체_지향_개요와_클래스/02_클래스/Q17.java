class Person {
    String name;
    int age;
    String job;

    Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }
}

public class Q17 {
    public static void main(String[] args) {
        Person[] people = {
            new Person("홍길동", 25, "학생"),
            new Person("김철수", 35, "개발자"),
            new Person("이영희", 28, "디자이너"),
            new Person("박민준", 42, "교수"),
            new Person("최수연", 31, "의사")
        };

        for (int i = 0; i < people.length; i++) {
            if (people[i].age >= 30) {
                System.out.println(people[i].name + " (" + people[i].age + "세) - " + people[i].job);
            }
        }
    }
}
