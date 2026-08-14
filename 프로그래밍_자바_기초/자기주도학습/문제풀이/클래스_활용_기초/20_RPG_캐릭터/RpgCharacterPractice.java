/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 20번 문제 - 간단한 RPG 캐릭터 (RpgCharacterPractice.java)
 *
 * 문제 조건:
 * 1. 이름(name), 체력(hp), 공격력(attack), 방어력(defense) 필드를 가진 Character 클래스를 작성하시오.
 * 2. 매개변수 생성자로 초기화한다.
 * 3. - isAlive() : hp > 0이면 true
 * 4. - takeDamage(int damage) : 실제 피해 = damage - defense (최소 1).
 * 5. hp에서 차감. hp가 0 이하가 되면 0으로 고정하고 "N이(가) 쓰러졌습니다." 출력
 * 6. - attackTarget(Character target) : target에게 자신의 attack만큼 데미지를 준다
 * 7. - getStatus() : "이름 | HP: N | 공격력: N | 방어력: N" 형태 반환
 * 8. 두 캐릭터가 서로 번갈아 공격하여 한 명이 쓰러질 때까지 반복하시오.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 * 3. 반복문으로 누적, 검색 또는 상태 변화를 구현한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Character {
    String name;
    int hp;
    int attack;
    int defense;

    Character(String name, int hp, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    boolean isAlive() {
        return hp > 0;
    }

    void takeDamage(int damage) {
        int actual = damage - defense;
        if (actual < 1) actual = 1;
        hp -= actual;
        if (hp <= 0) {
            hp = 0;
            System.out.println(name + "이(가) 쓰러졌습니다.");
        }
    }

    void attackTarget(Character target) {
        int dmg = this.attack - target.defense;
        if (dmg < 1) dmg = 1;
        System.out.println(name + "의 공격! " + target.name + "에게 " + dmg + " 데미지");
        target.takeDamage(this.attack);
    }

    String getStatus() {
        return name + " | HP: " + hp + " | 공격력: " + attack + " | 방어력: " + defense;
    }
}

public class RpgCharacterPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Character warrior = new Character("전사", 100, 30, 10);
        Character mage    = new Character("마법사", 70, 45, 5);

        System.out.println(warrior.getStatus());
        System.out.println(mage.getStatus());
        System.out.println();

        while (warrior.isAlive() && mage.isAlive()) {
            warrior.attackTarget(mage);
            if (!mage.isAlive()) break;
            mage.attackTarget(warrior);
        }

        System.out.println("-- 전투 종료 --");
        System.out.println(warrior.getStatus());
        System.out.println(mage.getStatus());
    }
}
