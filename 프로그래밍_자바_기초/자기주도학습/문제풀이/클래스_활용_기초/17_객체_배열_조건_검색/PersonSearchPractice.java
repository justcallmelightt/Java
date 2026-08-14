/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 17번 문제 - 객체 배열과 조건 검색 (PersonSearchPractice.java)
 *
 * 문제 조건:
 * 1. 이름(name), 나이(age), 직업(job) 필드를 가진 Person 클래스를 작성하시오.
 * 2. 매개변수 생성자로 5명의 Person 배열을 만들고,
 * 3. 나이가 30세 이상인 사람만 출력하시오.
 * 4. 데이터 :
 * 5. ("홍길동", 25, "학생"), ("김철수", 35, "개발자"),
 * 6. ("이영희", 28, "디자이너"), ("박민준", 42, "교수"), ("최수연", 31, "의사")
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 * 3. 배열과 반복문으로 여러 객체 또는 데이터를 순서대로 처리한다.
 * 4. 조건문으로 잘못된 입력과 경계 상황을 검사한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

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

public class PersonSearchPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
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
